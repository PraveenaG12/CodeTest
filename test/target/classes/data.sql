drop table if exists palindrometrack;
create table palindrometrack(
id int AUTO_INCREMENT primary key,
input varchar(1000) NOT NULL,
longestpalindrome varchar(1000) NOT NULL
);