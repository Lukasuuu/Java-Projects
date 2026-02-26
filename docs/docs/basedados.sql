-- ====================================================
--  SCRIPT COMPLETO - EXECUTAR TUDO DE UMA VEZ
--  Sistema de Bioclimatologia com Herança
-- ====================================================

-- Seleciona a base de dados
USE efa0125_08_projeto_java;

-- ====================================================
--  PARTE 1: CRIAR AS TABELAS
-- ====================================================

-- Tabela usuario
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_utilizador VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    nome_completo VARCHAR(100) NOT NULL,
    e_admin BOOLEAN DEFAULT FALSE
);

-- Tabela animal (contém Animal + Bovino)
CREATE TABLE animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    peso DECIMAL(8,2) NOT NULL,
    idade INT NOT NULL,
    raca VARCHAR(50) NOT NULL,
    linhagem VARCHAR(20) NOT NULL,
    producao_leite DECIMAL(6,2) NOT NULL
);

-- Tabela ambiente
CREATE TABLE ambiente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperatura DECIMAL(5,2) NOT NULL,
    umidade DECIMAL(5,2) NOT NULL,
    local VARCHAR(200) NOT NULL,
    data_registo DATETIME NOT NULL
);

-- Tabela avaliacao
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_animal INT NOT NULL,
    id_ambiente INT NOT NULL,
    valor_itu DECIMAL(6,2) NOT NULL,
    resultado VARCHAR(20) NOT NULL,
    data_avaliacao DATETIME NOT NULL
);

-- ====================================================
--  PARTE 2: INSERIR DADOS DE TESTE
-- ====================================================

-- Usuarios
INSERT INTO usuario (nome_utilizador, senha, nome_completo, e_admin) VALUES
('admin', 'admin', 'Administrador do Sistema', TRUE),
('lucas', 'lucas', 'Lucas Goncalves', FALSE);

-- Bovinos (demonstram herança)
INSERT INTO animal (nome, peso, idade, raca, linhagem, producao_leite) VALUES
('Mimosa', 450.0, 36, 'Holstein', 'LEITE', 25.5),
('Estrela', 520.0, 48, 'Charoles', 'CARNE', 0),
('Flor', 380.0, 24, 'Jersey', 'LEITE', 20.0),
('Touro', 650.0, 60, 'Angus', 'CARNE', 0),
('Bella', 420.0, 30, 'Girolando', 'DUPLA_APTIDAO', 18.0);

-- Ambientes
INSERT INTO ambiente (temperatura, umidade, local, data_registo) VALUES
(28.5, 75.0, 'Estabulo Principal', NOW()),
(25.0, 65.0, 'Pasto Norte', NOW() - INTERVAL 1 DAY),
(32.0, 80.0, 'Curral Externo', NOW() - INTERVAL 3 HOUR);

-- ====================================================
--  FIM DO SCRIPT
-- ====================================================

-- Verificar se tudo foi criado
SELECT 'Tabelas criadas com sucesso!' AS Status;
SELECT COUNT(*) AS Total_Usuarios FROM usuario;
SELECT COUNT(*) AS Total_Animais FROM animal;
SELECT COUNT(*) AS Total_Ambientes FROM ambiente;
