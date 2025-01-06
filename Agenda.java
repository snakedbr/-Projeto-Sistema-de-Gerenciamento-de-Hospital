package com.estudodirigido.hospital;

import java.util.ArrayList;
import java.util.Date;

public class Agenda {

    private ArrayList<Consulta> consultas;

    //Gerencia a agenda do hospital, permitindo o agendamento e cancelamento de consultas.
    // Construtor: Inicializa a lista de consultas
    public Agenda() {
        this.consultas = new ArrayList<>();
    }
    
    public ArrayList<Consulta> getConsultas() {
    return this.consultas;
}

    // Método para verificar se uma consulta já está marcada para o paciente, médico e horário
    public Consulta buscarConsulta(Paciente paciente, Medico medico, Date dataHora) {
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(paciente)
                    && consulta.getMedico().equals(medico)
                    && consulta.getDataConsulta().equals(dataHora)) {
                return consulta; // Consulta encontrada
            }
        }
        return null; // Consulta não encontrada
    }

    public boolean verificarDisponibilidade(Medico medico, Date dataHora) {
        for (Consulta consulta : consultas) {
            // Verifica se o médico está ocupado no horário
            if (consulta.getMedico().equals(medico) && consulta.getDataConsulta().equals(dataHora)) {
                return false; // Médico já tem uma consulta nesse horário
            }
        }
        return true; // Médico está disponível
    }

    public boolean verificarDisponibilidadePaciente(Paciente paciente, Date dataHora) {
        for (Consulta consulta : consultas) {
            // Verifica se o paciente já tem uma consulta no horário
            if (consulta.getPaciente().equals(paciente) && consulta.getDataConsulta().equals(dataHora)) {
                return false; // Paciente já tem uma consulta nesse horário
            }
        }
        return true; // Paciente está disponível
    }

    // Método para agendar uma nova consulta (somente se o médico estiver disponível)
    public void agendarConsulta(Paciente paciente, Medico medico, Date dataHora) {
        // Verifica a disponibilidade do médico e do paciente
        if (verificarDisponibilidade(medico, dataHora) && verificarDisponibilidadePaciente(paciente, dataHora)) {
            Consulta novaConsulta = new Consulta(paciente, medico, "Diagnóstico pendente", dataHora, "Tratamento pendente");
            consultas.add(novaConsulta);
            // Notificação ao paciente
            paciente.enviarNotificacao("Sua consulta com o Dr. " + medico.getNome() + " foi agendada para " + dataHora);
            System.out.println("Consulta agendada com sucesso para o paciente " + paciente.getNome() + " com o médico " + medico.getNome() + " em " + dataHora);
        } else {
            System.out.println("Erro: O médico ou o paciente já têm uma consulta agendada nesse horário.");
        }
    }

    // Método para cancelar uma consulta
    public void cancelarConsulta(Consulta consulta) {
        if (consultas.contains(consulta)) {
            consultas.remove(consulta);
            consulta.getPaciente().enviarNotificacao("Sua consulta com o Dr. " + consulta.getMedico().getNome() 
                    + " em " + consulta.getDataConsulta() + " foi cancelada.");
            System.out.println("Consulta cancelada com sucesso para o paciente " + consulta.getPaciente().getNome() 
                    + " com o médico " + consulta.getMedico().getNome() + " em " + consulta.getDataConsulta());
        } else {
            System.out.println("Erro: Consulta não encontrada.");
        }
    }

}
