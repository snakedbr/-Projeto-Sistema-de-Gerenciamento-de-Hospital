package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Agenda;
import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.ConsultaController;
import com.estudodirigido.hospital.controller.EnfermeiroController;
import com.estudodirigido.hospital.controller.PacienteController;
import java.util.HashSet;
import java.util.Scanner;

public class MenuEnfermeiro {

    private Scanner scanner;
    private Hospital hospital;
    private Agenda agenda;
    private HashSet<String> cpfs;
    private Enfermeiro enfermeiro;
    private EnfermeiroController enfermeiroController;
    private ConsultaController consultaController;
    private PacienteController pacienteController;

    // Construtor para injetar dependências
    public MenuEnfermeiro(Scanner scanner, Hospital hospital, Agenda agenda, Enfermeiro enfermeiro, EnfermeiroController enfermeiroController, ConsultaController consultaController, PacienteController pacienteController, HashSet<String> cpfs) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.agenda = agenda;
        this.enfermeiro = enfermeiro;
        this.enfermeiroController = enfermeiroController;
        this.consultaController = consultaController;
        this.pacienteController = pacienteController;
        this.cpfs = cpfs;

    }

    public void exibirMenu() {
        // Instancia o menu dinâmico
        Menu menu = new Menu(scanner);

        // Adiciona as opções de menu com suas dependências corretas
        menu.addOption(new MarcarConsultaOption(scanner, hospital, agenda, consultaController), "Marcar Consulta");
        menu.addOption(new AssistirPacienteOption(scanner, hospital, enfermeiro, enfermeiroController), "Assistir Paciente");
        menu.addOption(new ChecarHistoricoOption(scanner, hospital, pacienteController), "Checar Histórico do Paciente");
        menu.addOption(new CadastrarPacienteOption(scanner, hospital, cpfs), "Cadastrar Paciente");
        menu.addOption(new CancelarConsultaOption(scanner, hospital, agenda, consultaController), "Cancelar Consulta");

        // Exibe o menu e aguarda a escolha do usuário
        menu.show();
    }
}
