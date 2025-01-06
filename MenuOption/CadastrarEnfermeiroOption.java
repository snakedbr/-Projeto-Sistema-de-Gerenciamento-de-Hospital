package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.controller.EnfermeiroController;
import java.util.Scanner;

public class CadastrarEnfermeiroOption implements MenuOption {

    private Scanner scanner;
    private EnfermeiroController enfermeiroController;

    // O constructor agora recebe a instância do EnfermeiroController
    public CadastrarEnfermeiroOption(Scanner scanner, EnfermeiroController enfermeiroController) {
        this.scanner = scanner;
        this.enfermeiroController = enfermeiroController;
    }

    @Override
    public void execute() {
        // Chama o método de cadastro no controller
        enfermeiroController.cadastrarEnfermeiro(scanner);
    }
}