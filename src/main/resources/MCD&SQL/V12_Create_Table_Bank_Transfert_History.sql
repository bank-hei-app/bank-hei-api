CREATE TABLE Bank_transfert_history(
    bank_transfert_history int primary key ,
    bank_transfert int references Bank_transfert(bank_transfert_id)
);


