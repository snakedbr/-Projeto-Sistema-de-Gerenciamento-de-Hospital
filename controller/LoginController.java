package com.estudodirigido.hospital.controller;

import com.estudodirigido.hospital.Funcionario;
import com.estudodirigido.hospital.Services.LoginService;

import java.util.Scanner;

public class LoginController {

    private LoginService loginService;

    // Construtor recebe o serviço de login
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Método para iniciar o processo de login
    public Funcionario iniciarLogin(Scanner scanner) {
        Funcionario usuarioLogado = null;

        while (usuarioLogado == null) {
            System.out.println("\n--- Tela de Login ---");

            // Coleta o CPF do usuário
            System.out.print("Digite o CPF: ");
            String cpfInput = scanner.nextLine();

            // Coleta o nível de acesso (com tratamento de erros para garantir que é um número)
            int nivelAcessoInput = obterNivelAcesso(scanner);

            // Tenta realizar o login via LoginService
            usuarioLogado = loginService.realizarLogin(cpfInput, nivelAcessoInput);

            if (usuarioLogado != null) {
                System.out.println("\nLogin bem-sucedido como " + usuarioLogado.getClass().getSimpleName() + "! Bem-vindo, " + usuarioLogado.getNome() + "!");
            } else {
                System.out.println("\nCPF ou nível de acesso incorretos. Tente novamente.\n");
            }
        }

        return usuarioLogado;
    }

    // Método auxiliar para obter o nível de acesso, garantindo que é um número válido
    private int obterNivelAcesso(Scanner scanner) {
        int nivelAcesso = -1;

        while (nivelAcesso < 1 || nivelAcesso > 3) {
            try {
                System.out.print("Digite o nível de acesso (1-Admin, 2-Médico, 3-Enfermeiro): ");
                nivelAcesso = Integer.parseInt(scanner.nextLine());

                if (nivelAcesso < 1 || nivelAcesso > 3) {
                    System.out.println("Erro: Nível de acesso inválido. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número correspondente ao nível de acesso.");
            }
        }

        return nivelAcesso;
    }
}