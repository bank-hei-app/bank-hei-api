                    CREATE TABLE bank_transfer(
                               bank_transfer_id serial primary key ,
                               amount double precision,
                               balance_category_id serial references balance_category(balance_category_id),
                               balance_type_id int references balance_type(balance_type_id),
                               date_make_effect timestamp,
                               date_register timestamp,
                               reference_unique varchar(50)
                    );