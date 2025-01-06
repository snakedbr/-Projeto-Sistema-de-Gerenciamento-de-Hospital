package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Agenda;
import com.estudodirigido.hospital.Medico;
import com.estudodirigido.hospital.Paciente;
import com.estudodirigido.hospital.Consulta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AgendaService {

    private final Agenda agenda;

    public AgendaService(Agenda agenda) {
        this.agenda = agenda;
    }

    // Método para agendar uma consulta
    public void agendarConsultaComData(Paciente paciente, Medico medico, String dataHoraStr) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            Date dataHoraConsulta = formatoData.parse(dataHoraStr);
            Consulta consultaExistente = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

            if (consultaExistente != null) {
                System.out.println("Já existe uma consulta marcada para esse horário.");
            } else {
                agenda.agendarConsulta(paciente, medico, dataHoraConsulta);
                System.out.println("Consulta marcada com sucesso para: " + formatoData.format(dataHoraConsulta));
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }

    // Método para realizar uma consulta
    public void realizarConsulta(Scanner scanner, Paciente paciente, Medico medico, String dataHoraStr) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            Date dataHoraConsulta = formatoData.parse(dataHoraStr);
            Consulta consulta = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

            if (consulta != null) {
                System.out.println("Consulta encontrada. Realizando a consulta...");

                System.out.print("Digite o diagnóstico: ");
                String diagnostico = scanner.nextLine();
                medico.diagnosticar(paciente, diagnostico);

                System.out.print("Digite o tratamento: ");
                String tratamento = scanner.nextLine();
                medico.prescreverTratamento(paciente, tratamento);

                consulta.setDiagnostico(diagnostico);
                consulta.setTratamento(tratamento);
                consulta.registrarConsulta();

                System.out.println("Consulta realizada com sucesso.");

            } else {
                System.out.println("Nenhuma consulta encontrada para o horário especificado.");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }

    // Método para cancelar uma consulta
    public void cancelarConsulta(Scanner scanner, Paciente paciente, Medico medico, String dataHoraStr) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            Date dataHoraConsulta = formatoData.parse(dataHoraStr);
            Consulta consulta = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

            if (consulta != null) {
                agenda.cancelarConsulta(consulta);
                System.out.println("Consulta cancelada com sucesso.");
            } else {
                System.out.println("Nenhuma consulta encontrada para o horário especificado.");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data e hora inválido. Use o formato: dd/MM/yyyy HH:mm");
        }
    }
}