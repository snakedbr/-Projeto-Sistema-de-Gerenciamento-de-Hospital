package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Relatorio;

public class GerarRelatorioOption implements MenuOption {

    private Relatorio relatorio;

    public GerarRelatorioOption(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public void execute() {
        relatorio.gerarRelatorioPacientesPorMedico();
    }
}