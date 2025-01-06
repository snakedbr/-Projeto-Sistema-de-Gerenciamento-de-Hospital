package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Services.EnfermeiroService;

import java.util.Scanner;

public class EnfermeiroController {

    private EnfermeiroService enfermeiroService;

    // O controller recebe o EnfermeiroService via injeção no construtor
    public EnfermeiroController(EnfermeiroService enfermeiroService) {
        this.enfermeiroService = enfermeiroService;
    }

    // Método para cadastrar um enfermeiro
    public void cadastrarEnfermeiro(Scanner scanner) {
        System.out.println("\n--- Cadastro de Enfermeiro ---");

        System.out.print("Digite o nome do enfermeiro: ");
        String nomeEnfermeiro = scanner.nextLine();

        System.out.print("Digite a idade do enfermeiro: ");
        int idadeEnfermeiro = scanner.nextInt();
        scanner.nextLine();  // Consome a quebra de linha do scanner

        System.out.print("Digite o CPF do enfermeiro: ");
        String cpfEnfermeiro = scanner.nextLine();

        // Verifica se o CPF já foi cadastrado
        if (enfermeiroService.cpfExiste(cpfEnfermeiro)) {
            System.out.println("Erro: Já existe um enfermeiro cadastrado com o CPF " + cpfEnfermeiro);
            return;
        }

        System.out.print("Digite o endereço do enfermeiro: ");
        String enderecoEnfermeiro = scanner.nextLine();

        System.out.print("Digite o Coren do enfermeiro: ");
        String coren = scanner.nextLine();

        // Verifica se o Coren já foi cadastrado
        if (enfermeiroService.corenExiste(coren)) {
            System.out.println("Erro: Já existe um enfermeiro cadastrado com o Coren " + coren);
            return;
        }

        System.out.print("Digite o turno do enfermeiro: ");
        String turno = scanner.nextLine();

        System.out.print("Informe o salário do enfermeiro: ");
        double salario = scanner.nextDouble();

        // Cria o enfermeiro usando o serviço
        Enfermeiro novoEnfermeiro = enfermeiroService.criarEnfermeiro(nomeEnfermeiro, idadeEnfermeiro, cpfEnfermeiro, enderecoEnfermeiro, coren, turno, salario);

        System.out.println("\nEnfermeiro cadastrado com sucesso!\n");
        System.out.println("Nome: " + novoEnfermeiro.getNome());
        System.out.println("Turno: " + novoEnfermeiro.getTurno());
        System.out.println("Salário: R$ " + novoEnfermeiro.getSalario());
    }

    // Método para assistir um paciente
    public void assistirPaciente(Scanner scanner, Hospital hospital, Enfermeiro enfermeiro) {
        System.out.println("\n--- Assistir Paciente ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        // Usa o serviço para assistir o paciente
        String resultado = enfermeiroService.assistirPaciente(hospital, enfermeiro, cpfPaciente);
        System.out.println(resultado);
    }
}