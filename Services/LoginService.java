package com.estudodirigido.hospital.Services;

import com.estudodirigido.hospital.Funcionario;

import java.util.Map;

public class LoginService {

    private Map<String, Funcionario> usuarios;

    public LoginService(Map<String, Funcionario> usuarios) {
        this.usuarios = usuarios;
    }

    // Método para realizar o login
    public Funcionario realizarLogin(String cpf, int nivelAcesso) {
        Funcionario usuarioLogado = usuarios.get(cpf);

        // Verifica se o usuário existe e o nível de acesso está correto
        if (usuarioLogado != null && usuarioLogado.getNivelAcesso() == nivelAcesso) {
            return usuarioLogado;
        }

        // Retorna null se o login falhar
        return null;
    }
}