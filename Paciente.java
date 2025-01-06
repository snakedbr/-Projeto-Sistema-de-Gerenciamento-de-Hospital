/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SnakeD
 */
public class Paciente extends Pessoa {

    // descrição classe: Representa um paciente do hospital. Inclui um histórico de saúde e um prontuário único.
    private ArrayList<String> historicoDeSaude = new ArrayList<String>();
    private int prontuario;
    private Date dataCadastro;

    public Paciente(int prontuario, Date dataCadastro, String nome, int idade, String CPF, String endereco) {
        super(nome, idade, CPF, endereco);
        this.prontuario = prontuario;
        this.dataCadastro = dataCadastro;
    }

    public ArrayList<String> getHistoricoDeSaude() {
        return historicoDeSaude;
    }

    public void setHistoricoDeSaude(ArrayList<String> historicoDeSaude) {
        this.historicoDeSaude = historicoDeSaude;
    }

    public int getProntuario() {
        return prontuario;
    }

    public void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Método para adicionar uma entrada no histórico de saúde
    public void adicionarHistorico(String entrada) {
        historicoDeSaude.add(entrada);
    }

    // Método para obter o histórico completo de saúde
    public ArrayList<String> getHistorico() {
        return historicoDeSaude;
    }

    // Método para exibir o histórico de saúde formatado
    public void exibirHistorico() {
        System.out.println("\n--- Histórico de Saúde ---");
        if (historicoDeSaude.isEmpty()) {
            System.out.println("Nenhum histórico de saúde registrado para este paciente.");
        } else {
            for (String entrada : historicoDeSaude) {
                System.out.println(entrada);
            }
        }
        System.out.println("----------------------------");
    }

    // Método para notificar o paciente
    public void enviarNotificacao(String mensagem) {
        // Aqui estamos simulando o envio de uma notificação
        System.out.println("Notificação enviada para " + nome + ": " + mensagem);
    }
    
    @Override
    public String getInfo() {
        return "Nome: " + nome + "\n"
                + "Idade: " + idade + "\n"
                + "CPF: " + CPF + "\n"
                + "Endereço: " + endereco + "\n"
                + "Prontuário: " +prontuario+ "\n"
                + "Data Cadastro" + dataCadastro;
        //        + "NOTIFICAÇÃO DE CONSULTA \\ Consulta marcada para o dia: "  
    }
}
