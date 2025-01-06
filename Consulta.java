package com.estudodirigido.hospital;

import java.util.Date;

public class Consulta {

    // Representa uma consulta realizada no hospital, contendo informações sobre o paciente, o médico, o diagnóstico e o tratamento.
    private Paciente paciente;
    private Medico medico;
    private String diagnostico;
    private Date dataConsulta;
    private String tratamento;

    // Construtor da classe Consulta
    public Consulta(Paciente paciente, Medico medico, String diagnostico, Date dataConsulta, String tratamento) {
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
        this.dataConsulta = dataConsulta;
        this.tratamento = tratamento;
    }

    // Construtor alternativo sem diagnóstico e tratamento
    public Consulta(Paciente paciente, Medico medico, Date dataConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.diagnostico = "";  // Inicializa com string vazia ou nulo
        this.tratamento = "";   // Inicializa com string vazia ou nulo
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        if (diagnostico != null && !diagnostico.isEmpty()) {
            this.diagnostico = diagnostico;
        } else {
            System.out.println("Diagnóstico inválido.");
        }
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        if (tratamento != null && !tratamento.isEmpty()) {
            this.tratamento = tratamento;
        } else {
            System.out.println("Tratamento inválido.");
        }
    }

    /**
     * Método para registrar a consulta. Isso mantém a data da consulta já
     * definida e registra a consulta no histórico.
     */
    public void registrarConsulta() {
        if (diagnostico == null || diagnostico.isEmpty()) {
            System.out.println("Erro: Diagnóstico não pode ser vazio.");
            return;
        }

        if (tratamento == null || tratamento.isEmpty()) {
            System.out.println("Erro: Tratamento não pode ser vazio.");
            return;
        }

        // Detalhes da consulta
        String detalhesConsulta = "Data: " + dataConsulta
                + ", Médico: " + medico.getNome()
                + ", Diagnóstico: " + diagnostico
                + ", Tratamento: " + tratamento;

        // Adiciona os detalhes da consulta ao histórico do paciente
        paciente.adicionarHistorico(detalhesConsulta);

        System.out.println("Consulta registrada com sucesso para o paciente: " + paciente.getNome());
    }

    /**
     * Método para visualizar os detalhes da consulta.
     */
    public void visualizarConsulta() {
        System.out.println("\n--- Detalhes da Consulta ---");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Tratamento: " + tratamento);
        System.out.println("Data da Consulta: " + dataConsulta);
        System.out.println("---------------------------");
    }
}
