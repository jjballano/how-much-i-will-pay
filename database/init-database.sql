create table IF NOT EXISTS region (
   key varchar(50) PRIMARY KEY
);

create table IF NOT EXISTS irpf (
   year smallint,
   region_id varchar(50),
   values json,
   PRIMARY KEY (year, region_id),
   FOREIGN KEY (region_id) REFERENCES region (key)
);

INSERT INTO region (key) VALUES ('spain') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('andalucia') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('aragon') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('asturias') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('baleares') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('canarias') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('cantabria') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('castillaLaMancha') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('castillaLeon') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('catalunya') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('extremadura') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('galicia') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('madrid') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('murcia') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('rioja') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('valencia') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('ceuta') ON CONFLICT (key) DO NOTHING;
INSERT INTO region (key) VALUES ('melilla') ON CONFLICT (key) DO NOTHING;

insert into irpf (year, region_id, values) values (2018, 'spain', '{"12450":9.5,"20200": 12,"35200": 15,"60000": 18.5,"1000000": 22.5}');
insert into irpf (year, region_id, values) values (2018, 'andalucia', '{"12450":10,"20200": 12,"28000": 15,"35200": 16.5,"50000": 19,"60000": 19.5,"120000": 23.5,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'aragon', '{"12450": 10,"20200": 12.5,"34000": 15.5,"50000": 19,"60000": 21,"70000": 22,"90000": 22.5,"130000": 23.5,"150000": 24.5,"1000000": 25
}');
insert into irpf (year, region_id, values) values (2018, 'asturias', '{"12450": 10,"17707.20": 12,"33007.20": 14,"53407.20": 18.5,"700000": 21.5,"900000": 22.5,"175000": 25,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'baleares', '{"10000": 9.5,"18000": 11.75,"30000": 14.75,"48000": 17.75,"70000": 19.25,"90000": 22,"120000": 23,"175000": 24,"1000000": 25}');
insert into irpf (year, region_id, values) values (2018, 'canarias', '{"12450": 9.5,"17707.21": 12,"33007.21": 14,"53407.21": 18.5,"90000.01": 23.5,"1000000": 24}');
insert into irpf (year, region_id, values) values (2018, 'cantabria', '{"12450": 9.5,"20200": 12,"34000": 15,"46000": 18.5,"60000": 19.5,"90000": 24.5,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'castillaLaMancha', '{"12450": 9.5,"20200": 12,"35200": 15,"60000": 18.5,"1000000": 22.5}');
insert into irpf (year, region_id, values) values (2018, 'castillaLeon', '{"12450": 9.5,"20200": 12,"35200": 14,"53407.20": 18.5,"1000000": 21.5}');
insert into irpf (year, region_id, values) values (2018, 'catalunya', '{"17707.20": 12,"33007.20": 14,"53407.20": 18.5,"120000.20": 21.5,"175000.20": 23.5,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'galicia', '{"12450": 9.5,"20200": 11.75,"27700": 15.5,"35200": 17,"47600": 18.5,"60000": 20.5,"1000000": 22.5}');
insert into irpf (year, region_id, values) values (2018, 'extremadura', '{"12450": 10.5,"20200": 12.5,"24200": 15.5,"35200": 16.5,"60000": 20.5,"80200": 23.5,"99200": 24,"120000": 24.5,"1000000": 25}');
insert into irpf (year, region_id, values) values (2018, 'madrid', '{"12450": 9.5,"17707.20": 11.2,"33007.20": 13.3,"53407.20": 17.9,"1000000": 21}');
insert into irpf (year, region_id, values) values (2018, 'murcia', '{"12450": 10,"20200": 12.5,"34000": 15.5,"60000": 19.5,"1000000": 23.5}');
insert into irpf (year, region_id, values) values (2018, 'rioja', '{"12450": 9.5,"20200": 12,"35200": 15,"50000": 19,"60000": 19.5,"120000": 23.5,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'valencia', '{"12450": 10,"17000": 11,"30000": 13.9,"50000": 18,"65000": 23.5,"80000": 24.5,"120000": 25,"1000000": 25.5}');
insert into irpf (year, region_id, values) values (2018, 'ceuta', '{"12450": 9.5,"20200": 12,"34000": 15,"60000": 18.5,"1000000": 22.5}');
insert into irpf (year, region_id, values) values (2018, 'melilla', '{"12450": 9.5,"20200": 12,"34000": 15,"60000": 18.5,"1000000": 22.5}');
