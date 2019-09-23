package com.firstboot.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstboot.domain.Member;
import com.firstboot.entity.MemberEntity;
import com.firstboot.mapper.MemberMapper;
import com.firstboot.repository.MemberDaoImpl;
import com.firstboot.repository.MemberRepository;

@Controller
public class IndexController {

	//test 	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Spring Boot Test STARTEDDDDDDDDDDDDDDDDDDDD";
	}

	@RequestMapping("/hello")
	public void hello() {
		// void type 으로 아무런 반환 타입이 없기 /hello url 에 지정된 페이지를 표시하게 된다.
	}

	// return 타입을 정해준다면 : 해당 데이터를 표시
	// return 타입이 없다면 : url 에 지정된 페이지를 표시

	////////////sql session template + mapper interface////////////////////////
	@Autowired
	private SqlSessionTemplate template;

	private MemberMapper mapper;
	
	//MemberMapper interface + xml 
	@RequestMapping("/member")
	@ResponseBody
	public Member selectByIdx() {
		mapper = template.getMapper(MemberMapper.class);
		Member member = mapper.selectMemberById("minhee4735@naver.com");
		System.out.println("member from mapper :::::: " + member);
		
		return member;
	}

	//MemberMapper interface + @Select annotation
	@RequestMapping("/members")
	@ResponseBody
	public List<Member> selectMembers() {
		mapper = template.getMapper(MemberMapper.class);
		List<Member> memberlist = mapper.selectMemberList();
		for (Member member : memberlist) {
			System.out.println("member 리스트 ::: "+member);
		}
		return memberlist;
	}
	
	////////////////////////////////////////JPA/////////////////////////////////////
	@Autowired
	private MemberRepository repository; //interface 임에도 주입을 받을 수 있고 + 부트 시작과 동시에 객체 생성 

	//내장 매서드
	@RequestMapping("/jpa/members")
	@ResponseBody //return entity 타입 + @ResponseBody = json 형태로 페이지 출력 
	public List<MemberEntity> getMemberList() {
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		for(MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	//내장 매서드
	@RequestMapping("/jpa/member/insert")
	@ResponseBody
	public String insertMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setUserid("cool00001@hot");
		entity.setUsername("minimini0001");
		entity.setUserpw("123456");
		
		return repository.saveAndFlush(entity).toString();
	}
	
	//내장 매서드
	@RequestMapping("/jpa/member/edit/{idx}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		
		entity.setIdx(idx);
		entity.setUserid("afterEdit@edit");
		entity.setUsername("Edited NAMEEEE");
		entity.setUserpw("123456");
		
		return repository.saveAndFlush(entity).toString();
	}
	
	//내장 매서드
	@RequestMapping("/jpa/member/delete/{idx}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();		
		entity.setIdx(idx);
		
		repository.delete(entity); //return type 이 void 이기 때문에 아래와 같이 확인하는 방법을 사용
		
		return "DELETE SUCCESSSSSSSSSSSSSSSSSSS";
	}
	
	//직접정의
	@RequestMapping("/jpa/member/{idx}")
	@ResponseBody
	public MemberEntity getMember(@PathVariable("idx") int idx) {
		MemberEntity entity = null;
		entity = repository.findByIdx(idx);
		System.out.println("entity  ::: "+entity);
		
		return entity;
	}
	
	//직접정의
	@RequestMapping("/jpa/member/searchByName/{username}")
	@ResponseBody
	public List<MemberEntity> getMember(@PathVariable("username") String username) {
		List<MemberEntity> list = null;
		
		list = repository.findByUsernameLike("%"+username+"%");
		//System.out.println("findByUsernameLike ::: "+list);
		
		return list;
	}
	
	//직접정의
	@RequestMapping("/jpa/member/searchByBetween/{idx1}/{idx2}")
	@ResponseBody
	public List<MemberEntity> getMember(@PathVariable("idx1") int idx1,
										@PathVariable("idx2") int idx2) {
		List<MemberEntity> list = null;
		
		list = repository.findByIdxBetween(idx1, idx2);
		
		return list;
	}
	
	/////////////////////////////////DAO 구현 ///////////////////////////////////
	@PersistenceContext
	EntityManager entityManager;
	//1. 부트 시작과 동시에 EntityManager 자동으로 bean 에 등록됨 
	//2. @PersistenceContext 가 필드에 연결 
	// - 여러개 설정할 수 없고 bean binding 은 1개만 
	//  == 여러개의 DAO 만들기는 불가함! 
	
	private MemberDaoImpl dao;
	
	/*public IndexController() {
		this.dao = new MemberDaoImpl(entityManager);
	}*/
	
	//DAO 통해서 리스트 출력
	@RequestMapping("/entitymanager/members")
	@ResponseBody
	public List<MemberEntity> memberListAll() {
		
		//dao 생성자통해서 정의
		dao = new MemberDaoImpl(entityManager);
		
		List<MemberEntity> list = dao.getAll();
		
		for(MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	
	//DAO 통해서 idx 통해 검색 결과 출력 
	@RequestMapping("/entitymanager/member/{idx}")
	@ResponseBody
	public MemberEntity oneMember(@PathVariable("idx") long idx) {
		
		dao = new MemberDaoImpl(entityManager);
		MemberEntity entity = dao.findByIdx(idx);
		return entity;
	}
	
	//DAO 통해서 username 통해 검색한 결과 출력 
	@RequestMapping("/entitymanager/members/{username}")
	@ResponseBody
	public List<MemberEntity> memberListByUsername(@PathVariable("username") String username) {
		dao = new MemberDaoImpl(entityManager);
		List<MemberEntity> entities = dao.findByUname(username);
		return entities;
	}
	
	//DAO 통해서 idx or username or userid 검색 구현 
	@RequestMapping("/entitymanager/members/find/{keyword}")
	@ResponseBody
	public List<MemberEntity> memberListSearch (@PathVariable("keyword") String keyword) {
		dao = new MemberDaoImpl(entityManager);
		List<MemberEntity> entities =  dao.find(keyword);
		return entities;
	}
	
	//@Query
	@RequestMapping("/queryannotation/members")
	@ResponseBody
	public Iterable<MemberEntity> memberAllList() {
		
		Iterable<MemberEntity> list = repository.findAllOrderByIdxDesc();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
}
