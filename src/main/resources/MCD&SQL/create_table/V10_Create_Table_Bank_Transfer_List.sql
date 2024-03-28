CREATE TABLE IF NOT EXISTS bank_transfer_list(
    bank_transfer_list_id serial PRIMARY KEY,
    bank_transfer_id serial REFERENCES bank_transfer(bank_transfer_id),
    account_sender_id serial REFERENCES account(account_id),
    account_recipients_id serial REFERENCES account(account_id)
    );
