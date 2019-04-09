# StrategyPatternTP1

### Pre-requisites:
##### Database:
* If you want can use Docker to run a image with the standard ER of the exam, you must run this command

> docker run --name strategy -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d fgallo94/strategy-mysql:stable

* Or run this script in your MySQL:
```sql
create database strategy;

use strategy;

create table ResultBattle(
    id integer not null auto_increment,
    name_of_winner varchar(100) not null,
    drink_in_body integer not null,
    PRIMARY key(id)
);
```
