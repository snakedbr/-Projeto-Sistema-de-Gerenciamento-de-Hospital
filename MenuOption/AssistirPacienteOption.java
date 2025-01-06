package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.EnfermeiroController;

import java.util.Scanner;

public class AssistirPacienteOption implements MenuOption {

    private Scanner scanner;
    private Hospital hospital;
    private Enfermeiro enfermeiro;
    private EnfermeiroController enfermeiroController;

    // O constructor agora também recebe o EnfermeiroController
    public AssistirPacienteOption(Scanner scanner, Hospital hospital, Enfermeiro enfermeiro, EnfermeiroController enfermeiroController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.enfermeiro = enfermeiro;
        this.enfermeiroController = enfermeiroController;
    }

    @Override
    public void execute() {
        // Chama o método de assistir paciente no controller
        enfermeiroController.assistirPaciente(scanner, hospital, enfermeiro);
    }
}