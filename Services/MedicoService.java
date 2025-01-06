package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Medico;
import com.estudodirigido.hospital.Hospital;

import java.util.HashSet;
import java.util.Set;

public class MedicoService {

    // Conjunto de CPFs e CRMs para garantir unicidade
    private HashSet<String> cpfs;
    private HashSet<String> crms;
    
    // Conjunto para armazenar os médicos cadastrados
    private Set<Medico> medicos;

    // Referência ao hospital para adicionar o médico no ArrayList de médicos
    private Hospital hospital;

    // Atualiza o construtor para receber o Hospital
    public MedicoService(HashSet<String> cpfs, HashSet<String> crms, Hospital hospital) {
        this.cpfs = cpfs;
        this.crms = crms;
        this.hospital = hospital;  // Recebe a instância do hospital
        this.medicos = new HashSet<>();  // Inicializa o conjunto para armazenar os médicos
    }

    // Método para verificar se o CPF já existe
    public boolean cpfExiste(String cpf) {
        return cpfs.contains(cpf);
    }

    // Método para verificar se o CRM já existe
    public boolean crmExiste(String crm) {
        return crms.contains(crm);
    }

    // Método para cadastrar um novo médico
    public Medico criarMedico(String nome, int idade, String cpf, String endereco, String crm, String especialidade, double salario) {
        int idFuncionario = (int) (Math.random() * 10000);  // Gera uma ID aleatória

        Medico novoMedico = new Medico(especialidade, crm, idFuncionario, salario, "Médico", nome, idade, cpf, endereco);

        // Atualiza os conjuntos de CPFs e CRMs
        cpfs.add(cpf);
        crms.add(crm);

        // Adiciona o novo médico ao conjunto de médicos
        medicos.add(novoMedico);

        // Adiciona o novo médico ao ArrayList de médicos no hospital
        hospital.admitirMedico(novoMedico);

        return novoMedico;
    }

    // Método para listar todos os médicos cadastrados
    public Set<Medico> listarMedicos() {
        return medicos;
    }
}