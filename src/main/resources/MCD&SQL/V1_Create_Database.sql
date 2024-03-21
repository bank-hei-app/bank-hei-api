CREATE ROLE bank_hei WITH LOGIN PASSWORD 'bankhei';
ALTER ROLE bank_hei CREATEDB;
CREATE DATABASE if not exists bankheiapi;
psql -h localhost -U bank_hei -d bankheiapi;
