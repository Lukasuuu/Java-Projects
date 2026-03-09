-- ====================================================
--  SCRIPT SQL COMPLETO - COM RELACIONAMENTOS
--  Sistema de Bioclimatologia Animal
--  (USUARIO simplificado: username, password, is_admin)
-- ====================================================

USE efa0125_08_projeto_java;

-- ====================================================
--  APAGAR TABELAS (ordem inversa das dependências)
-- ====================================================
DROP VIEW IF EXISTS vw_avaliacoes_completas;
DROP VIEW IF EXISTS vw_bovinos_completos;

DROP TABLE IF EXISTS avaliacao;
DROP TABLE IF EXISTS bovino;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS ambiente;
DROP TABLE IF EXISTS usuario;

-- ====================================================
--  TABELA 1: USUARIO (simplificada)
-- ====================================================
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_admin TINYINT(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ====================================================
--  TABELA 2: ANIMAL (pai na herança)
-- ====================================================
CREATE TABLE animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    peso DECIMAL(8,2) NOT NULL CHECK (peso > 0),
    idade INT NOT NULL CHECK (idade >= 0),

    INDEX idx_nome (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ====================================================
--  TABELA 3: BOVINO (filho na herança)
--  Relacionamento 1 (1:1): bovino.animal_id -> animal.id
-- ====================================================
CREATE TABLE bovino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT NOT NULL UNIQUE,   -- UNIQUE garante 1:1
    raca VARCHAR(50) NOT NULL,
    linhagem VARCHAR(20) NOT NULL,
    producao_leite DECIMAL(6,2) NOT NULL CHECK (producao_leite >= 0),

    FOREIGN KEY (animal_id)
        REFERENCES animal(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    INDEX idx_raca (raca),
    INDEX idx_linhagem (linhagem)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ====================================================
--  TABELA 4: AMBIENTE
-- ====================================================
CREATE TABLE ambiente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperatura DECIMAL(5,2) NOT NULL,
    umidade DECIMAL(5,2) NOT NULL CHECK (umidade >= 0 AND umidade <= 100),
    local VARCHAR(200) NOT NULL,
    data_registo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    INDEX idx_data_registo (data_registo),
    INDEX idx_local (local)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ====================================================
--  TABELA 5: AVALIACAO (junção)
--  Relacionamento 2 (1:N): avaliacao.bovino_id -> bovino.id
--  Relacionamento 3 (1:N): avaliacao.ambiente_id -> ambiente.id
-- ====================================================
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bovino_id INT NOT NULL,
    ambiente_id INT NOT NULL,
    valor_itu DECIMAL(6,2) NOT NULL,
    resultado VARCHAR(20) NOT NULL,
    data_avaliacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (bovino_id)
        REFERENCES bovino(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (ambiente_id)
        REFERENCES ambiente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    INDEX idx_bovino_id (bovino_id),
    INDEX idx_ambiente_id (ambiente_id),
    INDEX idx_data_avaliacao (data_avaliacao),
    INDEX idx_resultado (resultado),
    INDEX idx_bovino_data (bovino_id, data_avaliacao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ====================================================
--  DADOS DE TESTE
-- ====================================================

-- 1) USUARIOS
INSERT INTO usuario (username, password, is_admin) VALUES
('admin', '123', 1),
('lucas', 'lucas', 0),
('rui', '123', 0);

-- 2) ANIMAIS
INSERT INTO animal (nome, peso, idade) VALUES
('Mimosa', 450.0, 36),
('Estrela', 520.0, 48),
('Flor', 380.0, 24),
('Touro', 650.0, 60),
('Bella', 420.0, 30);

-- 3) BOVINOS (herdam de ANIMAL via animal_id)
INSERT INTO bovino (animal_id, raca, linhagem, producao_leite) VALUES
(1, 'Holstein', 'LEITE', 25.5),
(2, 'Charolês', 'CARNE', 0),
(3, 'Jersey', 'LEITE', 20.0),
(4, 'Angus', 'CARNE', 0),
(5, 'Girolando', 'DUPLA_APTIDAO', 18.0);

-- 4) AMBIENTES
INSERT INTO ambiente (temperatura, umidade, local, data_registo) VALUES
(28.5, 75.0, 'Estábulo Principal', NOW()),
(25.0, 65.0, 'Pasto Norte', NOW() - INTERVAL 1 DAY),
(32.0, 80.0, 'Curral Externo', NOW() - INTERVAL 3 HOUR),
(22.0, 60.0, 'Área Coberta', NOW() - INTERVAL 2 DAY);

-- 5) AVALIAÇÕES
INSERT INTO avaliacao (bovino_id, ambiente_id, valor_itu, resultado, data_avaliacao) VALUES
(1, 1, 79.77, 'ESTRESSE', NOW()),
(1, 2, 71.25, 'CONFORTO', NOW() - INTERVAL 1 DAY),
(1, 4, 68.40, 'CONFORTO', NOW() - INTERVAL 2 DAY),

(2, 1, 79.77, 'ESTRESSE', NOW()),
(2, 3, 85.20, 'ESTRESSE', NOW() - INTERVAL 3 HOUR),

(3, 2, 71.25, 'CONFORTO', NOW() - INTERVAL 1 DAY),
(3, 4, 68.40, 'CONFORTO', NOW() - INTERVAL 2 DAY);

-- ====================================================
--  VIEWS ÚTEIS
-- ====================================================

-- View: Bovinos completos (Animal + Bovino)
CREATE OR REPLACE VIEW vw_bovinos_completos AS
SELECT
    b.id AS bovino_id,
    b.animal_id,
    a.nome,
    a.peso,
    a.idade,
    b.raca,
    b.linhagem,
    b.producao_leite
FROM bovino b
INNER JOIN animal a ON b.animal_id = a.id;

-- View: Avaliações completas (Animal + Bovino + Ambiente + Avaliação)
CREATE OR REPLACE VIEW vw_avaliacoes_completas AS
SELECT
    av.id AS avaliacao_id,
    av.bovino_id,
    a.nome AS nome_bovino,
    b.raca,
    b.linhagem,
    av.ambiente_id,
    e.temperatura,
    e.umidade,
    e.local,
    av.valor_itu,
    av.resultado,
    av.data_avaliacao
FROM avaliacao av
INNER JOIN bovino b ON av.bovino_id = b.id
INNER JOIN animal a ON b.animal_id = a.id
INNER JOIN ambiente e ON av.ambiente_id = e.id;

-- ====================================================
--  VERIFICAÇÕES RÁPIDAS
-- ====================================================

-- Contar registos por tabela
SELECT 'usuarios' AS tabela, COUNT(*) AS total FROM usuario
UNION ALL
SELECT 'animais', COUNT(*) FROM animal
UNION ALL
SELECT 'bovinos', COUNT(*) FROM bovino
UNION ALL
SELECT 'ambientes', COUNT(*) FROM ambiente
UNION ALL
SELECT 'avaliacoes', COUNT(*) FROM avaliacao;

-- Ver relacionamentos em ação
SELECT
    'REL 1: Animal → Bovino (1:1)' AS tipo,
    COUNT(DISTINCT a.id) AS animais,
    COUNT(DISTINCT b.id) AS bovinos
FROM animal a
LEFT JOIN bovino b ON b.animal_id = a.id

UNION ALL

SELECT
    'REL 2: Bovino → Avaliação (1:N)',
    COUNT(DISTINCT b.id),
    COUNT(av.id)
FROM bovino b
LEFT JOIN avaliacao av ON av.bovino_id = b.id

UNION ALL

SELECT
    'REL 3: Ambiente → Avaliação (1:N)',
    COUNT(DISTINCT e.id),
    COUNT(av.id)
FROM ambiente e
LEFT JOIN avaliacao av ON av.ambiente_id = e.id;

SELECT 'Base de dados criada com sucesso!' AS status;
SELECT 'Relacionamentos configurados corretamente!' AS status;