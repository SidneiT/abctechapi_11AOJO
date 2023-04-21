CREATE TABLE assistances
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `description` varchar(255) NOT NULL,
    `name`        varchar(150) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO assistances (description, name)
VALUES ('Description 1', 'Name 1'),
       ('Description 2', 'Name 2'),
       ('Description 3', 'Name 3');

