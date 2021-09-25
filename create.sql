create table deposito (id integer not null, nome varchar(255), endereco_id integer, primary key (id)) engine=InnoDB
create table endereco_deposito (id integer not null, bairro varchar(255), cep varchar(255), cidade varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id)) engine=InnoDB
create table endereco_user (id integer not null, bairro varchar(255), cep varchar(255), cidade varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table user (id integer not null, contato varchar(255), cpf varchar(255), email varchar(255), nome varchar(255), pontos integer, senha varchar(255), deposito_id integer, endereco_id integer, primary key (id)) engine=InnoDB
alter table deposito add constraint FKqft4lgpls69iw81br5u27xn4s foreign key (endereco_id) references endereco_deposito (id)
alter table user add constraint FKolohxke8occmcsy5bycwq4prs foreign key (deposito_id) references deposito (id)
alter table user add constraint FKjrtue7ycc9bqiwqunklxcbiii foreign key (endereco_id) references endereco_user (id)
