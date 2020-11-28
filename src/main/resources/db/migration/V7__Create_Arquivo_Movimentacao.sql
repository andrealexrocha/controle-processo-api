CREATE TABLE IF NOT EXISTS arquivo_movimentacao (
   id bigint not null primary key AUTO_INCREMENT,
   data_tramitacao timestamp not null,
   parecer varchar(255) not null,
   arquivo_id bigint,
   setor_destino_id bigint not null,
   setor_origem_id bigint not null,
   foreign key (arquivo_id) references arquivo (id),
   foreign key (setor_destino_id) references setor (id),
   foreign key (setor_origem_id)  references setor (id)
);