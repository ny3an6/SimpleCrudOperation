insert into dino_user (first_name, second_name, date_of_birth, address) values ('Nikita', 'Renko', '1992-02-13','Moscow') on conflict (second_name) do nothing;
insert into dino_user (first_name, second_name, date_of_birth, address) values ('Alex', 'Ivanov','2000-06-25','Saint-Petersburg') on conflict (second_name) do nothing;
