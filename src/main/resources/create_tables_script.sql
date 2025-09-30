-- Tabla Wallet
CREATE TABLE wallets (
    id SERIAL PRIMARY KEY,
    salary NUMERIC(15,2) NOT NULL,
    salary_in_dollars NUMERIC(15,2)
);

-- Tabla Person
CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT,
    wallet_id INT,
    CONSTRAINT fk_wallet FOREIGN KEY (wallet_id) REFERENCES wallet(id)
);
