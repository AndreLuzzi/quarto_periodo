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
create or replace procedure sp_recalcular_total(
    p_id_pedido int
)
language plpgsql
as $$
declare
    v_total numeric;
begin
    select coalesce(sum(subtotal), 0)
    into v_total
    from itens_pedido
    where id_pedido = p_id_pedido;

    update pedidos
    set total = v_total
    where id_pedido = p_id_pedido;
end;
$$;

call sp_recalcular_total(1);

--4 MEDIUM
create or replace procedure sp_aplicar_desconto_status(
    p_id_pedido int
)
language plpgsql
as $$
declare
    v_total numeric;
    v_status text;
begin
    select p.total, c.status_cliente
    into v_total, v_status
    from pedidos p
    inner join clientes c on c.id_cliente = p.id_cliente
    where p.id_pedido = p_id_pedido;

    update pedidos
    set total = case v_status
                    when 'STANDARD' then v_total
                    when 'GOLD' then v_total * 0.95   -- 5% desconto
                    when 'PLATINUM' then v_total * 0.90 -- 10% desconto
                end
    where id_pedido = p_id_pedido;
end;
$$;

call sp_aplicar_desconto_status(1);

--5 MEDIUM
create or replace procedure sp_registrar_pagamento(
    p_id_pedido int,
    p_valor numeric,
    p_forma varchar(20)
)
language plpgsql
as $$
declare
    v_total_pedido numeric;
    v_soma_pagamentos numeric;
begin
    select total into v_total_pedido
    from pedidos
    where id_pedido = p_id_pedido;

    if p_valor > v_total_pedido * 1.2 then
        raise exception 'Pagamento não pode ser maior que 120% do total do pedido';
    end if;

    insert into pagamentos (id_pedido, valor, forma)
    values (p_id_pedido, p_valor, p_forma);

    select coalesce(sum(valor), 0)
    into v_soma_pagamentos
    from pagamentos
    where id_pedido = p_id_pedido;

    if v_soma_pagamentos >= v_total_pedido then
        update pedidos
        set status_pedido = 'fechado'
        where id_pedido = p_id_pedido;
    end if;
end;
$$;

call sp_registrar_pagamento(1, 500, 'pix');

--1 HARD
create or replace procedure sp_cancelar_pedido(
    p_id_pedido int
)
language plpgsql
as $$
declare
    v_status varchar(20);
    r_item record;
begin
    select status_pedido into v_status
    from pedidos
    where id_pedido = p_id_pedido;

    if v_status is null then
        raise exception 'Esse pedido não existe';
    end if;

    if v_status <> 'aberto' then
        raise exception 'Só é possível cancelar pedidos com status ABERTO';
    end if;

    for r_item in
        select id_produto, quantidade
        from itens_pedido
        where id_pedido = p_id_pedido
    loop
        update produtos
        set estoque = estoque + r_item.quantidade
        where id_produto = r_item.id_produto;
    end loop;

    update pedidos
    set status_pedido = 'cancelado'
    where id_pedido = p_id_pedido;
end;
$$;

call sp_cancelar_pedido(1);

--2 HARD
create or replace procedure sp_trocar_item(
    p_id_pedido int,
    p_id_produto_antigo int,
    p_id_produto_novo int,
    p_qtd int
)
language plpgsql
as $$
declare
    v_preco numeric;
    v_estoque int;
begin
    update produtos
    set estoque = estoque + (
		select quantidade 
	    from itens_pedido
	    where id_pedido = p_id_pedido
	    and id_produto = p_id_produto_antigo
	)
    where id_produto = p_id_produto_antigo;

    delete from itens_pedido
    where id_pedido = p_id_pedido
      and id_produto = p_id_produto_antigo;

    select preco, estoque
    into v_preco, v_estoque
    from produtos
    where id_produto = p_id_produto_novo;

    if v_estoque < p_qtd then
        raise exception 'Estoque insuficiente para o produto %', p_id_produto_novo;
    end if;

    insert into itens_pedido (id_pedido, id_produto, quantidade, preco_unit)
    values (p_id_pedido, p_id_produto_novo, p_qtd, v_preco);

    update produtos
    set estoque = estoque - p_qtd
    where id_produto = p_id_produto_novo;

exception
    when others then
        raise exception 'Falha ao trocar item do pedido';
end;
$$;

call sp_trocar_item(1, 2, 5, 10);

--3 HARD
create or replace procedure sp_promover_clientes_por_gasto(
    p_valor_minimo numeric
)
language plpgsql
as $$
begin
    update clientes c
    set status_cliente = case 
                            when c.status_cliente = 'STANDARD' then 'GOLD'
                            else c.status_cliente
                         end
    where c.id_cliente in (
        select p.id_cliente
        from pedidos p
        where p.status_pedido = 'FECHADO'
          and p.data_pedido >= current_date - interval '1 year'
        group by p.id_cliente
        having sum(p.total) >= p_valor_minimo
    );
end;
$$;

call sp_promover_clientes_por_gasto(2000);

--4 HARD
create or replace procedure sp_fechamento_mensal_cliente(
    p_id_cliente int,
    p_ano int,
    p_mes int,
    inout total_pedidos numeric default 0,
    inout total_pago numeric default 0,
    inout em_aberto numeric default 0
)
language plpgsql
as $$
begin
    select coalesce(sum(total), 0)
    into total_pedidos
    from pedidos
    where id_cliente = p_id_cliente
      and extract(year from data_pedido) = p_ano
      and extract(month from data_pedido) = p_mes;

    select coalesce(sum(valor), 0)
    into total_pago
    from pagamentos
    where id_pedido in (
        select id_pedido
        from pedidos
        where id_cliente = p_id_cliente
    )
      and extract(year from data_pagamento) = p_ano
      and extract(month from data_pagamento) = p_mes;

    em_aberto := total_pedidos - total_pago;
end;
$$;

call sp_fechamento_mensal_cliente(101, 2025, 5, null, null, null);

--5 HARD
create or replace procedure sp_substituir_preco_por_faixa(
    p_id_produto int,
    p_faixa text
)
language plpgsql
as $$
declare
    v_preco_atual numeric;
    v_preco_novo numeric;
begin
    select preco
    into v_preco_atual
    from produtos
    where id_produto = p_id_produto;

    v_preco_novo := case p_faixa
        when 'PROMO10' then v_preco_atual * 0.90
        when 'PROMO20' then v_preco_atual * 0.80
        when 'AUMENTO5' then v_preco_atual * 1.05
        else v_preco_atual
    end;

    if v_preco_novo < 0 then
        raise exception 'O preço não pode ficar negativo';
    end if;

    update produtos
    set preco = v_preco_novo
    where id_produto = p_id_produto;
end;
$$;

call sp_substituir_preco_por_faixa(1, 'PROMO20');
call sp_substituir_preco_por_faixa(2, 'AUMENTO5');
call sp_substituir_preco_por_faixa(3, 'INVALIDO');