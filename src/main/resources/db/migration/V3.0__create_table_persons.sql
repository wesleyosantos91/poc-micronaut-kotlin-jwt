CREATE TABLE persons (
    code BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    cpf VARCHAR(11),
    email VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;