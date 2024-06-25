create table tank (
                      id int not null AUTO_INCREMENT,
                      name varchar(512) unique not null,
                      mass_in_tonnes float,
                      gun_caliber_in_millimeters int,
                      front_armour_in_millimeters int,
                      country_of_origin varchar(512),
                      type varchar(512),
                      primary key (id)
);