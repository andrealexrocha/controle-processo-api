CREATE TABLE IF NOT EXISTS beneficio (
   id bigint not null primary key AUTO_INCREMENT,
   numero varchar(255) not null,
   funcionario_id bigint,
   foreign key (funcionario_id) references funcionario (id)
);