CREATE TABLE BookingTable (
                              id int not null AUTO_INCREMENT,
                              customer_name varchar(100) not null,
                              telephone_number varchar(10) not null,
                              booking_date varchar(100) not null,
                              check_in varchar(10) not null,
                              check_out varchar(10) not null,
                              total_person integer(10) not null,
                              PRIMARY KEY (id)
);

# CREATE TABLE BookingTable (
#                               id int not null AUTO_INCREMENT,
#                               customer_name varchar(100) not null,
#                               telephone_number varchar(10) not null,
#                               booking_date date not null,
#                               check_in varchar(10) not null,
#                               check_out varchar(10) not null,
#                               total_person integer(10) not null,
#                               PRIMARY KEY (id)
# );