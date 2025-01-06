package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Paciente;

import java.util.HashSet;
import java.util.Set;

public class EnfermeiroService {

    private HashSet<String> cpfs;
    private HashSet<String> corens;

    // Referência ao hospital para adicionar o enfermeiro
    private Hospital hospital;

    // Conjunto para armazenar os enfermeiros cadastrados
    private Set<Enfermeiro> enfermeiros;

    // Construtor que inicializa os conjuntos de CPFs e Corens
    public EnfermeiroService(HashSet<String> cpfs, HashSet<String> corens, Hospital hospital) {
        this.cpfs = cpfs;
        this.corens = corens;
        this.hospital = hospital;

        // Inicializa o conjunto de enfermeiros
        this.enfermeiros = new HashSet<>();  // Certifique-se de inicializar este conjunto.
    }

    // Método para verificar se o CPF já existe
    public boolean cpfExiste(String cpf) {
        return cpfs.contains(cpf);
    }

    // Método para verificar se o Coren já existe
    public boolean corenExiste(String coren) {
        return corens.contains(coren);
    }

    // Método para cadastrar um enfermeiro
    public Enfermeiro criarEnfermeiro(String nome, int idade, String cpf, String endereco, String coren, String turno, double salario) {
        int idEnfermeiro = (int) (Math.random() * 10000);  // Gera um ID aleatório para o enfermeiro

        // Cria o objeto Enfermeiro
        Enfermeiro novoEnfermeiro = new Enfermeiro(coren, turno, idEnfermeiro, salario, "Enfermeiro", nome, idade, cpf, endereco);

        // Adiciona o CPF e o Coren aos conjuntos para evitar duplicidade no futuro
        cpfs.add(cpf);
        corens.add(coren);

        // Adiciona o novo enfermeiro ao conjunto de enfermeiros
        enfermeiros.add(novoEnfermeiro);

        // Adiciona o novo enfermeiro ao ArrayList de enfermeiros no hospital
        hospital.admitirEnfermeiro(novoEnfermeiro);

        return novoEnfermeiro;
    }

    // Método para assistir um paciente
    public String assistirPaciente(Hospital hospital, Enfermeiro enfermeiro, String cpfPaciente) {
        Paciente paciente = hospital.buscarPacientePorCPF(cpfPaciente);

        // Verifica se o paciente existe
        if (paciente != null) {
            // O enfermeiro assiste o paciente
            enfermeiro.assistirPaciente(paciente);

            // Retorna o histórico atualizado do paciente
            StringBuilder historicoPaciente = new StringBuilder("\n--- Histórico Atualizado do Paciente ---\n");
            for (String historia : paciente.getHistorico()) {
                historicoPaciente.append(historia).append("\n");
            }
            return historicoPaciente.toString();
        } else {
            return "Paciente não encontrado.";
        }
    }
}
