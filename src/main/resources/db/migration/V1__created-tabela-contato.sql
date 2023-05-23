create table contato (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(16) not null unique,
    ativo tinyint not null,

    primary key(id)
)