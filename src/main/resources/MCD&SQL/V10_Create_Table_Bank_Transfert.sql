                    CREATE TABLE Bank_transfert(
                               bank_transfert_id int primary key ,
                               amount double precision,
                               balance_category_id int references Balance_category(balance_category_id),
                               balance_type_id int references Balance_type(balance_type_id),
                               date_make_effect timestamp,
                               date_register timestamp,
                               reference_unique varchar(50)
                    );