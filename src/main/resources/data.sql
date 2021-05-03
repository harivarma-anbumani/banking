
--comment " customer table to manage list of Account Holders in a Bank"
insert into customer (id, name, balance ) values (1, 'Mark', 1000 );
insert into customer (id, name, balance ) values (2, 'Rob', 1500 );
insert into customer (id, name, balance ) values (3, 'Jim', 2100 );
insert into customer (id, name, balance ) values (4, 'William', 3500 );

--comment " Beneficiary table to manage list of beneficiaries "
insert into beneficiary (id, name) values (1,  'Phil' );
insert into beneficiary (id, name) values (2,  'Tim' );
insert into beneficiary (id, name) values (3,  'Scott' );
insert into beneficiary (id, name) values (4,  'John' );

--comment " transfer table to manage list of transfers"
insert into transfer (id, customer_id, beneficiary_id, amount ) values (1, 1, 1,  10.50 );
insert into transfer (id, customer_id, beneficiary_id, amount ) values (2, 2, 2,  20.60 );
insert into transfer (id, customer_id, beneficiary_id, amount ) values (3, 3, 3,  30.70 );
insert into transfer (id, customer_id, beneficiary_id, amount ) values (4, 4, 4,  40.80 );
