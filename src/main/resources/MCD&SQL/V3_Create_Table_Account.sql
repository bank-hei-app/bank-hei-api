
                CREATE TABLE account(
                        account_id int primary key ,
                        client_name varchar(200),
                        client_last_name varchar(200),
                        date_of_birth date,
                        net_salary_per_month double precision,
                        account_number varchar (50),
                        bank_id int references bank(bank_id),
                        default_solde double precision
                );