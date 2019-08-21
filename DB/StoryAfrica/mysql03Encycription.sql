-- 암호화 함수 
select * from memberinfo;

-- 암호화 함수
select 
	-- password(upw) as password, 
    userpw,
    sha(userpw) as sha,
    sha1(userpw) as sha1, 
    sha2(userpw, 256) as sha2, 
    md5(userpw) as md5,
    HEX(AES_ENCRYPT(userpw, 'password')) as AES_ENCRYPT1 ,
    AES_ENCRYPT(userpw, SHA2('password', 256)) as AES_ENCRYPT2

from memberinfo limit 0,1;

select * from memberinfo;
-- 암호화 
update memberinfo set userpw=HEX(AES_ENCRYPT('1111', 'password')) where idx = 4;

-- 복호화 - 'password':  키값
select CONVERT(AES_DECRYPT(UNHEX(userpw), 'password') using utf8) from memberinfo where idx=4; 
-- blob 형태로 표시됨 
select AES_DECRYPT(UNHEX(userpw), 'password') from memberinfo where idx=4;

-- 암호화
update project.member set upw=HEX(AES_ENCRYPT('1111', SHA2('password', 256))) where idx = 29;
-- 복호화
select CONVERT(AES_DECRYPT(UNHEX(upw),  SHA2('password', 256)) using utf8) from project.member where idx=29;
select AES_DECRYPT(UNHEX(upw),  SHA2('password', 256)) from project.member where idx=29;