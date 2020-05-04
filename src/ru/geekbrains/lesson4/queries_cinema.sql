CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

CREATE TABLE `films` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `durability` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


CREATE TABLE `session` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `date` datetime NOT NULL,
   `price` int(11) DEFAULT '0',
   `film_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `date_UNIQUE` (`date`),
   KEY `film_fk_idx` (`film_id`),
   CONSTRAINT `film_fk`
     FOREIGN KEY (`film_id`)
     REFERENCES `films` (`id`));


CREATE TABLE `tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `session_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `session_fk_idx` (`session_id` ASC) VISIBLE,
  CONSTRAINT `session_fk`
    FOREIGN KEY (`session_id`)
    REFERENCES `cinema`.`session` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `cinema`.`films` (`name`, `durability`) VALUES ('Титаник', '120');
INSERT INTO `cinema`.`films` (`name`, `durability`) VALUES ('Криминальное чтиво', '90');
INSERT INTO `cinema`.`films` (`name`, `durability`) VALUES ('Холодное сердце', '60');
INSERT INTO `cinema`.`films` (`name`, `durability`) VALUES ('Унесенные ветром', '150');
INSERT INTO `cinema`.`films` (`name`, `durability`) VALUES ('Зеленая миля', '180');


INSERT INTO `cinema`.`session` (`date`, `price`, `film_id`) VALUES
('2020-05-01 09:00:00', '150', '3'),
('2020-05-02 09:00:00', '150', '3'),
('2020-05-03 09:00:00', '150', '3'),
('2020-05-04 09:00:00', '150', '3'),
('2020-05-05 09:00:00', '150', '3'),
('2020-05-06 09:00:00', '150', '3'),
('2020-05-07 09:00:00', '150', '3'),
('2020-05-08 09:00:00', '150', '3'),
('2020-05-09 09:00:00', '200', '3'),

('2020-05-01 15:00:00', '250', '3'),
('2020-05-02 15:00:00', '250', '3'),
('2020-05-03 15:00:00', '250', '3'),
('2020-05-04 15:00:00', '250', '3'),
('2020-05-05 15:00:00', '250', '3'),
('2020-05-06 15:00:00', '250', '3'),
('2020-05-07 15:00:00', '250', '3'),
('2020-05-08 15:00:00', '250', '3'),
('2020-05-09 15:00:00', '300', '3'),

('2020-05-01 11:00:00', '300', '1'),
('2020-05-02 11:00:00', '300', '1'),
('2020-05-03 11:00:00', '300', '1'),
('2020-05-04 11:00:00', '300', '1'),
('2020-05-05 11:00:00', '300', '1'),
('2020-05-06 11:00:00', '300', '1'),
('2020-05-07 11:00:00', '300', '1'),
('2020-05-08 11:00:00', '300', '1'),
('2020-05-09 11:00:00', '350', '1'),

('2020-05-01 17:00:00', '500', '1'),
('2020-05-02 17:00:00', '500', '1'),
('2020-05-03 17:00:00', '500', '1'),
('2020-05-04 17:00:00', '500', '1'),
('2020-05-05 17:00:00', '500', '1'),
('2020-05-06 17:00:00', '500', '1'),
('2020-05-07 17:00:00', '500', '1'),
('2020-05-08 17:00:00', '500', '1'),
('2020-05-09 17:00:00', '600', '1'),

('2020-05-01 18:00:00', '450', '4'),
('2020-05-02 18:00:00', '450', '4'),
('2020-05-03 18:00:00', '450', '4'),
('2020-05-04 18:00:00', '450', '4'),
('2020-05-05 18:00:00', '450', '4'),
('2020-05-06 18:00:00', '450', '4'),
('2020-05-07 18:00:00', '450', '4'),
('2020-05-08 18:00:00', '450', '4'),
('2020-05-09 18:00:00', '550', '4'),

('2020-05-01 13:00:00', '200', '4'),
('2020-05-02 13:00:00', '200', '4'),
('2020-05-03 13:00:00', '200', '4'),
('2020-05-04 13:00:00', '200', '4'),
('2020-05-05 13:00:00', '200', '4'),
('2020-05-06 13:00:00', '200', '4'),
('2020-05-07 13:00:00', '200', '4'),
('2020-05-08 13:00:00', '200', '4'),
('2020-05-09 13:00:00', '250', '4'),

('2020-05-01 21:00:00', '500', '2'),
('2020-05-02 21:00:00', '500', '2'),
('2020-05-03 21:00:00', '500', '2'),
('2020-05-04 21:00:00', '500', '2'),
('2020-05-05 21:00:00', '500', '2'),
('2020-05-06 21:00:00', '500', '2'),
('2020-05-07 21:00:00', '500', '2'),
('2020-05-08 21:00:00', '500', '2'),
('2020-05-09 21:00:00', '600', '2'),

('2020-05-01 22:00:00', '500', '5'),
('2020-05-02 22:00:00', '500', '5'),
('2020-05-03 22:00:00', '500', '5'),
('2020-05-04 22:00:00', '500', '5'),
('2020-05-05 22:00:00', '500', '5'),
('2020-05-06 22:00:00', '500', '5'),
('2020-05-07 22:00:00', '500', '5'),
('2020-05-08 22:00:00', '500', '5'),
('2020-05-09 22:00:00', '600', '5')
;

INSERT INTO `cinema`.`tickets` (`session_id`) VALUES
('1'),('1'),('1'),('1'),('1'),('1'),('1'),('1'),('1'),('1'),('1'),('1'),
('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),('2'),
('3'),('3'),('3'),('3'),('3'),
('4'),('4'),('4'),('4'),('4'),('4'),('4'),('4'),('4'),('4'),
('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),
('6'),('6'),('6'),('6'),('6'),('6'),
('7'),('7'),('7'),('7'),('7'),('7'),('7'),('7'),
('8'),('8'),('8'),('8'),
('9'),('9'),('9'),('9'),('9'),('9'),('9'),('9'),('9'),('9'),('9'),
('10'),('10'),('10'),('10'),('10'),('10'),('10'),('10'),('10'),('10'),('10'),
('11'),('11'),('11'),('11'),('11'),
('12'),('12'),('12'),('12'),('12'),('12'),
('13'),('13'),('13'),('13'),
('14'),('14'),('14'),('14'),('14'),('14'),('14'),
('15'),('15'),('15'),('15'),('15'),
('16'),('16'),('16'),('16'),('16'),('16'),('16'),('16'),('16'),('16'),('16'),('16'),
('17'),('17'),('17'),('17'),('17'),('17'),
('43'),('23'),('33'),('53'),('73'),
('54'),('44'),('44'),('44'),('44'),('44'),('44'),('4'),('43'),('42'),
('65'),('25'),('25'),('35'),('55'),('55'),('65'),('35'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),('5'),
('67'),('36'),('66'),('46'),('68'),('60'),
('70'),('72'),('73'),('71'),('72'),('47'),('57'),('67'),
('38'),('38'),('38'),('48');


--для удобства создадим view
create view cinema.view_total as (SELECT tab_films.id as film_id, tab_session.id as session_id,
tab_films.name, tab_session.date as date_begin, tab_films.durability,
tab_session.date + interval durability minute as date_end
 FROM cinema.session as tab_session
left join cinema.films as tab_films
on tab_session.film_id = tab_films.id);


--Ошибки в расписании
select tab_rez.name as film1, tab_rez.date_begin, tab_rez.durability,
tab_cinema.name as film2 ,tab_sess.date as date_begin2
 from cinema.view_total as tab_rez
 join cinema.session as tab_sess
on tab_sess.date >= tab_rez.date_begin and tab_sess.date < tab_rez.date_end
and tab_sess.id<>tab_rez.session_id
inner join cinema.films as tab_cinema
on tab_sess.film_id = tab_cinema.id
order by tab_rez.date_begin;


--перерывы 30 минут и более между фильмами
select tab.name as film1, tab.date_begin as date_begin1,
tab.durability, tab.date_begin2, tab.date_end,
timediff(tab.date_begin2,tab.date_end) as durability_break
from (SELECT tab1.session_id, tab1.name,tab1.date_begin,tab1.date_end,
tab1.durability, min(tab2.date_begin) as date_begin2 FROM cinema.view_total as tab1
inner join cinema.view_total tab2
on tab1.date_begin<tab2.date_begin
group by tab1.session_id) as tab
where tab.date_end+interval 30 minute<= tab.date_begin2
order by timediff(tab.date_begin2,tab.date_end) desc;


--список фильмов, для каждого — с указанием общего числа посетителей за все время,
--среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму
SELECT tab_f.name as film, sum(tab_s.price) as total_sum,
count(tab_t.id) as total_count_viewers,
tab_avg_viewers.avg_session_viewers FROM cinema.tickets as tab_t
inner join cinema.session as tab_s
on tab_s.id = tab_t.session_id
inner join cinema.films as tab_f
on tab_s.film_id = tab_f.id
inner join (select tab_session.film_id, avg(tab_total_viewers.count_viewers) as avg_session_viewers
from (select session_id, count(id) as count_viewers from
cinema.tickets
group by session_id) as tab_total_viewers
inner join cinema.session as tab_session
on tab_session.id = tab_total_viewers.session_id
group by tab_session.film_id) as tab_avg_viewers
on tab_avg_viewers.film_id = tab_f.id
group by name with rollup
order by total_sum desc;

-- число посетителей и кассовые сборы, сгруппированные по времени начала фильма
SELECT
case
when date_format(date,'%H:%i:%s')>='09:00:00' and date_format(date,'%H:%i:%s')<'15:00:00' then '09:00:00-14:59:59'
when date_format(date,'%H:%i:%s')>='15:00:00' and date_format(date,'%H:%i:%s')<'18:00:00' then '15:00:00-17:59:59'
when date_format(date,'%H:%i:%s')>='18:00:00' and date_format(date,'%H:%i:%s')<'21:00:00' then '18:00:00-20:59:59'
when date_format(date,'%H:%i:%s')>='21:00:00' and date_format(date,'%H:%i:%s')<='23:59:59' then '21:00:00-23:59:59'
 else 'время после полуночи' end as period,
 sum(price) as total_money,
count(cinema.tickets.id) as viewers FROM cinema.session
inner join cinema.tickets
on cinema.session.id = cinema.tickets.session_id
group by period
order by period;










