package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Agenda;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.ConsultaController;
import java.util.Scanner;

public class RealizarConsultaOption implements MenuOption {

    private Scanner scanner;
    private Hospital hospital;
    private Agenda agenda;
    private ConsultaController consultaController;

    // Construtor que injeta Scanner, Hospital, Agenda e ConsultaController
    public RealizarConsultaOption(Scanner scanner, Hospital hospital, Agenda agenda, ConsultaController consultaController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.agenda = agenda;
        this.consultaController = consultaController;
    }

    @Override
    public void execute() {
        // Chama o método realizarConsulta do ConsultaController
        consultaController.realizarConsulta(scanner, hospital, agenda);
    }
}