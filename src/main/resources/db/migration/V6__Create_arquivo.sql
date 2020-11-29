CREATE TABLE IF NOT EXISTS arquivo (
   id bigint not null primary key AUTO_INCREMENT,
   nome varchar(255) not null,
   descricao varchar(255) not null,
   tipo varchar(255) not null,
   tamanho varchar(255) not null,
   binario blob not null,
   beneficio_id bigint not null,
   arquivo_tipo_id bigint not null,
   foreign key (beneficio_id) references beneficio (id),
foreign key (arquivo_tipo_id) references arquivo_tipo (id)
);