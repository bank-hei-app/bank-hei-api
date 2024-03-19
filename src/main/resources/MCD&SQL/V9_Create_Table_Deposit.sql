                CREATE TABLE deposit(
                        deposit_id int primary key ,
                        account_id int references account(account_id),
                        date_of_deposit TIMESTAMP,
                        amount double precision,
                        balance_type_id int references balance_type(balance_type_id),
                        balance_category_id int references balance_category(balance_category_id)
                );