package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Enfermeiro;
import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.Medico;

public class SalarioService {

    // Método para calcular o salário de um funcionário
    public void calcularSalario(String crmOuCoren, int atendimentosExtras, double valorPorAtendimentoExtra, Hospital hospital) {
        // Tenta buscar o médico pelo CRM
        Medico medico = hospital.buscarMedicoPorCRM(crmOuCoren);
        Enfermeiro enfermeiro = null;

        // Se não encontrar o médico, tenta buscar o enfermeiro pelo COREN
        if (medico == null) {
            enfermeiro = hospital.buscarEnfermeiroPorCOREN(crmOuCoren);
        }

        if (medico != null) {
            // Funcionário é um médico
            System.out.println("Médico encontrado: " + medico.getNome());

            // Calcular o salário do médico
            double salarioFinal = medico.calcularSalario(atendimentosExtras, valorPorAtendimentoExtra);

            // Exibir o salário final do médico
            System.out.println("Salário final do médico " + medico.getNome() + ": R$ " + salarioFinal);

        } else if (enfermeiro != null) {
            // Funcionário é um enfermeiro
            System.out.println("Enfermeiro encontrado: " + enfermeiro.getNome());

            // Calcular o salário do enfermeiro
            double salarioFinal = enfermeiro.calcularSalario(atendimentosExtras, valorPorAtendimentoExtra);

            // Exibir o salário final do enfermeiro
            System.out.println("Salário final do enfermeiro " + enfermeiro.getNome() + ": R$ " + salarioFinal);

        } else {
            // Funcionário não encontrado
            System.out.println("Erro: Nenhum médico ou enfermeiro encontrado com o CRM/COREN fornecido.");
        }
    }
}