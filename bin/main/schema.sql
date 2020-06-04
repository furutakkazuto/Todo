create table if not exists furuta_todo(
	id bigint unsigned auto_increment not null comment "ID",
	title varchar(30) unique not null comment "タイトル",
	deadline date not null comment "期日",
	status boolean not null default 0 comment "ステータス",
	create_time datetime not null default current_timestamp comment "作成時間",
	update_time datetime not null default current_timestamp on update current_timestamp comment "更新時間",
	primary key(id))
default charset=utf8mb4
engine = innodb
comment = "todoテーブル";

create table if not exists seq_ai(
	id int not null auto_increment primary key,
	create_time datetime not null
)
engine = innodb