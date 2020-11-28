CREATE TABLE IF NOT EXISTS arquivo (
   id bigint not null primary key AUTO_INCREMENT,
   name varchar(255) not null,
   data blob not null,
   beneficio_id bigint not null,
   arquivo_tipo_id bigint not null,
   foreign key (beneficio_id) references beneficio (id),
   foreign key (arquivo_tipo_id) references arquivo_tipo (id)
);