insert into SUB_MASTER(SUB_ID, SUB_NAME, EMAIL_ID) values (1001, 'Feri', 'feri@email.com');
insert into SUB_MASTER(SUB_ID, SUB_NAME, EMAIL_ID) values (1002, 'Pisti', 'pisti@email.com');
insert into SUB_MASTER(SUB_ID, SUB_NAME, EMAIL_ID) values (1003, 'xyz', 'xyz@email.com');
insert into SUB_MASTER(SUB_ID, SUB_NAME, EMAIL_ID) values (1004, 'NoLife', 'nolife@email.com');

insert into STREAM_MASTER(STREAM_ID, STREAM_NAME, PRICE, SUB_ID) values (101, 'Netflix', '2500', 1001);
insert into STREAM_MASTER(STREAM_ID, STREAM_NAME, PRICE, SUB_ID) values (102, 'Hulu', '1500', 1002);
insert into STREAM_MASTER(STREAM_ID, STREAM_NAME, PRICE, SUB_ID) values (103, 'Amazon', '3500', 1003);
insert into STREAM_MASTER(STREAM_ID, STREAM_NAME, PRICE, SUB_ID) values (104, 'Disney', '2000', 1004);
insert into STREAM_MASTER(STREAM_ID, STREAM_NAME, PRICE, SUB_ID) values (105, 'HBO', '1234', 1004);