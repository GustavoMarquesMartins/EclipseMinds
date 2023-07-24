create table funcionarios(

                        id bigint primary key auto_increment not null,
                        nome varchar(100) not null,
                        telefone varchar(100) not null,
                        salario DECIMAL(10, 2) not null ,
                        logradouro varchar(100) not null,
                        bairro varchar(100) not null,
                        cep varchar(9) not null,
                        complemento varchar(100),
                        numero varchar(20),
                        uf char(2) not null,
                        cidade varchar(100) not null
);