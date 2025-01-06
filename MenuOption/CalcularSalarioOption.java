package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.FuncionarioController;
import java.util.Scanner;

public class CalcularSalarioOption implements MenuOption {

    private Scanner scanner;
    private Hospital hospital;
    private FuncionarioController funcionarioController;

    // Construtor que injeta o Scanner, Hospital e FuncionarioController
    public CalcularSalarioOption(Scanner scanner, Hospital hospital, FuncionarioController funcionarioController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.funcionarioController = funcionarioController;
    }

    @Override
    public void execute() {
        // Chama o método calcularSalarioFuncionario do FuncionarioController
        funcionarioController.calcularSalarioFuncionario(scanner, hospital);
    }
}