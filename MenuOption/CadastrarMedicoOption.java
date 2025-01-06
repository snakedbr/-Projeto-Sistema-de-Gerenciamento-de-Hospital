package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.controller.MedicoController;
import java.util.Scanner;

public class CadastrarMedicoOption implements MenuOption {

    private Scanner scanner;
    private MedicoController medicoController;

    // O constructor agora recebe a instância do MedicoController
    public CadastrarMedicoOption(Scanner scanner, MedicoController medicoController) {
        this.scanner = scanner;
        this.medicoController = medicoController;
    }

    @Override
    public void execute() {
        // Chama o método de cadastro de médico no controller
        medicoController.cadastrarMedico(scanner);
    }
}