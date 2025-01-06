/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital;

/**
 *
 * @author SnakeD
 */
public class Administrador extends Funcionario {

    // Representa um administrador do hospital, responsável pela administração de recursos humanos e controle de nível de acesso.
   private int nivelAcesso = 1;

    public Administrador(int idFuncionario, double salario, String departamento, String nome, int idade, String CPF, String endereco) {
        super(idFuncionario, salario, departamento, nome, idade, CPF, endereco);
    }

    @Override
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public void gerenciarFuncionario(Funcionario funcionario, Hospital hospital) {
        // Admite o funcionário no hospital
        hospital.admitirFuncionario(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " foi admitido com sucesso.");
    }

  @Override
    public double calcularSalario(int atendimentosExtras, double valorPorAtendimentoExtra) {
        // Salário final = Salário base + bonificação por atendimentos extras
        return getSalario() + (atendimentosExtras * valorPorAtendimentoExtra);
    }

}
