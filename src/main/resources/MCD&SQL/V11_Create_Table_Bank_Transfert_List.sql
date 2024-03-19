                    CREATE TABLE bank_transfer_list(
                                    bank_transfer_list_id int primary key ,
                                    bank_transfer_id int references bank_transfer(bank_transfer_id),
                                    account_sender_id int references account(account_id),
                                    account_recipients_id int references account(account_id)
                    );