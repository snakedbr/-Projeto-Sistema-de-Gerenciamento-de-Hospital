package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;

public class ListarEnfermeirosOption implements MenuOption {

    private Hospital hospital;

    // Construtor
    public ListarEnfermeirosOption(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public void execute() {
        System.out.println("\n--- Lista de Enfermeiros ---");

        if (hospital.getEnfermeiros().isEmpty()) {
            System.out.println("Nenhum enfermeiro cadastrado no hospital.");
        } else {
            for (Enfermeiro enfermeiro : hospital.getEnfermeiros()) {
                System.out.println("- Nome: " + enfermeiro.getNome()
                        + ", Coren: " + enfermeiro.getCoren());  // Corrigi o fechamento do parêntese aqui
            }
        }
    }
}