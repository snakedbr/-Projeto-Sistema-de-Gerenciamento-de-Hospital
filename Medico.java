package com.estudodirigido.hospital;

import java.util.ArrayList;

public class Medico extends Funcionario {

    // Representa um médico do hospital. Além dos atributos de Funcionario, possui a especialidade médica e o CRM.
    private int nivelAcesso = 2;  // Define o nível de acesso para médicos como 2
    private String especialidade;
    private String CRM;
    private ArrayList<Paciente> pacientesAtendidos;  // Lista de pacientes atendidos pelo médico

    // Construtor da classe Medico com os atributos herdados de Funcionario
    public Medico(String especialidade, String CRM, int idFuncionario, double salario, String departamento, String nome, int idade, String CPF, String endereco) {
        super(idFuncionario, salario, departamento, nome, idade, CPF, endereco);
        this.especialidade = especialidade;
        this.CRM = CRM;
        this.pacientesAtendidos = new ArrayList<>();  // Inicializa a lista de pacientes atendidos
    }

    @Override
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    // Getters e Setters para os atributos da classe Medico
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public ArrayList<Paciente> getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(ArrayList<Paciente> pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    // Método para diagnosticar um paciente. Adiciona o paciente à lista de pacientes atendidos.
    public void diagnosticar(Paciente paciente, String diagnostico) {
        System.out.println("Médico " + this.getNome() + " diagnosticou o paciente " + paciente.getNome() + " com: " + diagnostico);
        paciente.adicionarHistorico("Diagnóstico: " + diagnostico);
        if (!pacientesAtendidos.contains(paciente)) {
            pacientesAtendidos.add(paciente);  // Adiciona o paciente à lista se ainda não foi atendido
        }
    }

    // Método para prescrever um tratamento ao paciente. Adiciona o tratamento ao histórico do paciente.
    public void prescreverTratamento(Paciente paciente, String tratamento) {
        System.out.println("Médico " + this.getNome() + " prescreveu o seguinte tratamento para o paciente " + paciente.getNome() + ": " + tratamento);
        paciente.adicionarHistorico("Tratamento: " + tratamento);
    }
    
      @Override
    public double calcularSalario(int atendimentosExtras, double valorPorAtendimentoExtra) {
        // Salário final = Salário base + bonificação por atendimentos extras
        return getSalario() + (atendimentosExtras * valorPorAtendimentoExtra);
    }
}
