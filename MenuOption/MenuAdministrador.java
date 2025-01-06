package com.estudodirigido.hospital.MenuOption;

import com.estudodirigido.hospital.Hospital;
import com.estudodirigido.hospital.controller.MedicoController;
import com.estudodirigido.hospital.controller.FuncionarioController;
import com.estudodirigido.hospital.controller.ConsultaController;
import com.estudodirigido.hospital.Relatorio;
import com.estudodirigido.hospital.controller.EnfermeiroController;
import java.util.Scanner;
import java.util.HashSet;

public class MenuAdministrador {

    private Scanner scanner;
    private Hospital hospital;
    private Relatorio relatorio;
    private HashSet<String> cpfs;
    private HashSet<String> crms;
    private HashSet<String> corens;
    private FuncionarioController funcionarioController;  // Dependência para calcular salários
    private ConsultaController consultaController;        // Dependência para consultas
    private MedicoController medicoController;            // Dependência para cadastro de médicos
    private EnfermeiroController enfermeiroController;

    // Construtor atualizado com dependências necessárias
    public MenuAdministrador(Scanner scanner, Hospital hospital, Relatorio relatorio,
            HashSet<String> cpfs, HashSet<String> crms, HashSet<String> corens,
            FuncionarioController funcionarioController, ConsultaController consultaController,
            MedicoController medicoController, EnfermeiroController enfermeiroController) {
        this.scanner = scanner;
        this.hospital = hospital;
        this.relatorio = relatorio;
        this.cpfs = cpfs;
        this.crms = crms;
        this.corens = corens;
        this.funcionarioController = funcionarioController;
        this.consultaController = consultaController;
        this.medicoController = medicoController;
        this.enfermeiroController = enfermeiroController;
    }

    public void exibirMenu() {
        Menu menu = new Menu(scanner);

        // Adicionando opções ao menu com dependências apropriadas
        menu.addOption(new CadastrarPacienteOption(scanner, hospital, cpfs), "Cadastrar Paciente");
        menu.addOption(new CadastrarMedicoOption(scanner, medicoController), "Cadastrar Médico");
        menu.addOption(new CadastrarEnfermeiroOption(scanner, enfermeiroController), "Cadastrar Enfermeiro");
        menu.addOption(new ListarPacientesOption(hospital), "Listar Paciente");
        menu.addOption(new GerarRelatorioOption(relatorio), "Gerar Relatório");
        menu.addOption(new CalcularSalarioOption(scanner, hospital, funcionarioController), "Calcular Salário");

        menu.addOption(new ListarMedicosOption(hospital), "Listar Médicos");
        menu.addOption(new ListarEnfermeirosOption(hospital), "Listar Enfermeiros");

        // Exibe o menu
        menu.show();
    }
}
