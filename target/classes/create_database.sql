create database if not exists rpg;
use rpg;
create table if not exists raca(
	id int not null AUTO_INCREMENT Primary Key,
    nome varchar(255) ,
    bonus_vida int,
    bonus_escudo int ,
    bonus_poderfisico int ,
    bonus_poderhabilidade int
);

create table if not exists arquetipo(
	id int not null AUTO_INCREMENT Primary Key,
    nome varchar(255) ,
    bonus_vida int,
    bonus_escudo int ,
    bonus_poderfisico int ,
    bonus_poderhabilidade int
);

create table if not exists personagem(
	id int not null AUTO_INCREMENT Primary key,
	nome Varchar(255),
	bonus_vida int,
    bonus_escudo int ,
    bonus_poderfisico int ,
    bonus_poderhabilidade int,
    raca_id int,
    arquetipo_id int,
    Foreign key (raca_id) references raca(id),
    Foreign Key (arquetipo_id) references arquetipo(id)
);

create table if not exists lutador(
    id int not null AUTO_INCREMENT Primary key,
    personagem_id int,
    Foreign key (personagem_id) references personagem(id)
);

create table if not exists batalha(
    id int not null AUTO_INCREMENT Primary key,
    lutador1_id int,
    lutador2_id int,
    vencedor_id int,
    Foreign key (lutador1_id) references lutador(id),
    Foreign key (lutador2_id) references lutador(id),
    Foreign key (vencedor_id) references lutador(id)
);