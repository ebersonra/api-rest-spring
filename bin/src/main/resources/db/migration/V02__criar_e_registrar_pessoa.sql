CREATE TABLE pessoa (
	
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo TINYINT(1) NOT NULL,
	logradouro VARCHAR(60),
	numero VARCHAR(10),
	complemento VARCHAR(40),
	bairro VARCHAR(60),
	cep VARCHAR(15),
	cidade VARCHAR(60),
	estado VARCHAR(60)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Jana Silva',1,'Rua Duque de Caxias','123','Casa','Jd. America','19900-970','Ourinhos','São Paulo');
INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Rose Gomes',0,'Rua Jasmin do Rosário','23','Casa','Jd. Pinhais','89900-970','Curitiba','Paraná');
INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Valéria Dias',1,'Rua Bento Batista','13','Apto','Jd. Lucas','19900-800','Ourinhos','São Paulo');
INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Jo Souza',1,'Rua Ana Maria Silva','2123','Casa','Jd. America','19900-970','Ourinhos','São Paulo');
INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Paula Silva',0,'Rua Lordes Morais','1123','Apto','Alvorada','69900-970','Ourinhos','São Paulo');