/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital.MenuOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuOption> options;
    private ArrayList<String> optionNames = new ArrayList<>();

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.options = new ArrayList<>();
        this.optionNames = new ArrayList<>();
        this.scanner = scanner;
    }

    // Adiciona uma nova opção ao menu e o String name permite alterar o nome do Menu
    public void addOption(MenuOption option, String name) {
        options.add(option);
        optionNames.add(name);

    }

    // Exibe o menu e processa a escolha do usuário
   public void show() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n--- Escolha uma opção ---");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + optionNames.get(i));
            }
            System.out.println((options.size() + 1) + ". Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (choice > 0 && choice <= options.size()) {
                options.get(choice - 1).execute();
            } else if (choice == options.size() + 1) {
                exit = true;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
