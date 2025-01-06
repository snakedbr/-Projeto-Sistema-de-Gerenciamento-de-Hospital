package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.*;
import com.estudodirigido.hospital.Services.ConsultaService;

import java.text.ParseException;
import java.util.Scanner;

public class ConsultaController {

    private ConsultaService consultaService;

    // Construtor recebe o serviço de consulta
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    // Método para marcar uma consulta
    public void marcarConsulta(Scanner scanner, Hospital hospital, Agenda agenda) {
        System.out.println("\n--- Marcar Consulta ---");

        Paciente pacienteMarcacao = buscarPaciente(scanner, hospital);
        if (pacienteMarcacao == null) return;

        Medico medicoMarcacao = buscarMedico(scanner, hospital);
        if (medicoMarcacao == null) return;

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        try {
            boolean consultaMarcada = consultaService.agendarConsulta(pacienteMarcacao, medicoMarcacao, dataHoraConsultaStr, agenda);
            if (consultaMarcada) {
                System.out.println("Consulta marcada com sucesso para: " + dataHoraConsultaStr);
            } else {
                System.out.println("Já existe uma consulta marcada para esse horário.");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }

    // Método para realizar uma consulta
    public void realizarConsulta(Scanner scanner, Hospital hospital, Agenda agenda) {
        System.out.println("\n--- Realizar Consulta ---");

        Paciente pacienteConsultado = buscarPaciente(scanner, hospital);
        if (pacienteConsultado == null) return;

        Medico medicoConsultado = buscarMedico(scanner, hospital);
        if (medicoConsultado == null) return;

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        System.out.print("Digite o diagnóstico: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Digite o tratamento: ");
        String tratamento = scanner.nextLine();

        try {
            boolean consultaRealizada = consultaService.realizarConsulta(pacienteConsultado, medicoConsultado, dataHoraConsultaStr, agenda, diagnostico, tratamento);
            if (consultaRealizada) {
                System.out.println("Consulta realizada com sucesso.");
            } else {
                System.out.println("Nenhuma consulta encontrada para esse paciente e médico nesse horário.");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }

    // Método para cancelar uma consulta
    public void cancelarConsulta(Scanner scanner, Hospital hospital, Agenda agenda) {
        System.out.println("\n--- Cancelar Consulta ---");

        Paciente pacienteCancelamento = buscarPaciente(scanner, hospital);
        if (pacienteCancelamento == null) return;

        Medico medicoCancelamento = buscarMedico(scanner, hospital);
        if (medicoCancelamento == null) return;

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraConsultaStr = scanner.nextLine();

        try {
            boolean consultaCancelada = consultaService.cancelarConsulta(pacienteCancelamento, medicoCancelamento, dataHoraConsultaStr, agenda);
            if (consultaCancelada) {
                System.out.println("Consulta cancelada com sucesso.");
            } else {
                System.out.println("Nenhuma consulta encontrada para o horário especificado.");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }

    // Método auxiliar para buscar paciente
    private Paciente buscarPaciente(Scanner scanner, Hospital hospital) {
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        }
        return paciente;
    }

    // Método auxiliar para buscar médico
    private Medico buscarMedico(Scanner scanner, Hospital hospital) {
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.nextLine();
        Medico medico = hospital.buscarMedicoPorCRM(crmMedico);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
        }
        return medico;
    }
}