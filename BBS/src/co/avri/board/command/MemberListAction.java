package co.avri.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.avri.board.comm.Action;
import co.avri.board.dao.MemberDAO;
import co.avri.board.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원리스트보기 구현
		MemberDAO dao = new MemberDAO(); // 원래 권장사항은 memberDao인데, dao랑 vo는 다들 아니까..
//		MemberVO vo = new MemberVO(); 던져주는 값이 없으니까 vo는 필요없음. 받기만 하니까
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		list = dao.selectAll();
		
		// 결과가 왔으면 request 객체에 담아줘야함
		request.setAttribute("members", list); // 넘어온 리스트를 members 라는 이름으로 담아서 쓸래
		// members 변수는 jsp에서 쓰는것임ㅇㅇ
		
		return "jsp/member/memberList.jsp";
	}

}
