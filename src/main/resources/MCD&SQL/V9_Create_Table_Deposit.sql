                CREATE TABLE Deposit(
                        deposit_id int primary key ,
                        account_id int references Account(account_id),
                        date_of_deposit TIMESTAMP,
                        amount double precision,
                        balance_type_id int references Balance_type(balance_type_id),
                        balance_category_id int references Balance_category(balance_category_id)
                );