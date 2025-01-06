package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Services.SalarioService;
import java.util.Scanner;

public class FuncionarioController {

    private final SalarioService salarioService;

    // O controller recebe o SalarioService através do construtor
    public FuncionarioController(SalarioService salarioService) {
        this.salarioService = salarioService;
    }

    public void calcularSalarioFuncionario(Scanner scanner, Hospital hospital) {
        // Coleta os dados do funcionário e delega o cálculo ao serviço
        System.out.println("\n--- Calcular Salário de Funcionário ---");
        System.out.print("Digite o CRM (para Médico) ou COREN (para Enfermeiro): ");
        String crmOuCoren = scanner.nextLine();

        System.out.print("Digite o número de atendimentos extras realizados: ");
        int atendimentosExtras = scanner.nextInt();

        System.out.print("Digite o valor por atendimento extra: ");
        double valorPorAtendimentoExtra = scanner.nextDouble();

        // Limpa o buffer do scanner
        scanner.nextLine();

        // Chama o serviço para calcular o salário
        salarioService.calcularSalario(crmOuCoren, atendimentosExtras, valorPorAtendimentoExtra, hospital);
    }
}