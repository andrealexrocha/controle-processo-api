CREATE TABLE IF NOT EXISTS funcionario (
    id bigint not null primary key AUTO_INCREMENT,
    cpf varchar(255) not null,
    matricula varchar(255) not null,
    name varchar(255) not null,
    orgao_id bigint not null,
    FOREIGN KEY (orgao_id) REFERENCES orgao (id)
);