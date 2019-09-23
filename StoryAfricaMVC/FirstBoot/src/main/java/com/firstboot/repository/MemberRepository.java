package com.firstboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firstboot.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	//JPA 내부에는 : ‘JPQL’ 이라는 SQL을 간략화한 언어를 내장! 
	//	- 아래에 직접 정의된 구문을 JpaRepository 가 알아서 해석함 
	//1. 기본 구조 : CRUD repository 지원 
	//findAll() : list 
	//saveAndFlush(entity) : insert 
	//saveAndFlush(entity) : edit
	//delete(entity) : delete
	
	//2. Repository 내 JPQL로 매서드 직접 정의  
	public MemberEntity findByIdx(Integer idx);
	public List<MemberEntity> findByUsernameLike(String username); 
		//인자에는 "%"+str+"%" 형태로 지정필요
	public List<MemberEntity> findByIdxBetween(int idx1, int idx2);
	
	
	//3. @query annotation
	@Query("select d from MemberEntity d order by d.idx desc")
	//@Query(value = "select * from MemberEntity, nativeQuery = true)
	public List<MemberEntity> findAllOrderByIdxDesc();
}

/* JPQL 
 * 
– AND
• FindByOOAND△△
from 엔티티 where OO = ? and △△ = ?

– OR
• FindByOOOR△△
from 엔티티 where OO = ? or △△ = ?

– Between
• FindByOOBetwwen
from 엔티티 where OO between ? and ?

– LessThan
• FindByOOLessThan
from 엔티티 where OO < ?

 • GreaterThan
– FindByOOGreaterThan
from 엔티티 where OO > ?

• IsNull
– FindByOOIsNull
from 엔티티 where OO is null

• IsNotNull/NotNull
– FindByOONotNull , FindByOOIsNotNull
from 엔티티 where OO not null

• Like
– FindByOOLike
from 엔티티 where OO like ?

* NotLike
– FindByOONotLike
from 엔티티 where OO not like ?

• OrderBy
– FindByOOOrderBy△△ASC
from 엔티티 where OO = ? order by △△ asc

• Not
– FindByOONot
from 엔티티 where OO <> ?

• In
– FindByOOIn(Collection Object)
from 엔티티 where OO in ?

* NotIn
– FindByOONotIn(Collection Object)
from 엔티티 where OO not in ?
 * */
