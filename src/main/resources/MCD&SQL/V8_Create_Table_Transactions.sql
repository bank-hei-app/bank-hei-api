                CREATE TABLE transactions(
                           transaction_id serial primary key ,
                           account_id serial references account(account_id),
                           date_of_transaction TIMESTAMP,
                           amount double precision,
                           balance_type_id int references balance_type(balance_type_id),
                           balance_category_id serial references balance_category(balance_category_id)
                );