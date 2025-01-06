/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital;

/**
 *
 * @author SnakeD
 */
public abstract class Funcionario extends Pessoa {

    //  Representa um funcionário genérico do hospital. Será usada como classe base para outras subclasses de funcionários.
    private int idFuncionario;
    private double salario;
    private String departamento;

    public Funcionario(int idFuncionario, double salario, String departamento, String nome, int idade, String CPF, String endereco) {
        super(nome, idade, CPF, endereco);
        this.idFuncionario = idFuncionario;
        this.salario = salario;
        this.departamento = departamento;
    }

    public abstract int getNivelAcesso(); // Método abstrato que será implementado nas subclasses

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

// Método abstrato para calcular o salário com bonificações
    public abstract double calcularSalario(int atendimentosExtras, double valorPorAtendimentoExtra);

}
