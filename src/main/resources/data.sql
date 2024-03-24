INSERT INTO ROLE(nome) VALUES ('ADMIN');
INSERT INTO ROLE(nome) VALUES ('USER');

INSERT INTO USUARIO(email,nome,status,password) VALUES ('administrador@acme.com', 'Patolino',1 , '123456');
INSERT INTO USUARIO(email,nome,status,password) VALUES ('exfuncionario@acme.com', 'Eufrasino',2 , '123456');

INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (1,1);
INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (2,1);
INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (2,2);

-- Inserts para a tabela Comida
INSERT INTO COMIDA(CODIGO, NOME, VALOR, INGREDIENTES, PESO, VEGANO)
VALUES
(UUID(), 'Hamburguer', 30, 'Pão - 1 Hamburguer - Alface - Tomate - Cebola - 1 Quejo - Ovo', 10, FALSE),
(UUID(), 'Pizza', 25, 'Massa - Molho de tomate - Queijo - Presunto - Cebola - Azeitonas', 15, FALSE),
(UUID(), 'Salada', 20, 'Alface - Tomate - Pepino - Cenoura - Beterraba - Molho vinagrete', 5, TRUE);

-- Inserts para a tabela Bebida
INSERT INTO BEBIDA(CODIGO, NOME, VALOR, GELADA, TAMANHO, MARCA)
VALUES
(UUID(), 'Coca-Cola', 5, TRUE, 500, 'Coca-Cola'),
(UUID(), 'Fanta', 7, FALSE, 300, 'Suco de Laranja'),
(UUID(), 'Sprite', 3, TRUE, 500, 'Crystal');

-- Inserts para a tabela Sobremesa
INSERT INTO SOBREMESA(CODIGO, NOME, VALOR, QUANTIDADE, DOCE, INFORMACAO)
VALUES
(UUID(), 'Sundae', 8, 200, TRUE, 'Sorvete de Chocolate'),
(UUID(), 'Bolo', 10, 1, TRUE, 'Bolo de Morango'),
(UUID(), 'Pudim', 6, 1, TRUE, 'Pudim de Leite Condensado');

-- Inserir solicitação 1
INSERT INTO Solicitante (nome, cpf, email) VALUES ('João Silva', '123.456.789-00', 'joao.silva@example.com');

-- Inserir solicitação 2
INSERT INTO Solicitante (nome, cpf, email) VALUES ('Maria Santos', '987.654.321-00', 'maria.santos@example.com');

-- Inserir solicitação 3
INSERT INTO Solicitante (nome, cpf, email) VALUES ('Carlos Oliveira', '111.222.333-00', 'carlos.oliveira@example.com');
