CREATE TABLE IF NOT EXISTS borrow(
      borrow_id serial PRIMARY KEY,
      amount double precision,
      percent decimal,
      date_of_borrow date
);
