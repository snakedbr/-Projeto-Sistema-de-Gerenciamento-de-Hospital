package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.*;
import com.estudodirigido.hospital.Services.AgendaService;

import java.util.Scanner;

public class AgendaController {

    private final AgendaService agendaService;

    // O controller agora recebe o AgendaService via injeção no construtor
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    // Método para marcar uma consulta
    public void marcarConsulta(Scanner scanner, Hospital hospital) {
        System.out.println("\n--- Marcar Consulta ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.nextLine();

        Medico medico = hospital.buscarMedicoPorCRM(crmMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        // Delegar a lógica de agendamento para o AgendaService
        agendaService.agendarConsultaComData(paciente, medico, dataHoraConsultaStr);
    }

    // Método para realizar uma consulta
    public void realizarConsulta(Scanner scanner, Hospital hospital) {
        System.out.println("\n--- Realizar Consulta ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.nextLine();

        Medico medico = hospital.buscarMedicoPorCRM(crmMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        // Delegar a lógica de realização de consulta para o AgendaService
        agendaService.realizarConsulta(scanner, paciente, medico, dataHoraConsultaStr);
    }

    // Método para cancelar uma consulta
    public void cancelarConsulta(Scanner scanner, Hospital hospital) {
        System.out.println("\n--- Cancelar Consulta ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.nextLine();

        Medico medico = hospital.buscarMedicoPorCRM(crmMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        // Delegar a lógica de cancelamento de consulta para o AgendaService
        agendaService.cancelarConsulta(scanner, paciente, medico, dataHoraConsultaStr);
    }
}