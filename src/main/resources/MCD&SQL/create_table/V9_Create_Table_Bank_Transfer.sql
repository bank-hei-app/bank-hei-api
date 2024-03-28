CREATE TABLE IF NOT EXISTS bank_transfer(
    bank_transfer_id serial PRIMARY KEY,
    amount double precision,
    balance_category_id serial REFERENCES balance_category(balance_category_id),
    balance_type_id int REFERENCES balance_type(balance_type_id),
    date_make_effect TIMESTAMP,
    date_register TIMESTAMP,
    reference_unique varchar(50)
    );
