insert into Produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 499.0, date_sub(sysdate(), interval 1 day), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, preco, data_criacao,descricao) values (3, 'Camera', 699.0, date_sub(sysdate(), interval 1 day),'que permite que você tire fotos');
INSERT INTO `algaworks_ecommerce`.`produto` (`id`, data_criacao,`descricao`, `nome`, `preco`) VALUES ('2', '2023-07-17 18:37:43.000000', 'Cert', 'Teclado', '129.00');


insert into cliente (id,nome) values (1,'Hudson Silva');
insert into cliente (id,nome) values (2,'Anderson Silva');

insert into categoria (id,nome) values (1, 'Eletrônicos');

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 100.0, 'AGUARDANDO');

INSERT INTO `algaworks_ecommerce`.`item_pedido` (`pedido_id`, `produto_id`, `preco_produto`, `quantidade`) VALUES ('1', '1', '129.00', '1');

