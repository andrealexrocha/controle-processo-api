CREATE TABLE IF NOT EXISTS setor (
   id bigint not null PRIMARY KEY AUTO_INCREMENT,
   codigo varchar(255) not null,
   descricao varchar(255) not null,
   ativo boolean not null
);