CREATE TABLE IF NOT EXISTS bank_transfer_history(
      bank_transfer_history_id serial PRIMARY KEY,
      bank_transfer_id serial REFERENCES bank_transfer(bank_transfer_id)
    );
