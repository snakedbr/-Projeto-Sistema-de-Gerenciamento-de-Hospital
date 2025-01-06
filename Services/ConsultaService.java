package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsultaService {

    private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    // Método para agendar uma consulta
    public boolean agendarConsulta(Paciente paciente, Medico medico, String dataHoraStr, Agenda agenda) throws ParseException {
        Date dataHoraConsulta = formatoData.parse(dataHoraStr);
        Consulta consultaExistente = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

        if (consultaExistente != null) {
            return false;  // Já existe uma consulta marcada
        }

        agenda.agendarConsulta(paciente, medico, dataHoraConsulta);
        return true;
    }

    // Método para realizar uma consulta
    public boolean realizarConsulta(Paciente paciente, Medico medico, String dataHoraStr, Agenda agenda, String diagnostico, String tratamento) throws ParseException {
        Date dataHoraConsulta = formatoData.parse(dataHoraStr);
        Consulta consultaExistente = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

        if (consultaExistente == null) {
            return false;  // Nenhuma consulta encontrada
        }

        medico.diagnosticar(paciente, diagnostico);
        medico.prescreverTratamento(paciente, tratamento);

        consultaExistente.setDiagnostico(diagnostico);
        consultaExistente.setTratamento(tratamento);
        consultaExistente.registrarConsulta();  // Registra a consulta
        return true;
    }

    // Método para cancelar uma consulta
    public boolean cancelarConsulta(Paciente paciente, Medico medico, String dataHoraStr, Agenda agenda) throws ParseException {
        Date dataHoraConsulta = formatoData.parse(dataHoraStr);
        Consulta consultaParaCancelar = agenda.buscarConsulta(paciente, medico, dataHoraConsulta);

        if (consultaParaCancelar == null) {
            return false;  // Nenhuma consulta encontrada
        }

        agenda.cancelarConsulta(consultaParaCancelar);
        return true;
    }
}