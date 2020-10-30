insert into user values(101, sysdate(), 'David');
insert into user values(102, sysdate(), 'Noah');
insert into user values(103, sysdate(), 'Jiyeon');
insert into user values(104, sysdate(), 'Yoomin');
insert into user values(105, sysdate(), 'Frank');

insert into post values(1001, 'Hello nice to meet you', 102, sysdate(), 101);
insert into post values(1002, 'Who are you', 104, sysdate(), 101);
insert into post values(1003, 'Guten Tag', 105, sysdate(), 101);

insert into post values(1004, 'Ich Stelle eine Frage', 104, sysdate(), 103);
insert into post values(1005, 'Mach mal auf Deutsch', 101, sysdate(), 103);
insert into post values(1006, 'Leck mich', 102, sysdate(), 103);
insert into post values(1007, 'Du bist nakt', 105, sysdate(), 103);