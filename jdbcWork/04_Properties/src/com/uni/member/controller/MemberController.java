package com.uni.member.controller;

import java.util.ArrayList;

import com.uni.member.model.dao.MemberDao;
import com.uni.member.model.dto.Member;
import com.uni.member.service.MemberService;
import com.uni.member.view.MemberMenu;

public class MemberController {
	//view 와 dao를 연결해주는 객체
	// view <-> controller <-> dao <-> db

	public void selectAll() {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list = new MemberService().selectAll();
		
		if(!list.isEmpty()) {
			menu.displayMemberList(list);
		}else {
			menu.displayError("해당하는 데이터가 없습니다.");
		}
	}

	public void selectOne(String MemberId) {
		MemberMenu menu = new MemberMenu();
		Member m = new MemberService().selectOne(MemberId);
		
		if(m != null) {
			menu.displayMemberList(m);
		}else {
			menu.displayError("해당하는 데이터가 없습니다.");
		}
	}

	public void selectByName(String MemberName) {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list = new MemberService().selectByName(MemberName);

		if(!list.isEmpty()) {
			menu.displayMemberList(list);
		}else {
			menu.displayError("해당하는 데이터가 없습니다.");
		}
	}

	public void insertMember(Member m) {

		int result = new MemberService().insertMember(m);

		if(result > 0) {
			new MemberMenu().displaySuccess("회원 가입 성공");

		}else {
			new MemberMenu().displayError("회원 가입 실패");
		}


	}

	public void updateMemeber(Member m) {
		
		int result = new MemberService().updateMemeber(m);

		   if(result > 0) {
			   new MemberMenu().displaySuccess("회원 수정 성공");

		   }else {
			   new MemberMenu().displayError("회원 수정 실패");
		   }
	}

	public void deleteMember(String userId) {
		int result = new MemberService().deleteMember(userId);

		   if(result > 0) {
			   new MemberMenu().displaySuccess("회원 삭제 성공");

		   }else {
			   new MemberMenu().displayError("회원 삭제 실패");
		   }
		
	}

	public void selectAllDeleteMember() {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list = new MemberService().selectAllDeleteMember();
		
		if(!list.isEmpty()) {
			menu.displayDeleteAllMemberList(list);
		}else {
			menu.displayError("해당하는 데이터가 없습니다.");
		}
	}

	public void exitProgram() {
		new MemberService().exitProgram();
	}

}
