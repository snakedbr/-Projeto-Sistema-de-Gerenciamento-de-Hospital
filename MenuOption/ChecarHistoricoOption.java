package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.PacienteController;
import java.util.Scanner;

public class ChecarHistoricoOption implements MenuOption {

    private Scanner scanner;
    private Hospital hospital;
    private PacienteController pacienteController;

    // Construtor que injeta Scanner, Hospital e o PacienteController
    public ChecarHistoricoOption(Scanner scanner, Hospital hospital, PacienteController pacienteController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.pacienteController = pacienteController;
    }

    @Override
    public void execute() {
        // Chama o método checarHistorico do PacienteController
        pacienteController.checarHistorico(scanner, hospital);
    }
}