use Movie;


-- khoa ngoai cua table Schedule
alter table Schedule add constraint fk_Schedule_Room foreign key(IDRoom) references Room(IDRoom) on delete cascade on update cascade;
alter table Schedule add constraint fk_Schedule_Movie foreign key(IDMovie) references Movie(IDMovie) on delete cascade on update cascade;

-- khoa ngoai cua table Ticket
alter table Ticket add constraint fk_Schedule_Ticket foreign key (IDSchedule) references Schedule(IDSchedule) on delete cascade on update cascade;
alter table Ticket add constraint fk_Seat_Ticket foreign key (IDSeat) references Seat(IDSeat) on delete cascade on update cascade;
alter table Ticket add constraint fk_Custom_Ticket foreign key (IDCustomer) references Customer(IDCustomer) on delete cascade;
alter table Ticket add constraint fk_Staff_Ticket foreign key (IDStaff) references Staff(IDStaff) on delete cascade on update cascade;

-- khoa ngoai cua table Seat
alter table Seat add constraint fk_Room_Seat foreign key (IDRoom) references Room(IDRoom) on delete cascade on update cascade;

-- insert du lieu mau cho table Customer
insert into Customer(CustomerName, CustomerPhoneNumber, CustomerType) values ('Duong', '0905040302', 'Nguoi Lon'), ('Hai', '0847576756', 'Tre em');
 select * from Customer;
 
 -- insert du lieu mau cho table Staff
insert into Staff(Staff_Name, Staff_Mail) values ('Duy', 'Duy123432@gmail.com' ), ('Khanh','Khanh98@gmail.com');


