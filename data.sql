CREATE DATABASE locadora;
USE locadora;

CREATE TABLE pessoa (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(150) NOT NULL,
                        data_nascimento DATE NOT NULL,
                        cpf VARCHAR(14) UNIQUE NOT NULL,
                        sexo ENUM('FEMININO', 'MASCULINO') NOT NULL
);

CREATE TABLE motorista (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           pessoa_id BIGINT UNIQUE,
                           numero_cnh VARCHAR(20) NOT NULL,
                           email VARCHAR(150) UNIQUE NOT NULL,
                           FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE funcionario (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             pessoa_id BIGINT UNIQUE,
                             matricula VARCHAR(20) UNIQUE NOT NULL,
                             FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE fabricante (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(100) NOT NULL
);

CREATE TABLE modelo_carro (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              descricao VARCHAR(100),
                              categoria VARCHAR(50) NOT NULL,
                              fabricante_id BIGINT,
                              FOREIGN KEY (fabricante_id) REFERENCES fabricante(id)
);

CREATE TABLE carro (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       placa VARCHAR(10) UNIQUE NOT NULL,
                       chassi VARCHAR(50) UNIQUE NOT NULL,
                       cor VARCHAR(50),
                       valor_diaria DECIMAL(10,2),
                       modelo_id BIGINT,
                       status ENUM('DISPONIVEL', 'RESERVADO', 'ALUGADO') DEFAULT 'DISPONIVEL',
                       FOREIGN KEY (modelo_id) REFERENCES modelo_carro(id)
);

CREATE TABLE acessorio (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           descricao VARCHAR(100)
);

CREATE TABLE carro_acessorio (
                                 carro_id BIGINT,
                                 acessorio_id BIGINT,
                                 PRIMARY KEY (carro_id, acessorio_id),
                                 FOREIGN KEY (carro_id) REFERENCES carro(id),
                                 FOREIGN KEY (acessorio_id) REFERENCES acessorio(id)
);

CREATE TABLE apolice_seguro (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                valor_franquia DECIMAL(10,2),
                                protecao_terceiro BOOLEAN,
                                protecao_causas_naturais BOOLEAN,
                                protecao_roubo BOOLEAN
);

CREATE TABLE carrinho (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          pessoa_id BIGINT,
                          criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE carrinho_item (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               carrinho_id BIGINT,
                               carro_id BIGINT,
                               data_inicio DATE,
                               data_fim DATE,
                               valor_estimado DECIMAL(10,2),
                               FOREIGN KEY (carrinho_id) REFERENCES carrinho(id),
                               FOREIGN KEY (carro_id) REFERENCES carro(id)
);

CREATE TABLE aluguel (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         pessoa_id BIGINT,
                         carro_id BIGINT,
                         apolice_id BIGINT,
                         data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         data_entrega TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         data_devolucao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         valor_total DECIMAL(10,2),
                         status ENUM('CRIADO', 'CONFIRMADO', 'PAGO', 'CANCELADO'),
                         FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
                         FOREIGN KEY (carro_id) REFERENCES carro(id),
                         FOREIGN KEY (apolice_id) REFERENCES apolice_seguro(id)
);

CREATE TABLE pagamento (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           aluguel_id BIGINT,
                           metodo VARCHAR(50),
                           status VARCHAR(20),
                           valor DECIMAL(10,2),
                           FOREIGN KEY (aluguel_id) REFERENCES aluguel(id)
);

CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(150) UNIQUE NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         role VARCHAR(50)
);