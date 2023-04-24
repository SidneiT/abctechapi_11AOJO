CREATE TABLE assistances
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `description` varchar(255) NOT NULL,
    `name`        varchar(150) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO assistances (name, description)
VALUES ('Telefones', 'Instalação/Manutenção de sistemas de telefone'),
       ('Redes','Instalação/Munutenção de sistemas de redes de dados'),
       ('Segurança Eletrôncia','Instalação/Manutenção de sistemas de segurança eletrônica'),
       ('Equipamentos de Comunicação','Instalação/Manutenção de equipamentos, como roteadores, modems e switches'),
       ('Ar-condicionado','Instalação/Manutenção de ar-condicionado'),
       ('Energia Solar','Instalação/Manutenção de sistemas de energia solar'),
       ('Troca de Fiação','Troca de fiação elétrica e quadros de distribuição'),
       ('Geradores Elétricos','Instalação/Manutenção de geradores elétricos'),
       ('Segurança Elétrica','Instalação/Manutenção de sistemas de segurança elétrica'),
       ('Sistemas Elétricos','Instalação/Manutenção de sistema elétricos'),
       ('Troca de Borrachas','Troca de borrachas de vedação em geladeiras e freezers'),
       ('Troca de Termostatos e Sensores','Troca de termostatos e sensores de temperatura em geladeiras e freezers'),
       ('Substituição de Compressor','Substituição de compressores em refrigeradores e freezer'),
       ('Troca de Correias','Troca de correias da máquina de lavar roupa'),
       ('Troca de Peças e componentes','Troca de peças e componentes em geral da máquina de lavar roupa.');
