                CREATE TABLE Borrow_list(
                            borrow_list_id int primary key ,
                            account_id int references Account(account_id),
                            borrow_id int references Borrow(borrow_id)
                );