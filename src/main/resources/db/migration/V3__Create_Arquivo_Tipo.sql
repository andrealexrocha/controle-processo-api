CREATE TABLE IF NOT EXISTS arquivo_tipo (
   id bigint not null PRIMARY KEY AUTO_INCREMENT,
   descricao varchar(255) not null,
   ativo boolean not null
);