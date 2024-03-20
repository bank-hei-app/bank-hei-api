CREATE TABLE bank_transfer_history(
    bank_transfer_history int primary key ,
    bank_transfer int references bank_transfer(bank_transfer_id)
);


