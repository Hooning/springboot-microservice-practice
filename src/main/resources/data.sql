insert into user values(101, TO_DATE('1986-12-19', 'YYYY-MM-DD'), 'David');
insert into user values(102, TO_DATE('2019-12-18', 'YYYY-MM-DD'), 'Noah');
insert into user values(103, TO_DATE('1982-08-19', 'YYYY-MM-DD'), 'Jiyeon');
insert into user values(104, TO_DATE('2013-12-24', 'YYYY-MM-DD'), 'Yoomin');
insert into user values(105, TO_DATE('1981-01-05', 'YYYY-MM-DD'), 'Michael');
insert into user values(106, TO_DATE('1988-05-08', 'YYYY-MM-DD'), 'Tom');
insert into user values(107, TO_DATE('1991-02-28', 'YYYY-MM-DD'), 'John');
insert into user values(108, TO_DATE('2011-03-14', 'YYYY-MM-DD'), 'Jens');
insert into user values(109, TO_DATE('1947-11-11', 'YYYY-MM-DD'), 'Oscar');
insert into user values(110, TO_DATE('1977-08-21', 'YYYY-MM-DD'), 'Sandro');

-- post_id, content, posted_by_id, posted_on, user_id
insert into post values(1001, 'Hello nice to meet you', 102, sysdate(), 101);
insert into post values(1002, 'Who are you', 104, sysdate()-13, 101);
insert into post values(1003, 'Guten Tag', 105, sysdate()-531, 101);
insert into post values(1004, 'Do you have time this weekend?', 110, sysdate()-14, 101);

insert into post values(1005, 'Ich Stelle eine Frage', 104, sysdate()-33, 103);
insert into post values(1006, 'Mach mal auf Deutsch', 101, sysdate()-77, 103);
insert into post values(1007, 'Leck mich am Arsch', 102, sysdate()-12, 103);
insert into post values(1008, 'Du bist nakt', 105, sysdate()-3, 103);

insert into post values(1009, 'Congratulations my friend', 104, sysdate()-33, 105);
insert into post values(1010, 'Happy birthday Michael', 101, sysdate()-77, 105);
insert into post values(1011, 'How are you doing JJ?', 102, sysdate()-12, 103);

insert into post values(1012, 'Happy', 110, sysdate()-8, 107);
insert into post values(1013, 'Birthday', 103, sysdate()-7, 107);
insert into post values(1014, 'to', 107, sysdate()-6, 107);
insert into post values(1015, 'you', 102, sysdate()-5, 107);
insert into post values(1016, 'Happy Birthday', 106, sysdate()-4, 107);
insert into post values(1017, 'to you', 109, sysdate()-3, 107);

insert into post values(1018, 'Ich habe ein Kopfschmerzen', 102, sysdate()-12, 103);
insert into post values(1019, 'I am so lonely~', 106, sysdate()-11, 103);
