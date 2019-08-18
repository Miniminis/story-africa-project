package com.storyafrica.sa.member.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(rs.getInt(1),
							rs.getString(2), 
							rs.getString(3),
							rs.getString(4), 
							rs.getString(5),
							rs.getDate(6));

		return member;
	}

}
