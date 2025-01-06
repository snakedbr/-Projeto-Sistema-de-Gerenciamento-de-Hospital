package com.estudodirigido.hospital;


import com.estudodirigido.hospital.Services.LoginService;
import com.estudodirigido.hospital.MenuOption.MenuAdministrador;
import com.estudodirigido.hospital.MenuOption.MenuEnfermeiro;
import com.estudodirigido.hospital.MenuOption.MenuMedico;
import com.estudodirigido.hospital.Services.*;
import com.estudodirigido.hospital.controller.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Cria um administrador
        Administrador administrador = new Administrador(1, 5000.00, "Administração", "Carlos Silva", 40, "cpfAdmin", "Rua Central, 100");

        // Cria um médico
        Medico medico = new Medico("Cardiologista", "123456", 1, 15000.0, "Médico", "Dr. João", 40, "cpfMedico", "Rua do Médico");

        // Cria um paciente
        Paciente paciente = new Paciente(1001, new Date(), "José da Silva", 50, "cpfPaciente", "Rua dos Pacientes");

        // Cria um enfermeiro
        Enfermeiro enfermeiro = new Enfermeiro("123-Coren", "Noturno", 1002, 8000.0, "Enfermeiro", "Maria Souza", 35, "cpfEnfermeiro", "Rua dos Enfermeiros");

        // Cria uma instância de um hospital
        Hospital hospital = new Hospital("Hospital Central", "Rua das Flores, 123");

        // Inicializa a agenda e lista de consultas
        Agenda agenda = new Agenda();
        List<Consulta> consultas = new ArrayList<>();  // Lista de consultas para o relatório

        // Simulação de dados de funcionários no sistema com CPF como chave
        Map<String, Funcionario> usuarios = new HashMap<>();

        // Adiciona os funcionários ao mapa de usuários
        usuarios.put(administrador.getCPF(), administrador);
        usuarios.put(medico.getCPF(), medico);
        usuarios.put(enfermeiro.getCPF(), enfermeiro);

        // Inicializa os serviços
        PacienteService pacienteService = new PacienteService(new HashSet<>());
        MedicoService medicoService = new MedicoService(new HashSet<>(), new HashSet<>(), hospital);
        EnfermeiroService enfermeiroService = new EnfermeiroService(new HashSet<>(), new HashSet<>(), hospital);
        AgendaService agendaService = new AgendaService(agenda);
        SalarioService salarioService = new SalarioService();  // Criação do serviço de salários
        ConsultaService consultaService = new ConsultaService();       // Criação do serviço de consultas

        // Adicionar objetos ao hospital
        hospital.admitirPaciente(paciente);
        hospital.admitirEnfermeiro(enfermeiro);
        hospital.admitirMedico(medico);

        // Exemplo de agendamento de consulta
        agendaService.agendarConsultaComData(paciente, medico, "09/12/2024 19:00");

        // Atualiza a lista de consultas com a nova consulta
        consultas.add(new Consulta(paciente, medico, new Date()));

        // Instância do serviço de login
        LoginService loginService = new LoginService(usuarios);

        // Instância do controlador de login
        LoginController loginController = new LoginController(loginService);

        // Simulação de entrada do usuário (login)
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionarioLogado = loginController.iniciarLogin(scanner);

        // Instancia o Relatorio com a lista de consultas
        Relatorio relatorio = new Relatorio(consultas);

        // Instanciação de controladores
        FuncionarioController funcionarioController = new FuncionarioController(salarioService);
        ConsultaController consultaController = new ConsultaController(consultaService);
        PacienteController pacienteController = new PacienteController(pacienteService);
        MedicoController medicoController = new MedicoController(medicoService);
        EnfermeiroController enfermeiroController = new EnfermeiroController(enfermeiroService);

        // Instanciação de HashSet para CPFs, CRMs e COREN
        HashSet<String> cpfs = new HashSet<>();
        HashSet<String> crms = new HashSet<>();
        HashSet<String> corens = new HashSet<>();

        // Verifica o tipo de funcionário logado e exibe o menu correto
        if (funcionarioLogado instanceof Administrador) {
            // Ajustando os parâmetros de MenuAdministrador
            MenuAdministrador menuAdministrador = new MenuAdministrador(
                    scanner,
                    hospital,
                    relatorio,
                    cpfs,
                    crms,
                    corens,
                    funcionarioController,
                    consultaController,
                    medicoController,
                    enfermeiroController
            );
            menuAdministrador.exibirMenu();
        } else if (funcionarioLogado instanceof Medico) {

            // Ajustando os parâmetros de MenuMedico
            MenuMedico menuMedico = new MenuMedico(
                    scanner,
                    hospital,
                    agenda,
                    consultaController,
                    pacienteController
            );
            menuMedico.exibirMenu();
        } else if (funcionarioLogado instanceof Enfermeiro) {
            // Ajustando os parâmetros de MenuEnfermeiro
            MenuEnfermeiro menuEnfermeiro = new MenuEnfermeiro(
                    scanner,
                    hospital,
                    agenda,
                    enfermeiro,
                    enfermeiroController,
                    consultaController,
                    pacienteController,
                    cpfs
            );
            menuEnfermeiro.exibirMenu();
        }

        scanner.close();
    }
}
