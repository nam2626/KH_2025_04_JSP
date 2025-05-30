INSERT INTO BOARD_MEMBER 
VALUES('admin',STANDARD_HASH('123456','SHA512'),'관리자','방장');

select * from board_member 
where id like 'admin' and passwd like standard_hash('123456','SHA512');