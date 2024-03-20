                CREATE TABLE borrow(
                       borrow_id serial primary key ,
                       amount double precision,
                       percent decimal,
                       date_of_borrow date
                );