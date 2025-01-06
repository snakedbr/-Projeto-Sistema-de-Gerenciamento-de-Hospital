package com.estudodirigido.hospital;

import java.util.*;

public class Relatorio {

    private final List<Consulta> consultas;

    // Construtor: Recebe a lista de consultas para geração dos relatórios
    public Relatorio(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    // Relatório do número de pacientes atendidos por cada médico 
    public void gerarRelatorioPacientesPorMedico() {
        Set<Medico> medicosListados = new HashSet<>();

        System.out.println("\n--- Relatório de Pacientes por Médico ---");

        // Para cada médico na lista de consultas
        for (Consulta consulta : consultas) {
            Medico medico = consulta.getMedico();

            // Evita listar o mesmo médico várias vezes
            if (medicosListados.contains(medico)) {
                continue;
            }

            // Conta o número de pacientes únicos atendidos por esse médico
            int pacientesAtendidos = contarPacientesPorMedico(medico);

            // Exibe o resultado
            System.out.println("Médico: " + medico.getNome() + " | Pacientes Atendidos: " + pacientesAtendidos);

            // Marca o médico como já listado
            medicosListados.add(medico);
        }
    }

    // Método auxiliar para contar pacientes únicos atendidos por um médico
    private int contarPacientesPorMedico(Medico medico) {
        List<Paciente> pacientesAtendidos = new ArrayList<>();

        // Percorre as consultas e verifica os pacientes atendidos por esse médico
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) && !pacientesAtendidos.contains(consulta.getPaciente())) {
                pacientesAtendidos.add(consulta.getPaciente());
            }
        }

        // Retorna o número de pacientes únicos
        return pacientesAtendidos.size();
    }

    // Relatório do número total de consultas realizadas no mês 
    public void gerarRelatorioConsultasPorMes(int mes, int ano) {
        int totalConsultas = 0;
        // a linha abaixo obtém uma instância do objeto Calendar configurada para a data e hora atuais
        Calendar cal = Calendar.getInstance();

        // Contagem das consultas no mês e ano especificados
        for (Consulta consulta : consultas) {
            cal.setTime(consulta.getDataConsulta());

            int consultaMes = cal.get(Calendar.MONTH) + 1; // Janeiro é 0, por isso adicionamos 1
            int consultaAno = cal.get(Calendar.YEAR);

            if (consultaMes == mes && consultaAno == ano) {
                totalConsultas++;
            }
        }

        // Exibe o relatório
        System.out.println("\n--- Relatório de Consultas no Mês " + mes + "/" + ano + " ---");
        System.out.println("Total de consultas realizadas: " + totalConsultas);
    }
}