package com.estudodirigido.hospital;

public class Pessoa {

    // Classe abstrata que serve como base para outras classes de pessoa. Contém os atributos comuns a todas as pessoas no sistema.
    String nome;
    int idade;
    String CPF;
    String endereco;

    public Pessoa(String nome, int idade, String CPF, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInfo() {
        return "Nome: " + nome + "\n"
                + "Idade: " + idade + "\n"
                + "CPF: " + CPF + "\n"
                + "Endereço: " + endereco;
    }
}
