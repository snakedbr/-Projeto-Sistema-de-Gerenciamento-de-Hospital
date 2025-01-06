package com.estudodirigido.hospital;

public class Enfermeiro extends Funcionario {

    // Atributos específicos do enfermeiro
    private int nivelAcesso = 3;  // Define o nível de acesso para enfermeiros como 3
    private String coren;  // Registro do COREN (Conselho Regional de Enfermagem)
    private String turno;  // Turno de trabalho (por exemplo, "Manhã", "Noite")

    // Construtor que chama o construtor da superclasse Funcionario
    public Enfermeiro(String coren, String turno, int idFuncionario, double salario, String departamento, String nome, int idade, String CPF, String endereco) {
        super(idFuncionario, salario, departamento, nome, idade, CPF, endereco);
        this.coren = coren;
        this.turno = turno;
    }

    @Override
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    // Getters e Setters para os atributos coren e turno
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    //Método que representa o atendimento de um enfermeiro a um paciente.
    public void assistirPaciente(Paciente paciente) {
        System.out.println("Enfermeiro " + this.getNome() + " está assistindo o paciente " + paciente.getNome());

        // Adiciona a ação ao histórico do paciente
        paciente.adicionarHistorico("Paciente assistido pelo enfermeiro " + this.getNome() + " (COREN: " + this.coren + ")");
    }

    @Override
    public double calcularSalario(int atendimentosExtras, double valorPorAtendimentoExtra) {
        // Salário final = Salário base + bonificação por atendimentos extras
        return getSalario() + (atendimentosExtras * valorPorAtendimentoExtra);
    }
}
