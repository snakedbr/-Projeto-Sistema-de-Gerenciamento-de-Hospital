Se o texto não ficou formatado corretamente no GitHub, pode ser que o arquivo README.md não esteja seguindo a sintaxe correta do Markdown. Vou revisar e ajustar o texto para garantir que ele seja renderizado corretamente no GitHub.
Aqui está a versão corrigida e formatada para o README.md:

Sistema de Gerenciamento de Hospital
Descrição do Projeto
O Sistema de Gerenciamento de Hospital é um software desenvolvido em Java que simula o gerenciamento de um hospital. Ele permite o registro, consulta e manipulação de informações sobre pacientes, médicos, enfermeiros e administradores. Além disso, mantém registros de consultas, diagnósticos e tratamentos aplicados, garantindo um fluxo eficiente de informações dentro do hospital.
O sistema é orientado a objetos e implementa os princípios de herança, polimorfismo, encapsulamento e composição.

Requisitos do Sistema
O sistema deve permitir:

Cadastro de pacientes, médicos, enfermeiros e administradores.
Registro de consultas realizadas, incluindo o médico responsável, diagnóstico e tratamento prescrito.
Agendamento de consultas.
Manutenção do histórico de saúde dos pacientes, acessível para médicos e administradores.
Exibição e manipulação de dados dos funcionários do hospital.


Estrutura Geral do Sistema
Classes e Atributos
1. Classe Pessoa (Classe Base)

Atributos:

nome (String)
idade (int)
CPF (String)
endereco (String)


Métodos:

getInfo()


Descrição: Classe abstrata que serve como base para outras classes de pessoa. Contém os atributos comuns a todas as pessoas no sistema.

2. Classe Paciente (Herda de Pessoa)

Atributos:

historicoDeSaude (ArrayList<String>)
prontuario (int)
dataCadastro (Date)


Métodos:

adicionarHistorico(String)
getHistorico()


Descrição: Representa um paciente do hospital. Inclui um histórico de saúde e um prontuário único.

3. Classe Funcionario (Herda de Pessoa)

Atributos:

idFuncionario (int)
salario (double)
departamento (String)


Métodos:

calcularSalario()


Descrição: Representa um funcionário genérico do hospital. Será usada como classe base para outras subclasses de funcionários.

4. Classe Medico (Herda de Funcionario)

Atributos:

especialidade (String)
CRM (String)
pacientesAtendidos (ArrayList<Paciente>)


Métodos:

diagnosticar(Paciente)
prescreverTratamento(Paciente, String)


Descrição: Representa um médico do hospital. Além dos atributos de Funcionario, possui a especialidade médica e o CRM.

5. Classe Enfermeiro (Herda de Funcionario)

Atributos:

coren (String)
turno (String)


Métodos:

assistirPaciente(Paciente)


Descrição: Representa um enfermeiro. Tem o registro de COREN e o turno de trabalho.

6. Classe Administrador (Herda de Funcionario)

Atributos:

nivelAcesso (int)


Métodos:

gerenciarFuncionario(Funcionario)


Descrição: Representa um administrador do hospital, responsável pela administração de recursos humanos e controle de nível de acesso.

7. Classe Consulta

Atributos:

paciente (Paciente)
medico (Medico)
diagnostico (String)
dataConsulta (Date)
tratamento (String)


Métodos:

registrarConsulta()
visualizarConsulta()


Descrição: Representa uma consulta realizada no hospital, contendo informações sobre o paciente, o médico, o diagnóstico e o tratamento.

8. Classe Agenda

Atributos:

consultas (ArrayList<Consulta>)


Métodos:

agendarConsulta(Paciente, Medico, Date)
cancelarConsulta(Consulta)


Descrição: Gerencia a agenda do hospital, permitindo o agendamento e cancelamento de consultas.

9. Classe Hospital

Atributos:

nome (String)
endereco (String)
funcionarios (ArrayList<Funcionario>)
pacientes (ArrayList<Paciente>)


Métodos:

admitirFuncionario(Funcionario)
admitirPaciente(Paciente)
listarFuncionarios()
listarPacientes()


Descrição: Representa o hospital em si. Mantém listas de funcionários e pacientes e possui métodos para adicionar e listar informações sobre eles.


Regras de Negócio

Cadastro Único: Cada paciente, médico e enfermeiro deve ter um número único de identificação (CPF para pacientes, CRM para médicos e COREN para enfermeiros).
Controle de Acesso: Somente administradores podem visualizar todos os dados dos funcionários e pacientes.
Histórico de Saúde: Apenas médicos e enfermeiros podem adicionar entradas ao histórico de saúde dos pacientes.
Agendamento de Consultas: O sistema deve verificar a disponibilidade do médico ao agendar uma nova consulta.
Consulta: Uma consulta só pode ser registrada se houver um paciente e um médico disponíveis no horário.


Funcionalidades Extras

Sistema de Notificações: Enviar uma notificação para o paciente quando uma consulta é agendada ou cancelada.
Relatórios Estatísticos: Geração de relatórios sobre:

Número de pacientes atendidos por cada médico.
Número total de consultas realizadas no mês.


Cálculo de Salário com Bonificação: Calcular o salário do médico e dos enfermeiros considerando bonificações por atendimento extra.
Interface Gráfica (Opcional): Criar uma interface gráfica usando Java Swing para que os dados possam ser manipulados visualmente.


Tecnologias Utilizadas

Linguagem: Java
Paradigma: Programação Orientada a Objetos (POO)
Bibliotecas:

java.util (para manipulação de listas e datas)
java.swing (opcional, para interface gráfica)




Como Executar o Projeto

Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git


Compile o projeto:
javac *.java


Execute o programa principal:
java Main




Contribuição
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

Faça um fork do repositório.
Crie uma branch para sua feature:
git checkout -b minha-feature


Faça o commit das suas alterações:
git commit -m "Adicionando minha feature"


Envie para o repositório remoto:
git push origin minha-feature


Abra um Pull Request.


Licença
Este projeto está licenciado sob a MIT License.

Observação:
Certifique-se de salvar o arquivo como README.md no repositório. O GitHub renderiza automaticamente arquivos .md no formato correto. Se ainda não funcionar, verifique se o arquivo está no diretório raiz do repositório.
Se precisar de mais ajustes, é só avisar! 😊
