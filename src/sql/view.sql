create view view_sign_user as
	select
		sign.open_id as open_id,
		sign.sign_id as sign_id,
		sign.teach_time as teach_time,
		sign.teach_date as teach_date,
		sign.updatetime as updatetime,
		sign.teach_time_int as teach_time_int,
		user.avatar_url as avatar_url,
		user.nick_name as nick_name,
		user.nick_name_p as nick_name_p,
		user.type as type,
		user.grede as grede,
		user.class_type as class_type,
		user.class_name as class_name,
		user.stream_id as stream_id,
		user.motton as motton,
		user.rank_score as rank_score,
		user.class_content as class_content

		from sign join user on sign.open_id = user.open_id;


create view view_signstudent_user as
	select
		sign_student.sign_id as sign_id,
		sign_student.open_id as open_id,
		sign_student.status as status,
		sign_student.evaluate as evaluate,
		sign_student.updatetime as updatetime,
		user.avatar_url as avatar_url,
		user.nick_name as nick_name,
		user.type as type,
		user.grede as grede,
		user.stream_id as stream_id,
		user.motton as motton,
		user.rank_score as rank_score,
		user.class_content as class_content,
		user.class_type as class_type,
		user.class_name as class_name,
		user.nick_name_p as nick_name_p

		from sign_student join user on sign_student.open_id = user.open_id;




CREATE VIEW view_all as
  select
    view_sign_user.sign_id as sign_id,
    view_sign_user.open_id as t_open_id,
    view_sign_user.teach_time as t_teach_time,
		view_sign_user.teach_date as t_teach_date,
		view_sign_user.updatetime as t_updatetime,
		IFNULL(view_sign_user.teach_time_int,0) as t_teach_time_int,
		view_sign_user.avatar_url as t_avatar_url,
		view_sign_user.nick_name as t_nick_name,
		view_sign_user.nick_name_p as t_nick_name_p,
		view_sign_user.type as t_type,
		view_sign_user.grede as t_grede,
		view_sign_user.class_type as t_class_type,
		view_sign_user.class_name as t_class_name,
		view_sign_user.stream_id as t_stream_id,
		view_sign_user.motton as t_motton,
		view_sign_user.rank_score as t_rank_score,
		view_sign_user.class_content as t_class_content,
		view_signstudent_user.open_id as s_open_id,
		view_signstudent_user.status as s_status,
		view_signstudent_user.evaluate as s_evaluate,
		view_signstudent_user.updatetime as s_updatetime,
		view_signstudent_user.avatar_url as s_avatar_url,
		view_signstudent_user.nick_name as s_nick_name,
		IFNULL(view_signstudent_user.type,-1) as s_type,
		IFNULL(view_signstudent_user.grede,0) as s_grede,
		view_signstudent_user.stream_id as s_stream_id,
		view_signstudent_user.motton as s_motton,
		view_signstudent_user.rank_score as s_rank_score,
		view_signstudent_user.class_content as s_class_content,
		view_signstudent_user.class_type as s_class_type,
		view_signstudent_user.class_name as s_class_name,
		view_signstudent_user.nick_name_p as s_nick_name_p
   from view_sign_user left join view_signstudent_user ON view_sign_user.sign_id = view_signstudent_user.sign_id and view_signstudent_user.open_id !=view_sign_user.open_id;


CREATE view view_t_sign_count as
  select
    t_open_id as open_id,
    t_avatar_url as t_avatar_url,
    t_nick_name as t_nick_name,
    t_nick_name_p as t_nick_name_p,
    t_teach_time as t_teach_time,
    t_teach_date as t_teach_date,
    count(*) as sign_times,
    sum(t_teach_time_int) as sign_long,
    t_updatetime as t_updatetime,
		t_class_type as t_class_type,
		t_class_name as t_class_name
  from view_all group by t_open_id;

CREATE view view_t_sign_ack_count as select
  t_open_id as t_open_id,
  s_type as s_type,
  t_teach_time as t_teach_time,
  t_teach_date as t_teach_date,
  count(t_open_id) as times
  from view_all where t_open_id != s_open_id AND s_open_id is not null GROUP BY t_open_id;

CREATE view view_t_count as select
    view_t_sign_count.open_id as open_id,
    view_t_sign_count.t_nick_name as t_nick_name,
    view_t_sign_count.t_nick_name_p as t_nick_name_p,
    view_t_sign_count.sign_times as sign_times,
		IFNULL(view_t_sign_count.sign_long,0) as sign_long,
    view_t_sign_count.t_avatar_url as t_avatar_url,
    view_t_sign_count.t_updatetime as updatetime,
		view_t_sign_count.t_class_type as t_class_type,
		view_t_sign_count.t_class_name as t_class_name,
		IFNULL(view_t_sign_ack_count.times,0) as ack_times,
    view_t_sign_count.t_teach_date as sign_t_teach_date,
    view_t_sign_ack_count.t_teach_date as ack_t_teach_date
 from view_t_sign_count LEFT JOIN view_t_sign_ack_count on view_t_sign_count.open_id = view_t_sign_ack_count.t_open_id;


CREATE VIEW view_s_sign_count as
  select
    s_open_id as s_open_id,
    s_nick_name as s_nick_name,
    s_nick_name_p as s_nick_name_p,
    s_avatar_url as s_avatar_url,
		s_class_type as s_class_type,
		s_class_name as s_class_name,
		t_teach_date as t_teach_date,
    t_open_id as t_open_id,
		s_updatetime as updatetime,
    sum(t_teach_time_int) as s_sign_long,
    count(*) as sign_times
   from view_all  WHERE s_open_id is NOT null  GROUP BY s_open_id HAVING s_sign_long is NOT null;
