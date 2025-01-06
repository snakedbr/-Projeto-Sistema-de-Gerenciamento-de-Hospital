package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Medico;
import java.util.Scanner;

public class ListarMedicosOption implements MenuOption {

    private Hospital hospital;

    // Construtor
    public ListarMedicosOption(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public void execute() {
        System.out.println("\n--- Lista de Médicos ---");

        if (hospital.getMedicos().isEmpty()) {
            System.out.println("Nenhum médico cadastrado no hospital.");
        } else {
            for (Medico medico : hospital.getMedicos()) {
                System.out.println("- Nome: " + medico.getNome() + 
                                   ", CRM: " + medico.getCRM() + 
                                   ", Especialidade: " + medico.getEspecialidade());
            }
        }
    }
}