CREATE ROLE bank_hei WITH LOGIN PASSWORD 'bankhei';
ALTER ROLE bank_hei CREATEDB;
CREATE DATABASE if not exists bankheiapi;
psql -h locqlhost -U bank_hei -d bankheiapi;

          CREATE TABLE Bank(
              bank_id int primary key ,
              bank_name varchar(100)
          );
          CREATE TABLE Account(
              account_id int primary key ,
              client_name varchar(200),
              client_last_name varchar(200),
              date_of_birth date,
              net_salary_per_month double precision,
              account_number varchar (50),
              bank_id int references Bank(bank_id),
              default_solde double precision
          );
          CREATE TABLE Borrow(
              borrow_id int primary key ,
              amount double precision,
              percent decimal,
              date_of_borrow date
          );
          CREATE TABLE Borrow_list(
              borrow_list_id int primary key ,
              account_id int references Account(account_id),
              borrow_id int references Borrow(borrow_id)
          );
          CREATE TABLE Balance_type(
              balance_type_id int primary key ,
              balance_type_name varchar(200)
          );
          CREATE TABLE Balance_category(
              balance_category_id int primary key ,
              balance_category_name varchar(200),
              description text
          );
          CREATE TABLE Withdrawal(
              withdrawal_id int primary key ,
              account_id int references Account(account_id),
              date_of_withdrawal TIMESTAMP,
              amount double precision,
              balance_type_id int references Balance_type(balance_type_id),
              balance_category_id int references Balance_category(balance_category_id)
          );
          CREATE TABLE Deposit(
              deposit_id int primary key ,
              account_id int references Account(account_id),
              date_of_retrait TIMESTAMP,
              amount double precision,
              balance_type_id int references Balance_type(balance_type_id),
              balance_category_id int references Balance_category(balance_category_id)
          );
          CREATE TABLE Bank_transfert(
              bank_transfert_id int primary key ,
              amount double precision,
              balance_category_id int references Balance_category(balance_category_id),
              balance_type_id int references Balance_type(balance_type_id),
              date_make_effect timestamp,
              date_register timestamp,
              reference_unique varchar(50)
          );
          CREATE TABLE bank_transfert_list(
              bank_transfert_list_id int primary key ,
              bank_transfert_id int references Bank_transfert(bank_transfert_id),
              account_sender_id int references Account(account_id),
              account_recipients_id int references Account(account_id)
          );
