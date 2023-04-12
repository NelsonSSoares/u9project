CREATE TABLE IF NOT EXISTS usuario (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL,
    ativo TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS endereco(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    apelido VARCHAR(45) NOT NULL,
    rua VARCHAR(45) NOT NULL,
    numero VARCHAR(45) NOT NULL,
	complemento VARCHAR(45),
    cep VARCHAR(9) NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    estado VARCHAR(45) NOT NULL,
    pais_id INTEGER REFERENCES pais (id),
    usuario_id INTEGER REFERENCES usuario (id),
    endereco_padrao TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS pais(
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(45) NOT NULL,
 codigo VARCHAR(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedido(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    usuario_id INTEGER REFERENCES usuario (id),
    data_criacao DATETIME,
    status_pedido INTEGER,
    numero_pedido INTEGER
);

CREATE TABLE IF NOT EXISTS detalhes_pedido(
	pedido_id INTEGER REFERENCES pedido (id),
    produto_id INTEGER REFERENCES produto (id),
    quantidade INTEGER,
    total DECIMAL
);

CREATE TABLE IF NOT EXISTS produto(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    subcategoria_id INTEGER REFERENCES subcategoria (id),
    categoria_id INTEGER REFERENCES catedoria (id),
    nome_produto VARCHAR(45) NOT NULL,
    descricao VARCHAR(45) NOT NULL,
    sku INTEGER NOT NULL,
    data_criacao DATETIME(45) NOT NULL,
    valor_unitario DECIMAL(100) NOT NULL,
    estoque INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome_categoria VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS subcategoria(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome_sub_categoria VARCHAR(45) NOT NULL,
    descricao VARCHAR(45) NOT NULL,
    categoria_id INTEGER REFERENCES categoria (id)
);