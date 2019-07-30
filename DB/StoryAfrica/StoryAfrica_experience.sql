
CREATE TABLE experience (
  eIdx int(11) NOT NULL AUTO_INCREMENT,
  idx int(11) NOT NULL,
  eTitle varchar(255) NOT NULL,
  eContent text NOT NULL,
  ePhoto varchar(255) NOT NULL DEFAULT '/image/noImg.png',
  eWriteDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  eViewCount int(11) NOT NULL DEFAULT '0',
  CONSTRAINT experience_eIdx_pk PRIMARY KEY(eIdx), 
  CONSTRAINT experience_idx_fk foreign key(idx)
  REFERENCES memberinfo(idx) on delete cascade  
);
select * from experience;

create table eLike (
	eIdx int(11),
    idx int(11),
    CONSTRAINT eLike_eIdx_fk foreign key(eIdx)
	REFERENCES experience(eIdx) on delete cascade,
	CONSTRAINT eLike_idx_fk foreign key(idx)
	REFERENCES memberinfo(idx) on delete cascade
);
select * from eLike;

create table eComment (
	eComIdx int(11) NOT NULL AUTO_INCREMENT,
    eIdx int(11),
    idx int(11),
	CONSTRAINT eComment_eComIdx_pk PRIMARY KEY(eComIdx), 
    CONSTRAINT eComment_eIdx_fk foreign key(eIdx)
	REFERENCES experience(eIdx) on delete cascade,
    CONSTRAINT eComment_idx_fk foreign key(idx)
	REFERENCES memberinfo(idx) on delete cascade
);

select * from eComment;
