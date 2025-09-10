create table pedidos(
	id_pedido serial primary key,
	id_cliente int references clientes(id_cliente),
	data_pedido date default current_timestamp,
	status_pedido varchar(20) default 'aberto'
		check (status_pedido in ('aberto', 'fechado', 'cancelado')),
	total numeric
)
select*from pedidos
	
insert into pedidos (id_cliente, status_pedido, total) values
    (7, 'aberto', 0),
    (10, 'aberto', 0);

create table clientes(
    id_cliente serial primary key,
    nome varchar(200) not null,
    email varchar(200) unique not null,
    status_cliente varchar(20) default 'standard'
        check (status_cliente in ('standard', 'gold', 'platinum')),
    data_cadastro date default current_date,
    saldo_credito numeric(12,2) default 0
)
select*from clientes
	
insert into clientes (nome, email, status_cliente, saldo_credito) values 
	('Andre', 'andre@outlook.com', 'platinum', 10000),
	('Leonardo' , 'leonardo@gmail.com', 'standard', 100),
	('Henrique', 'henrique@hotmail.com', 'standard', 100),
	('Alan', 'alan@gmail.com', 'gold', 1000),
	('Letícia', 'leticia@hotmail.com', 'gold', 800);

create table pagamentos(
	id_pagamento serial primary key,
	id_pedido int references pedidos(id_pedido),
	valor numeric not null check (valor > 0),
	data_pagamento date default current_timestamp,
	forma varchar(20) default 'cartao'
		check (forma in ('pix', 'boleto'))
)

create table produtos (
    id_produto serial primary key,
    nome varchar(100) not null,
    preco numeric(12,2) not null check (preco > 0),
    estoque int default 0 check (estoque >= 0),
    ativo boolean default true
)
select*from produtos
	
insert into produtos (nome, preco, estoque, ativo) values
	('mause gamer', 120, 7, true),
	('monitor', 1150, 4, true),
	('RTX6090', 6000, 0, false),
	('teclado gamer', 350, 5, true),
	('mausepad', 100, 15, true)

create table itens_pedido (
    id_item serial primary key,
    id_pedido int references pedidos(id_pedido),
    id_produto int references produtos(id_produto),
    quantidade int not null check (quantidade > 0),
    preco_unit numeric(12,2) not null check (preco_unit >= 0),
    subtotal numeric(12,2) generated always as (quantidade * preco_unit) stored
)
select*from itens_pedido
	
insert into itens_pedido (id_pedido, id_produto, quantidade, preco_unit) values
    (5, 1, 2, 120),
    (5, 4, 1, 350),
    (5, 5, 3, 100);
	
insert into itens_pedido (id_pedido, id_produto, quantidade, preco_unit) values
    (6, 2, 1, 1150),
    (6, 1, 1, 120),
    (6, 4, 2, 350),
    (6, 5, 2, 100);

--1 EASY
create or replace procedure sp_inserir_cliente(
    p_nome varchar,
    p_email varchar
)
language plpgsql
as $$
begin
    insert into clientes (nome, email, status_cliente)
    values (p_nome, p_email, 'standard');
end;
$$;

call sp_inserir_cliente('Thaina', 'thaina@gmail.com');

--2 EASY
create or replace procedure sp_ativar_produto(
    p_id_produto int,
    p_ativo boolean
)
language plpgsql
as $$
begin
    if not exists (select 1 from produtos where id_produto = p_id_produto) then
        raise exception 'Esse produto não existe';
    end if;
    update produtos
    set ativo = p_ativo
    where id_produto = p_id_produto;
end;
$$;

call sp_ativar_produto(999, true);
call sp_ativar_produto(3, true);

--3 EASY
create or replace procedure sp_repor_estoque(
    p_id_produto int,
    p_qtd int
)
language plpgsql
as $$
begin
    if p_qtd <= 0 then
        raise exception 'A quantidade tem que ser maior que zero';
    end if;
    update produtos
    set estoque = estoque + p_qtd
    where id_produto = p_id_produto;
end;
$$;

call sp_repor_estoque(1, 5);

--4 EASY
create or replace procedure sp_reajustar_preco(
    p_id_produto int,
    p_percentual numeric
)
language plpgsql
as $$
declare
    v_preco_atual numeric;
    v_preco_novo numeric;
begin
    select preco into v_preco_atual
    from produtos
    where id_produto = p_id_produto;

    v_preco_novo := v_preco_atual * (1 + p_percentual / 100);

    if v_preco_novo < 0 then
        raise exception 'O preço não pode ficar negativo';
    end if;

    update produtos
    set preco = v_preco_novo
    where id_produto = p_id_produto;
end;
$$;

call sp_reajustar_preco(1, 10);

--5 EASY
create or replace procedure sp_mudar_status_cliente(
    p_id_cliente int,
    p_novo_status varchar
)
language plpgsql
as $$
begin
    if p_novo_status not in ('STANDARD', 'GOLD', 'PLATINUM') then
        raise exception 'Status inválido, Use STANDARD, GOLD ou PLATINUM';
    end if;

    update clientes
    set status_cliente = p_novo_status
    where id_cliente = p_id_cliente;
end;
$$;

call sp_mudar_status_cliente (1, 'STANDARD');

--1 MEDIUM
create or replace procedure sp_abrir_pedido(
    p_id_cliente int,
    inout p_id_pedido int
)
language plpgsql
as $$
begin
    insert into pedidos (id_cliente, status_pedido, total)
    values (p_id_cliente, 'aberto', 0)
    returning id_pedido into p_id_pedido;
end;
$$;

call sp_abrir_pedido (7, 3);

--2 MEDIUM
create or replace procedure sp_adicionar_item(
    p_id_pedido int,
    p_id_produto int,
    p_qtd int
)
language plpgsql
as $$
declare
    v_estoque int;
    v_preco numeric;
begin
    select estoque, preco
    into v_estoque, v_preco
    from produtos
    where id_produto = p_id_produto;

    if v_estoque < p_qtd then
        raise exception 'Estoque insuficiente para o produto';
    end if;

    insert into itens_pedido (id_pedido, id_produto, quantidade, preco_unit)
    values (p_id_pedido, p_id_produto, p_qtd, v_preco);

    update produtos
    set estoque = estoque - p_qtd
    where id_produto = p_id_produto;
end;
$$;

call sp_adicionar_item(1, 2, 3);

--3 MEDIUM
