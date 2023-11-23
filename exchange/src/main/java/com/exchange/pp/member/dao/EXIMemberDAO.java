 package com.exchange.pp.member.dao;

import org.apache.ibatis.annotations.Mapper ;

import com.exchange.pp.code.vo.CodeVO;
import com.exchange.pp.member.vo.exMemberVO;


@Mapper
public interface EXIMemberDAO {

	public int registMember(exMemberVO member);
	public exMemberVO loginMember(exMemberVO member);
	public CodeVO chart(CodeVO code);

	public int profileUpload(exMemberVO member);

}