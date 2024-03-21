                CREATE TABLE borrow_list(
                            borrow_list_id int primary key ,
                            account_id int references account(account_id),
                            borrow_id int references borrow(borrow_id)
                );