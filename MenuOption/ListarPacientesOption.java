/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.MenuOption.MenuOption;

/**
 *
 * @author SnakeD
 */
public class ListarPacientesOption implements MenuOption{

    private Hospital hospital;

    public ListarPacientesOption(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public void execute() {
        hospital.listarPacientes();
    }
}
