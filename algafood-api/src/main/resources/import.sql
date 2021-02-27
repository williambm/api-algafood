insert into cozinha (id,nome) values(1,'Brasileira');
insert into cozinha (id,nome) values(2,'Italiana');
insert into cozinha (id,nome) values(3,'Tailandesa');
insert into cozinha (id,nome) values(4,'Indiana');

insert into restaurante (nome,taxa_frete,cozinha_id) values('Degas',5.60,1);
insert into restaurante (nome,taxa_frete,cozinha_id) values('DiBambino',2.50,2);

insert into forma_pagamento (descricao) values ("Débito");
insert into forma_pagamento (descricao) values ("Crédito");

insert into permissao (descricao,nome) values ("Apenas faz pedido de comida","consumidor");
insert into permissao (descricao,nome) values ("vizualiza,executa e despacha pedidos","restaurante");

insert into estado (nome,id) values ("São Paulo",1);
insert into estado (nome,id) values ("Minas Gerais",2);

insert into cidade (nome,estado_id) values ("São Paulo",1);
insert into cidade (nome,estado_id) values ("Paulinea",1);
insert into cidade (nome,estado_id) values ("Bragança Paulista",1);
insert into cidade (nome,estado_id) values ("Extrema",2);
insert into cidade (nome,estado_id) values ("Poços de Caldas",2);
