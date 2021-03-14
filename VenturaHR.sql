CREATE TABLE `usuarios` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`endereco` varchar(100) NOT NULL,
	`telefone` varchar(20) NOT NULL,
	`email` varchar(30) NOT NULL,
	`senha` varchar(32) NOT NULL,
	`cpf` varchar(11) NOT NULL,
	`razao_social` varchar(50) DEFAULT NULL,
	`cnpj` varchar(14) DEFAULT NULL,
	`tipo` char(1) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `email_UNIQUE` (`email`),
	UNIQUE KEY `cpf_UNIQUE` (`cpf`),
	UNIQUE KEY `cnpj_UNIQUE` (`cnpj`)
) ENGINE=InnoDB


CREATE TABLE `vagas` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_usuario` int NOT NULL,
	`cargo` varchar(45) NOT NULL,
	`cidade` varchar(100) NOT NULL,
	`forma_contratacao` varchar(45) NOT NULL,
	PRIMARY KEY (`id`),
	KEY `fk_usuarios_idx` (`id_usuario`),
	CONSTRAINT `fk_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB


CREATE TABLE `criterios` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_vaga` int NOT NULL,
	`descricao` varchar(45) NOT NULL,
	`perfil` int NOT NULL,
	`peso` int NOT NULL,
	PRIMARY KEY (`id`),
	KEY `fk_vaga_idx` (`id_vaga`),
	CONSTRAINT `fk_vaga` FOREIGN KEY (`id_vaga`) REFERENCES `vagas` (`id`)
) ENGINE=InnoDB