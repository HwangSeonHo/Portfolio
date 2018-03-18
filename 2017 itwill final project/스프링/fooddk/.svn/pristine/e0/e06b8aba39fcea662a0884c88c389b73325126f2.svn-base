/** Å×ÀÌºí µå¶øÇÏ±â **/

DROP TABLE Hoogi cascade constraint;
DROP TABLE Datgle cascade constraint;
DROP TABLE Score cascade constraint;
DROP TABLE Tasty cascade constraint;
DROP TABLE Recipe cascade constraint;
DROP TABLE Member cascade constraint;
DROP TABLE Category cascade constraint;
DROP TABLE Grade cascade constraint;
drop table item cascade constraint;
drop table jumon cascade constraint;
drop table porce cascade constraint;

/**sequence µå¶øÇÏ±â **/
drop sequence c_no_seq;
drop sequence d_no_seq;
drop sequence g_no_seq;
drop sequence m_no_seq;
drop sequence r_no_seq;



/**********************************/
/* Table Name: Grade */
/**********************************/
CREATE TABLE Grade(
		g_no NUMBER(10) PRIMARY KEY,
		g_grade VARCHAR2(20) DEFAULT 'Bronze' NOT NULL
);

/**********************************/
/* Table Name: Category */
/**********************************/
CREATE TABLE Category(
		c_no NUMBER(10) PRIMARY KEY,
		c_kind VARCHAR2(10) NOT NULL
);

/**********************************/
/* Table Name: Member */
/**********************************/
CREATE TABLE Member(
		m_no NUMBER(10) PRIMARY KEY,
		m_name VARCHAR2(20) NOT NULL,
		m_id VARCHAR2(20) NOT NULL,
		m_pw VARCHAR2(20) NOT NULL,
		m_birth VARCHAR2(10),
		m_gender VARCHAR2(20) NOT NULL,
		m_point NUMBER(10),
		m_manager VARCHAR2(10) NOT NULL,
		g_no NUMBER(10),
		c_no NUMBER(10)
);

/**********************************/
/* Table Name: Recipe */
/**********************************/
CREATE TABLE Recipe(
		r_no NUMBER(10) PRIMARY KEY,
		r_title VARCHAR2(30) NOT NULL,
		m_no NUMBER(10) NOT NULL,
		r_content VARCHAR2(200),
		r_date DATE DEFAULT sysdate,
		r_img VARCHAR2(30),
		c_no NUMBER(10) NOT NULL,
		r_count NUMBER(10) DEFAULT 0 NOT NULL
);

/**********************************/
/* Table Name: Tasty */
/**********************************/
CREATE TABLE Tasty(
		t_no NUMBER(10) PRIMARY KEY,
		t_title VARCHAR2(20),
		t_content VARCHAR2(200),
		t_date DATE DEFAULT sysdate NOT NULL,
		t_img VARCHAR2(30),
		t_time VARCHAR2(20),
		t_address VARCHAR2(200),
		t_count NUMBER(10) DEFAULT 0 NOT NULL,
		c_no NUMBER(10)
);

/**********************************/
/* Table Name: Score */
/**********************************/
CREATE TABLE Score(
		s_no NUMBER(10) PRIMARY KEY,
		t_no NUMBER(10),
		m_no NUMBER(10),
		s_star NUMBER(10) DEFAULT 0 NOT NULL
);

/**********************************/
/* Table Name: Datgle */
/**********************************/
CREATE TABLE Datgle(
		d_no NUMBER(10) PRIMARY KEY,
		d_groupNo NUMBER(10) NOT NULL,
		d_step NUMBER(10) NOT NULL,
		d_filter VARCHAR2(20) NOT NULL,
		d_content VARCHAR2(100),
		m_no NUMBER(10),
		d_title VARCHAR2(30) NOT NULL,
	
		d_date DATE DEFAULT sysdate NOT NULL
);

/**********************************/
/* Table Name: Hoogi */
/**********************************/
CREATE TABLE Hoogi(
		h_no NUMBER(10) PRIMARY KEY,
		h_title VARCHAR2(20) NOT NULL,
		m_no NUMBER(10),
		h_content VARCHAR2(200),
		h_date DATE DEFAULT sysdate NOT NULL,
		h_img VARCHAR2(30),
		t_no NUMBER(10),
		c_no NUMBER(10),
		h_count NUMBER(10) DEFAULT 0 NOT NULL
);
/**********************************/
/* Table Name: jumon */
/**********************************/
CREATE TABLE jumon(
		j_no NUMBER(10) PRIMARY KEY,
		j_total NUMBER(10),
		j_ok NUMBER(10)
);
/**********************************/
/* Table Name: porce */
/**********************************/
CREATE TABLE porce(
		p_no NUMBER(10) PRIMARY KEY,
		t_no NUMBER(10),
		j_no NUMBER(10)
);
/**********************************/
/* Table Name: Item */
/**********************************/
CREATE TABLE Item(
		i_no NUMBER(10) PRIMARY KEY,
		i_name VARCHAR(100),
		i_price NUMBER(10),
		i_count NUMBER(10),
		j_no NUMBER(10)
);
/**********************************/
/* Key ÂüÁ¶ÇÏ±â */
/**********************************/
ALTER TABLE Member ADD CONSTRAINT IDX_Member_FK0 FOREIGN KEY (g_no) REFERENCES Grade (g_no);
ALTER TABLE Member ADD CONSTRAINT IDX_Member_FK1 FOREIGN KEY (c_no) REFERENCES Category (c_no);

ALTER TABLE Recipe ADD CONSTRAINT IDX_Recipe_FK0 FOREIGN KEY (m_no) REFERENCES Member (m_no);
ALTER TABLE Recipe ADD CONSTRAINT IDX_Recipe_FK1 FOREIGN KEY (c_no) REFERENCES Category (c_no);

ALTER TABLE Tasty ADD CONSTRAINT IDX_Tasty_FK0 FOREIGN KEY (c_no) REFERENCES Category (c_no);

ALTER TABLE Score ADD CONSTRAINT IDX_Score_FK0 FOREIGN KEY (t_no) REFERENCES Tasty (t_no);
ALTER TABLE Score ADD CONSTRAINT IDX_Score_FK1 FOREIGN KEY (m_no) REFERENCES Member (m_no);

ALTER TABLE Datgle ADD CONSTRAINT IDX_Datgle_FK0 FOREIGN KEY (m_no) REFERENCES Member (m_no);

ALTER TABLE Hoogi ADD CONSTRAINT IDX_Hoogi_FK0 FOREIGN KEY (t_no) REFERENCES Tasty (t_no);
ALTER TABLE Hoogi ADD CONSTRAINT IDX_Hoogi_FK1 FOREIGN KEY (c_no) REFERENCES Category (c_no);
ALTER TABLE Hoogi ADD CONSTRAINT IDX_Hoogi_FK2 FOREIGN KEY (m_no) REFERENCES Member (m_no);
ALTER TABLE porce ADD CONSTRAINT IDX_porce_FK0 FOREIGN KEY (t_no) REFERENCES Tasty (t_no);
ALTER TABLE porce ADD CONSTRAINT IDX_porce_FK1 FOREIGN KEY (j_no) REFERENCES jumon (j_no);
ALTER TABLE Item ADD CONSTRAINT IDX_Item_FK0 FOREIGN KEY (j_no) REFERENCES jumon (j_no);

commit;
/**** category ½ÃÄö½º & insert *****/
create sequence c_no_seq  increment by 1 start with 1;
insert into category values (c_no_seq.nextval,'ÇÑ½Ä');
/**** grade ½ÃÄö½º & insert *****/
create sequence g_no_seq increment by 1 start with 1;
insert into grade values (g_no_seq.nextval,'1µî');
/**** member ½ÃÄö½º & insert *****/
create sequence m_no_seq  increment by 1 start with 1;
insert into member  values (m_no_seq.nextval,'name','id','pw','900808','³²',100,0,1,1);
insert into member  values (m_no_seq.nextval,'name','id','pw','900808','³²',100,0,1,1);
insert into member  values (m_no_seq.nextval,'name','id','pw','900808','³²',100,0,1,1);

/**** recipe ½ÃÄö½º & insert *****/
create sequence r_no_seq  increment by 1 start with 1;
insert into recipe values (r_no_seq.nextval,'title',1,'content',sysdate,'../img.jpg',1,0);

/**** datgle ½ÃÄö½º & insert *****/
create sequence d_no_seq  increment by 1 start with 1;
insert into datgle values (d_no_seq.nextval,0,0,'filter','content',1,'title',sysdate);

/**** tasty ½ÃÄö½º & insert *****/
create sequence t_no_seq increment by 1 start with 1;
insert into tasty values (t_no_seq.nextval,'title','content',sysdate,'../img.jpg','time','address',0,1);

/**** scroe ½ÃÄö½º & insert *****/
create sequence s_no_seq increment by 1 start with 1;
insert into score values (s_no_seq.nextval,1,1,1);

/**** hoogi ½ÃÄö½º & insert *****/
create sequence h_no_seq increment by 1 start with 1;
insert into hoogi values (h_no_seq.nextval,'title',1,'content',sysdate,'../img.jpg',1,1,1);

/**** porce ½ÃÄö½º & insert *****/
create sequence p_no_seq increment by 1 start with 1;
insert into porce values (p_no_seq.nextval,1,1);

/**** jumon ½ÃÄö½º & insert *****/
create sequence j_no_seq increment by 1 start with 1;
insert into jumon values (j_no_seq.nextval,1,1);

/**** item ½ÃÄö½º & insert *****/
create sequence i_no_seq increment by 1 start with 1;
insert into item values (i_no_seq.nextval,'name',1,1,1);

commit;