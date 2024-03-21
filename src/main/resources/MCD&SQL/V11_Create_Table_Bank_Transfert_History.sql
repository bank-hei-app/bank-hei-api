CREATE TABLE bank_transfer_history(
    bank_transfer_history serial primary key ,
    bank_transfer serial references bank_transfer(bank_transfer_id)
);


