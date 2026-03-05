# 🐄 ConfortAnimal — Sistema de Bioclimatologia Animal

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![NetBeans](https://img.shields.io/badge/NetBeans-IDE-brightgreen?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/Licença-Académica-lightgrey?style=for-the-badge)

<br>

> **Sistema desktop em Java Swing para avaliação do conforto térmico de bovinos,**  
> **utilizando o Índice de Temperatura e Umidade (ITU) como base científica.**

<br>

</div>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Base de Dados](#-base-de-dados)
- [Fórmula ITU](#-fórmula-itu)
- [Como Executar](#-como-executar)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Autor](#-autor)

---

## 🌱 Sobre o Projeto

O **ConfortAnimal** é um sistema desenvolvido como projeto de conclusão de disciplina, aplicando conceitos de **Bioclimatologia Animal** — área da Zootecnia que estuda como as condições climáticas afetam o bem-estar e o desempenho dos animais.

O sistema permite que produtores rurais monitorizem as condições térmicas da sua propriedade e avaliem automaticamente o conforto dos seus bovinos, gerando um histórico de avaliações consultável a qualquer momento.

### 🎯 Objetivo

Centralizar informações sobre animais e condições climáticas, permitindo uma avaliação objetiva e científica do estado térmico a que os bovinos estão sujeitos, com uma interface simples e acessível.

---

## ✅ Funcionalidades

### 👤 Autenticação
- [x] Login com username e senha
- [x] Controlo de acesso por perfil (Admin / Produtor Rural)
- [x] Indicador visual do utilizador logado na barra de menu
- [x] Logout com confirmação

### 🐄 Gestão de Animais
- [x] Registar bovinos (nome, peso, idade, raça, linhagem, produção de leite)
- [x] Listar todos os animais registados
- [x] Remover animais
- [x] Herança de dados entre tabelas `animal` e `bovino`

### 🌡️ Gestão de Ambientes
- [x] Registar condições climáticas (temperatura, umidade, local)
- [x] Listar todos os ambientes com data de registo
- [x] Remover ambientes
- [x] Histórico de condições ao longo do tempo

### 📊 Avaliações ITU
- [x] Gerar avaliações automáticas para todos os bovinos
- [x] Seleção do ambiente via ComboBox
- [x] Cálculo automático do ITU por bovino
- [x] Classificação: **CONFORTO / ALERTA / ESTRESSE**
- [x] Tabela de resultados com Animal, Local, ITU, Resultado e Data

---

## 🛠️ Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| **Java** | 17+ | Linguagem principal |
| **Java Swing** | — | Interface gráfica desktop |
| **MySQL** | 8.0 | Base de dados relacional |
| **JDBC** | — | Conexão Java ↔ MySQL |
| **NetBeans IDE** | — | Ambiente de desenvolvimento |
| **Apache ANT** | — | Build do projeto |

---

## 🏗️ Arquitetura

O projeto segue a arquitetura em **3 camadas**, garantindo separação de responsabilidades e facilidade de manutenção:

```
┌──────────────────────────────────────────────────┐
│              APRESENTAÇÃO (Swing)                 │
│         ConfortAnimal.java  /  Login.java         │
│   Interface gráfica, eventos, exibição de dados   │
└─────────────────────┬────────────────────────────┘
                      │ chama
┌─────────────────────▼────────────────────────────┐
│                  SERVICE                          │
│  AmbienteService / AnimalService / AvaliacaoService│
│   Regras de negócio, validações, cálculo do ITU   │
└─────────────────────┬────────────────────────────┘
                      │ chama
┌─────────────────────▼────────────────────────────┐
│               PERSISTENCE (DB)                    │
│   AmbienteDB / BovinoDB / AvaliacaoDB / AnimalDB  │
│         Apenas SQL — INSERT, SELECT, DELETE       │
└─────────────────────┬────────────────────────────┘
                      │
┌─────────────────────▼────────────────────────────┐
│                  MySQL DATABASE                   │
│   usuario / animal / bovino / ambiente / avaliacao│
└──────────────────────────────────────────────────┘
```

---

## 🗄️ Base de Dados

### Diagrama de Relacionamentos

```
┌───────────┐       ┌─────────────────┐
│  USUARIO  │       │     ANIMAL      │ ← PAI (herança)
│  (login)  │       │  id, nome, peso │
└───────────┘       │  idade          │
  sem FK            └────────┬────────┘
                             │ 1:1
                    ┌────────▼────────┐
                    │    BOVINO       │ ← FILHO
                    │  animal_id (FK) │
                    │  raca, linhagem │
                    │  producao_leite │
                    └────────┬────────┘
                             │ 1:N
                    ┌────────▼────────┐
                    │   AVALIACAO     │ ← RESULTADO ITU
                    │  bovino_id (FK) │
                    │  ambiente_id(FK)│
                    │  valor_itu      │
                    │  resultado      │
                    └────────▲────────┘
                             │ 1:N
                    ┌────────┴────────┐
                    │    AMBIENTE     │
                    │  temperatura    │
                    │  umidade        │
                    │  local          │
                    └─────────────────┘
```

### Tabela de Relacionamentos

| Tabela | FK | Referência | Tipo |
|---|---|---|---|
| `bovino` | `animal_id` | `animal.id` | 1:1 Herança |
| `avaliacao` | `bovino_id` | `bovino.id` | N:1 |
| `avaliacao` | `ambiente_id` | `ambiente.id` | N:1 |

---

## 🧮 Fórmula ITU

O sistema utiliza a fórmula científica do **Índice de Temperatura e Umidade (ITU)**:

```
ITU = (0.8 × T) + ((UR / 100) × (T - 14.4)) + 46.4

Onde:
  T  = Temperatura em graus Celsius (°C)
  UR = Umidade Relativa do ar em percentagem (%)
```

### Classificação do Resultado

| Valor ITU | Classificação | Significado |
|---|---|---|
| ITU < 72 | 🟢 **CONFORTO** | Animal sem stress térmico |
| 72 ≤ ITU < 79 | 🟡 **ALERTA** | Atenção necessária |
| ITU ≥ 79 | 🔴 **ESTRESSE** | Risco ao bem-estar animal |

---

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 17 ou superior instalado
- MySQL 8.0 instalado e a correr
- NetBeans IDE 15 (recomendado) ou outro IDE Java

### Passo a Passo

**1. Clonar o repositório**
```bash
git clone https://github.com/SEU_USUARIO/ConfortAnimal.git
```

**2. Configurar a base de dados**
```bash
# No MySQL, executar o script SQL incluído no projeto
mysql -u root -p < database/script.sql
```

**3. Configurar a conexão**

Editar o ficheiro `src/persistence/Conexao.java` com as suas credenciais:
```java
private static final String URL  = "jdbc:mysql://localhost:3306/efa0125_08_projeto_java";
private static final String USER = "seu_usuario";
private static final String PASS = "sua_senha";
```

**4. Executar o projeto**

No NetBeans: `Run → Run Project (F6)`

### Credenciais de Teste

| Utilizador | Password | Perfil |
|---|---|---|
| `admin` | `123` | Administrador 👑 |
| `lucas` | `lucas` | Produtor Rural 👤 |

---

## 📁 Estrutura do Projeto

```
ConfortAnimal/
│
├── src/
│   ├── apresentation/          # Interface gráfica (Swing)
│   │   ├── ConfortAnimal.java  # Janela principal
│   │   └── Login.java          # Janela de login
│   │
│   ├── model/                  # Entidades do sistema
│   │   ├── Animal.java         # Superclasse Animal
│   │   ├── Bovino.java         # Herda de Animal
│   │   ├── Ambiente.java       # Condições climáticas
│   │   ├── Avaliacao.java      # Resultado ITU
│   │   └── Usuario.java        # Utilizador do sistema
│   │
│   ├── persistence/            # Acesso à base de dados (SQL)
│   │   ├── Conexao.java        # Conexão MySQL
│   │   ├── AnimalDB.java
│   │   ├── BovinoDB.java
│   │   ├── AmbienteDB.java
│   │   ├── AvaliacaoDB.java
│   │   └── UsuarioDB.java
│   │
│   ├── service/                # Regras de negócio
│   │   ├── AnimalService.java
│   │   ├── AmbienteService.java
│   │   ├── AvaliacaoService.java  # Cálculo do ITU
│   │   ├── BovinoService.java
│   │   └── UsuarioService.java
│   │
│   └── exception/              # Exceções personalizadas
│       ├── ConexaoBDException.java
│       ├── DadosInvalidosException.java
│       └── ProjetoException.java
│
├── database/
│   └── script.sql              # Script completo da base de dados
│
└── README.md
```

---

## 👨‍💻 Autor

<div align="center">

**Lucas**  
Estudante de Programação  
Projeto de Conclusão de Disciplina

[![GitHub](https://img.shields.io/badge/GitHub-perfil-black?style=for-the-badge&logo=github)](https://github.com/SEU_USUARIO)

</div>

---

<div align="center">

*Desenvolvido com ☕ Java e 🐄 paixão pela Zootecnia*

</div>
