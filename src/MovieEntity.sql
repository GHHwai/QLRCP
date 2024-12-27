create database Movie;

use Movie;

-- tao bang customer
create table Customer(
IDCustomer				int auto_increment,
CustomerName			nvarchar(100) not null,
CustomerPhoneNumber		varchar(15) check (CustomerPhoneNumber regexp '^[0-9]{10,15}$'),
CustomerType			enum('Nguoi lon', 'Tre em') Default ('Nguoi lon'),
constraint pk_User	primary key(IDCustomer)
);

-- tao bang Staff
create table Staff (
IDStaff					int auto_increment,
Staff_Name				nvarchar(100) not null,
Staff_Mail				nvarchar(100) not null,
constraint pk_Staff	primary key (IDStaff)
);


-- tao bang Movie 
create table Movie (
IDMovie					int auto_increment,
Title					nvarchar(255) not null,
Genre					nvarchar(255) not null,
Duration				int not null check (Duration > 0),
Director				nvarchar(255) not null,
release_date			date,
Moviedescrip			text not null,
create_at timestamp default CURRENT_TIMESTAMP,
update_at timestamp default current_timestamp on update current_timestamp,
constraint pk_Movie primary key (IDMovie)
);
 

-- tao bang Room
create table Room (
IDRoom				int auto_increment,
RoomName			nvarchar(100) not null,
capacity			int not null,	-- Suc chua cua phong
Status 				enum('Con trong', 'Het cho') default 'Con trong',
create_at timestamp default CURRENT_TIMESTAMP,
update_at timestamp default current_timestamp on update current_timestamp,
constraint pk_Room primary key (IDRoom)
);


-- tao bang Schedule (Lich phim)
create table Schedule (
IDSchedule				int AUTO_INCREMENT,
IDMovie					int not null,
IDRoom					int not null,
Showdate				date not null,
Showtime				time not null,
Price					Decimal(10,2) not null,
Status 					enum('Dang Chieu', 'Ngung Chieu') default 'Dang Chieu',
create_at timestamp default CURRENT_TIMESTAMP,
update_at timestamp default current_timestamp on update current_timestamp,
constraint pk_Schedule primary key (IDSchedule)
);


create table Ticket (
IDTicket			int auto_increment,
IDSchedule			int not null,
IDSeat				int not null,
TicketStatus		enum('Da Dat', 'Bi Huy', 'Chua Thanh Toan') default 'Chua Thanh Toan',
Price				decimal(10, 2) not null,
IDCustomer 			int not null,
IDStaff 			int not null,
constraint pk_Ticket primary key (IDTicket)
);

create table Seat (
IDSeat     		 int auto_increment,
IDRoom     		 int not null,
SeatRow    		 char(1) not null, -- Hàng ghế (A, B, C, ...)
SeatNumber 		 int not null,     -- Số ghế trong hàng
Status      	 enum('Available', 'Booked', 'Broken') default 'Available',
create_at  		 timestamp default CURRENT_TIMESTAMP,
update_at 		 timestamp default current_timestamp on update current_timestamp,
constraint pk_Seat primary key (IDSeat)
);
