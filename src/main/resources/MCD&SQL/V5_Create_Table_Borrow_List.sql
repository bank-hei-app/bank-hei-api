                CREATE TABLE borrow_list(
                            borrow_list_id serial primary key ,
                            account_id serial references account(account_id),
                            borrow_id serial references borrow(borrow_id)
                );