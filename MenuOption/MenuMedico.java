/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Agenda;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.ConsultaController;
import com.estudodirigido.hospital.controller.PacienteController;
import java.util.Scanner;

public class MenuMedico {

    private Scanner scanner;
    private Hospital hospital;
    private Agenda agenda;
    private ConsultaController consultaController;
    private PacienteController pacienteController;

    public MenuMedico(Scanner scanner, Hospital hospital, Agenda agenda, ConsultaController consultaController, PacienteController pacienteController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.agenda = agenda;
        this.consultaController= consultaController;
        this.pacienteController = pacienteController;
    }

    public void exibirMenu() {
        Menu menu = new Menu(scanner);

        menu.addOption(new RealizarConsultaOption(scanner, hospital, agenda, consultaController), "Realizar Consulta");
        menu.addOption(new ChecarHistoricoOption(scanner, hospital,pacienteController), "Checar Histórico Paciente");

        menu.show();
    }
}