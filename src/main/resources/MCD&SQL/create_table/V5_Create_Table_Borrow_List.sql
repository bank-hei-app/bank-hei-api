CREATE TABLE IF NOT EXISTS borrow_list(
     borrow_list_id serial PRIMARY KEY,
     account_id serial REFERENCES account(account_id),
     borrow_id serial REFERENCES borrow(borrow_id)
    );
