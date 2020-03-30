insert  into person(`id`, `name`, `age`, `blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`,`job`) values (1, 'koo', 10,'A',1991,8,1,'programmer');
insert  into person(`id`, `name`, `age`, `blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values (2, 'koo1', 20,'B',1988,8,18);
insert  into person(`id`, `name`, `age`, `blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values (3, 'koo2', 30,'O',1996,5,16);
insert  into person(`id`, `name`, `age`, `blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values (4, 'koo3', 40,'AB',1997,6,2);
insert  into person(`id`, `name`, `age`, `blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values (5, 'koo4', 50,'A',1996,3,25);

insert  into block(`id` , `name`) values (1, 'koo');
insert  into block(`id` , `name`) values (2, 'koo1');

update person set block_id = 1  where id = 1;
update person set block_id = 2  where id = 2;