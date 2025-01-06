package com.estudodirigido.hospital;

import java.util.ArrayList;
import java.util.HashSet;

public class Hospital {

    // Atributos do hospital
    private String nome;
    private String endereco;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    // Conjunto para armazenar os CPFs dos pacientes e garantir unicidade
    private HashSet<String> cpfs = new HashSet<>();

    public Hospital(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(ArrayList<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    // Método para admitir um funcionário (incluindo enfermeiros)
    public void admitirFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void admitirEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }

    // Método para admitir um paciente
    public void admitirPaciente(Paciente paciente) {
        pacientes.add(paciente);
        cpfs.add(paciente.getCPF()); // Adiciona o CPF ao HashSet
    }

    // Método para admitir um médico
    public void admitirMedico(Medico medico) {
        medicos.add(medico);
    }

    // Método para listar os funcionários
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("- " + funcionario.getNome());
        }
    }

    // Método para listar os pacientes
    public void listarPacientes() {
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("- " + paciente.getInfo());
        }
    }

    // Método para buscar paciente pelo CPF
    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCPF().equals(cpf)) {
                return paciente;
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }

    // Método para buscar médico pelo CRM
    public Medico buscarMedicoPorCRM(String crmMedico) {
        for (Medico medico : medicos) {
            if (medico.getCRM().equals(crmMedico)) {
                return medico; // Médico encontrado
            }
        }
        return null; // Médico não encontrado
    }

    // Método para buscar enfermeiro pelo COREN
    public Enfermeiro buscarEnfermeiroPorCOREN(String corenEnfermeiro) {
        for (Enfermeiro enfermeiro : enfermeiros) {
            if (enfermeiro.getCoren().equals(corenEnfermeiro)) {
                return enfermeiro; // Enfermeiro encontrado
            }
        }
        return null; // Enfermeiro não encontrado
    }

    // Método que retorna o HashSet de CPFs
    public HashSet<String> getCpfs() {
        return cpfs;
    }
}