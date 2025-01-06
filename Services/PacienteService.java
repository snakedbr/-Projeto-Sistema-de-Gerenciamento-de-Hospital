package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Paciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class PacienteService {

    private HashSet<String> cpfs;

    public PacienteService(HashSet<String> cpfs) {
        this.cpfs = cpfs;
    }

    // Método para cadastrar um paciente, aplicando as regras de negócio
    public Paciente cadastrarPaciente(Scanner scanner) {
        System.out.println("\n--- Cadastro de Paciente ---");

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consome a quebra de linha deixada pelo nextInt

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        // Verifica se o CPF já está cadastrado
        if (cpfs.contains(cpf)) {
            System.out.println("Erro: Já existe um paciente cadastrado com o CPF " + cpf);
            return null;
        }

        System.out.print("Digite o endereço do paciente: ");
        String endereco = scanner.nextLine();

        int prontuario = (int) (Math.random() * 10000);
        Date dataCadastro = new Date();

        Paciente paciente = new Paciente(prontuario, dataCadastro, nome, idade, cpf, endereco);
        cpfs.add(cpf);  // Adiciona o CPF ao conjunto de CPFs

        return paciente;
    }

    // Método para checar o histórico de um paciente
    public void checarHistorico(Scanner scanner, Hospital hospital) {
        System.out.println("\n--- Checar Histórico do Paciente ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPacienteHistorico = scanner.nextLine();

        // Busca o paciente no hospital para exibir o histórico
        Paciente pacienteHistorico = hospital.buscarPacientePorCPF(cpfPacienteHistorico);
        if (pacienteHistorico != null) {
            System.out.println("Histórico do Paciente " + pacienteHistorico.getNome() + ":");

            // Obtém o histórico de saúde do paciente
            ArrayList<String> historicoDeSaude = pacienteHistorico.getHistorico();

            // Verifica se o histórico está vazio
            if (historicoDeSaude.isEmpty()) {
                System.out.println("Nenhum histórico de saúde registrado para este paciente.");
            } else {
                for (String historico : historicoDeSaude) {
                    System.out.println(historico);
                }
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}