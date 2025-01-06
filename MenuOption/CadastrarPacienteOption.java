package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Paciente;
import com.estudodirigido.hospital.Services.PacienteService;
import java.util.HashSet;
import java.util.Scanner;

public class CadastrarPacienteOption implements MenuOption {

    private Scanner scanner;
    private Hospital hospital;
    private HashSet<String> cpfs;  // Conjunto para armazenar os CPFs únicos

    // Construtor que injeta o scanner, hospital e o conjunto de CPFs
    public CadastrarPacienteOption(Scanner scanner, Hospital hospital, HashSet<String> cpfs) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.cpfs = cpfs;
    }

    @Override
    public void execute() {
        // Cria a instância de PacienteService com o conjunto de CPFs
        PacienteService pacienteService = new PacienteService(cpfs);

        // Chama o método de cadastro de paciente no PacienteService
        Paciente paciente = pacienteService.cadastrarPaciente(scanner);
        
        // Se o cadastro foi bem-sucedido, admite o paciente no hospital
        if (paciente != null) {
            hospital.admitirPaciente(paciente);
            System.out.println("Paciente admitido no hospital com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o paciente.");
        }
    }
}