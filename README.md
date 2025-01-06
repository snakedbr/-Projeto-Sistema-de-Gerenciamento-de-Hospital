# Sistema de Gerenciamento de Hospital

## Descrição do Projeto

O **Sistema de Gerenciamento de Hospital** é um software desenvolvido em Java que simula o gerenciamento de um hospital. Ele permite o registro, consulta e manipulação de informações sobre pacientes, médicos, enfermeiros e administradores. Além disso, mantém registros de consultas, diagnósticos e tratamentos aplicados, garantindo um fluxo eficiente de informações dentro do hospital.

O sistema é orientado a objetos e implementa os princípios de **herança**, **polimorfismo**, **encapsulamento** e **composição**.

---

## Requisitos do Sistema

O sistema deve permitir:

1. **Cadastro** de pacientes, médicos, enfermeiros e administradores.
2. **Registro de consultas realizadas**, incluindo o médico responsável, diagnóstico e tratamento prescrito.
3. **Agendamento de consultas**.
4. **Manutenção do histórico de saúde dos pacientes**, acessível para médicos e administradores.
5. **Exibição e manipulação de dados** dos funcionários do hospital.

---

## Estrutura Geral do Sistema

### Classes e Atributos

#### 1. Classe `Pessoa` (Classe Base)
- **Atributos**:
  - `nome` (String)
  - `idade` (int)
  - `CPF` (String)
  - `endereco` (String)
- **Métodos**:
  - `getInfo()`
- **Descrição**: Classe abstrata que serve como base para outras classes de pessoa. Contém os atributos comuns a todas as pessoas no sistema.

#### 2. Classe `Paciente` (Herda de `Pessoa`)
- **Atributos**:
  - `historicoDeSaude` (ArrayList\<String\>)
  - `prontuario` (int)
  - `dataCadastro` (Date)
- **Métodos**:
  - `adicionarHistorico(String)`
  - `getHistorico()`
- **Descrição**: Representa um paciente do hospital. Inclui um histórico de saúde e um prontuário único.

#### 3. Classe `Funcionario` (Herda de `Pessoa`)
- **Atributos**:
  - `idFuncionario` (int)
  - `salario` (double)
  - `departamento` (String)
- **Métodos**:
  - `calcularSalario()`
- **Descrição**: Representa um funcionário genérico do hospital. Será usada como classe base para outras subclasses de funcionários.

#### 4. Classe `Medico` (Herda de `Funcionario`)
- **Atributos**:
  - `especialidade` (String)
  - `CRM` (String)
  - `pacientesAtendidos` (ArrayList\<Paciente\>)
- **Métodos**:
  - `diagnosticar(Paciente)`
  - `prescreverTratamento(Paciente, String)`
- **Descrição**: Representa um médico do hospital. Além dos atributos de `Funcionario`, possui a especialidade médica e o CRM.

#### 5. Classe `Enfermeiro` (Herda de `Funcionario`)
- **Atributos**:
  - `coren` (String)
  - `turno` (String)
- **Métodos**:
  - `assistirPaciente(Paciente)`
- **Descrição**: Representa um enfermeiro. Tem o registro de COREN e o turno de trabalho.

#### 6. Classe `Administrador` (Herda de `Funcionario`)
- **Atributos**:
  - `nivelAcesso` (int)
- **Métodos**:
  - `gerenciarFuncionario(Funcionario)`
- **Descrição**: Representa um administrador do hospital, responsável pela administração de recursos humanos e controle de nível de acesso.

#### 7. Classe `Consulta`
- **Atributos**:
  - `paciente` (Paciente)
  - `medico` (Medico)
  - `diagnostico` (String)
  - `dataConsulta` (Date)
  - `tratamento` (String)
- **Métodos**:
  - `registrarConsulta()`
  - `visualizarConsulta()`
- **Descrição**: Representa uma consulta realizada no hospital, contendo informações sobre o paciente, o médico, o diagnóstico e o tratamento.

#### 8. Classe `Agenda`
- **Atributos**:
  - `consultas` (ArrayList\<Consulta\>)
- **Métodos**:
  - `agendarConsulta(Paciente, Medico, Date)`
  - `cancelarConsulta(Consulta)`
- **Descrição**: Gerencia a agenda do hospital, permitindo o agendamento e cancelamento de consultas.

#### 9. Classe `Hospital`
- **Atributos**:
  - `nome` (String)
  - `endereco` (String)
  - `funcionarios` (ArrayList\<Funcionario\>)
  - `pacientes` (ArrayList\<Paciente\>)
- **Métodos**:
  - `admitirFuncionario(Funcionario)`
  - `admitirPaciente(Paciente)`
  - `listarFuncionarios()`
  - `listarPacientes()`
- **Descrição**: Representa o hospital em si. Mantém listas de funcionários e pacientes e possui métodos para adicionar e listar informações sobre eles.

---

## Regras de Negócio

1. **Cadastro Único**: Cada paciente, médico e enfermeiro deve ter um número único de identificação (CPF para pacientes, CRM para médicos e COREN para enfermeiros).
2. **Controle de Acesso**: Somente administradores podem visualizar todos os dados dos funcionários e pacientes.
3. **Histórico de Saúde**: Apenas médicos e enfermeiros podem adicionar entradas ao histórico de saúde dos pacientes.
4. **Agendamento de Consultas**: O sistema deve verificar a disponibilidade do médico ao agendar uma nova consulta.
5. **Consulta**: Uma consulta só pode ser registrada se houver um paciente e um médico disponíveis no horário.

---

## Funcionalidades Extras

1. **Sistema de Notificações**: Enviar uma notificação para o paciente quando uma consulta é agendada ou cancelada.
2. **Relatórios Estatísticos**: Geração de relatórios sobre:
   - Número de pacientes atendidos por cada médico.
   - Número total de consultas realizadas no mês.
3. **Cálculo de Salário com Bonificação**: Calcular o salário do médico e dos enfermeiros considerando bonificações por atendimento extra.
4. **Interface Gráfica (Opcional)**: Criar uma interface gráfica usando Java Swing para que os dados possam ser manipulados visualmente.

---

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Paradigma**: Programação Orientada a Objetos (POO)
- **Bibliotecas**: 
  - `java.util` (para manipulação de listas e datas)
  - `java.swing` (opcional, para interface gráfica)

---
