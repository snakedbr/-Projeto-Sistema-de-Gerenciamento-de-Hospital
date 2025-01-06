package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.Medico;
import com.estudodirigido.hospital.Services.MedicoService;

import java.util.Scanner;
import java.util.Set;

public class MedicoController {

    private MedicoService medicoService;

    // O controller recebe o MedicoService via injeção de dependência
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public void cadastrarMedico(Scanner scanner) {
        System.out.println("\n--- Cadastro de Médico ---");

        System.out.print("Digite o nome do médico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite a idade do médico: ");
        int idadeMedico = scanner.nextInt();
        scanner.nextLine();  // Consome a quebra de linha

        System.out.print("Digite o CPF do médico: ");
        String cpfMedico = scanner.nextLine();

        // Verifica se o CPF já existe
        if (medicoService.cpfExiste(cpfMedico)) {
            System.out.println("Erro: Já existe um médico cadastrado com o CPF " + cpfMedico);
            return;
        }

        System.out.print("Digite o endereço do médico: ");
        String enderecoMedico = scanner.nextLine();

        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();

        // Verifica se o CRM já existe
        if (medicoService.crmExiste(crm)) {
            System.out.println("Erro: Já existe um médico cadastrado com o CRM " + crm);
            return;
        }

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = scanner.nextLine();

        System.out.print("Informe o salário do médico: ");
        double salario = scanner.nextDouble();

        // Cria o novo médico e o salva no MedicoService
        Medico novoMedico = medicoService.criarMedico(nomeMedico, idadeMedico, cpfMedico, enderecoMedico, crm, especialidade, salario);

        System.out.println("\nMédico cadastrado com sucesso!\n");
        System.out.println("Nome: " + novoMedico.getNome());
        System.out.println("Especialidade: " + novoMedico.getEspecialidade());
        System.out.println("Salário: R$ " + novoMedico.getSalario());
    }

    // Método para exibir todos os médicos cadastrados
    public void listarMedicos() {
        Set<Medico> medicos = medicoService.listarMedicos();

        if (medicos.isEmpty()) {
            System.out.println("\nNenhum médico cadastrado.\n");
        } else {
            System.out.println("\n--- Lista de Médicos Cadastrados ---");
            for (Medico medico : medicos) {
                System.out.println("Nome: " + medico.getNome() + ", CRM: " + medico.getCRM() + ", Especialidade: " + medico.getEspecialidade());
            }
            System.out.println("------------------------------------\n");
        }
    }
}