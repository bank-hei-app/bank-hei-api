CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS account(
    account_id serial PRIMARY KEY,
    client_name varchar(200),
    client_last_name varchar(200),
    date_of_birth date,
    net_salary_per_month double precision,
    account_number UUID DEFAULT uuid_generate_v4(),
    bank_name varchar(200),
    default_solde double precision
    );
