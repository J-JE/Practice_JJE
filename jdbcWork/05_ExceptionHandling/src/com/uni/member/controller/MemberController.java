package com.uni.member.controller;

import java.util.ArrayList;

import com.uni.common.exception.MemberException;
import com.uni.member.model.dto.Member;
import com.uni.member.service.MemberService;
import com.uni.member.view.MemberMenu;

public class MemberController {
	//view 와 dao를 연결해주는 객체
	// view <-> controller <-> dao <-> db

	public void selectAll() {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list;
		
		try {
			list = new MemberService().selectAll();
			
			if(!list.isEmpty()) {
				menu.displayMemberList(list);
			}else {
				menu.displayNoData();
			}
		} catch (MemberException e) {
			menu.displayError("회원전체 조회 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
	}

	public void selectOne(String MemberId) {
		MemberMenu menu = new MemberMenu();
		Member m;
		try {
			m = new MemberService().selectOne(MemberId);
			
			if(m != null) {
				menu.displayMemberList(m);
			}else {
				menu.displayNoData();
			}
		} catch (MemberException e) {
			menu.displayError("회원 조회 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
		
	}

	public void selectByName(String MemberName) {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list;
		
		try {
			list = new MemberService().selectByName(MemberName);
			
			if(!list.isEmpty()) {
				menu.displayMemberList(list);
			}else {
				menu.displayNoData();
			}
		} catch (MemberException e) {
			menu.displayError("해당하는 데이터가 없습니다.");
			System.out.println(e.getMessage());
		}
	}
	
	public void insertMember(Member m) {

		int result;
		try {
			result = new MemberService().insertMember(m);
			
			if(result > 0) {
				new MemberMenu().displaySuccess("회원 가입 성공");
			}
		} catch (MemberException e) {
			new MemberMenu().displayError("회원 가입 실패");
			System.out.println(e.getMessage());
		}

	}
	
	public void updateMemeber(Member m) {
		
		int result;
		try {
			result = new MemberService().updateMemeber(m);
			if(result > 0) {
				   new MemberMenu().displaySuccess("회원 수정 성공");
			   }
		} catch (MemberException e) {
			new MemberMenu().displayError("회원 수정 실패");
			System.out.println(e.getMessage());
		}
	}

	public void deleteMember(String userId) {
		int result;
		try {
			result = new MemberService().deleteMember(userId);
			if(result > 0) {
				   new MemberMenu().displaySuccess("회원 삭제 성공");
			   }
		} catch (MemberException e) {
			new MemberMenu().displayError("회원 삭제 실패");
			System.out.println(e.getMessage());
		}
	}

	public void selectAllDeleteMember() {
		MemberMenu menu = new MemberMenu();
		ArrayList<Member> list;
		try {
			list = new MemberService().selectAllDeleteMember();
			if(!list.isEmpty()) {
				menu.displayDeleteAllMemberList(list);
			}
		} catch (MemberException e) {
			menu.displayError("해당하는 데이터가 없습니다.");
			System.out.println(e.getMessage());
		}
	}

	public void exitProgram() {
		new MemberService().exitProgram();
	}

}
