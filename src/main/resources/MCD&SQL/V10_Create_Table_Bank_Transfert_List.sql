                    CREATE TABLE bank_transfer_list(
                                    bank_transfer_list_id serial primary key ,
                                    bank_transfer_id serial references bank_transfer(bank_transfer_id),
                                    account_sender_id serial references account(account_id),
                                    account_recipients_id serial references account(account_id)
                    );