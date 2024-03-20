
                CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
                CREATE TABLE account(
                        account_id serial primary key ,
                        client_name varchar(200),
                        client_last_name varchar(200),
                        date_of_birth date,
                        net_salary_per_month double precision,
                        account_number UUID DEFAULT uuid_generate_v4(),
                        bank_name bank_name,
                        default_solde double precision
                );