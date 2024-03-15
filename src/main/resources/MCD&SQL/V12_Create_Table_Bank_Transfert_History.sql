







          CREATE TABLE bank_transfert_list(
              bank_transfert_list_id int primary key ,
              bank_transfert_id int references Bank_transfert(bank_transfert_id),
              account_sender_id int references Account(account_id),
              account_recipients_id int references Account(account_id)
          );
