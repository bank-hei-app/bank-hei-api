CREATE TABLE IF NOT EXISTS transactions(
    transaction_id serial PRIMARY KEY,
    account_id serial REFERENCES account(account_id),
    date_of_transaction TIMESTAMP,
    amount double precision,
    balance_type_id int REFERENCES balance_type(balance_type_id),
    balance_category_id serial REFERENCES balance_category(balance_category_id)
    );
