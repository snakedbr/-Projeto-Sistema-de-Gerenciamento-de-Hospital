package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.*;
import com.estudodirigido.hospital.Services.PacienteService;
import java.util.Scanner;

public class PacienteController {

    private PacienteService pacienteService;

    // O controller agora recebe o PacienteService via injeção no construtor
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Método do controller que delega a lógica de negócio ao service
    public void checarHistorico(Scanner scanner, Hospital hospital) {
        // O controller delega a operação ao serviço
        pacienteService.checarHistorico(scanner, hospital);
    }

    public void assistirPaciente(Scanner scanner, Hospital hospital, Enfermeiro enfermeiro) {
        System.out.println("\n--- Assistir Paciente ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);
        if (paciente != null) {
            enfermeiro.assistirPaciente(paciente);

            System.out.println("\n--- Histórico Atualizado do Paciente ---");
            for (String historia : paciente.getHistorico()) {
                System.out.println(historia);
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    // Método para cadastrar um paciente, delegando a lógica para o PacienteService
    public void cadastrarPaciente(Scanner scanner) {
        Paciente novoPaciente = pacienteService.cadastrarPaciente(scanner);

        if (novoPaciente != null) {
            System.out.println("Paciente cadastrado com sucesso: " + novoPaciente.getNome());
        } else {
            System.out.println("Erro ao cadastrar paciente.");
        }
    }
}