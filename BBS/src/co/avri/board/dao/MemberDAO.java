package co.avri.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.avri.board.vo.MemberVO;

public class MemberDAO extends DAO {
	private PreparedStatement pstmt; // sql명령문 실행. 커넥션을 통해 데이터베이스에 SQL을 날림
	private ResultSet rs; // select 후 결과셋 받기
	// 돌아오는 결과.. 보통 recordSet라고 하지만 자바에서는 resultSet라고 씀
	private MemberVO vo; // dao에 vo 실어서 보냄
	
	private final String SELECT_ALL = "SELECT * FROM MEMBER"; // final 상수들은 대부분 대문자 쓴다.. (ctrl+shift+X)
	
	public List<MemberVO> selectAll(){ // 멤버리스트 전체를 가져오는 메소드
		List<MemberVO> list = new ArrayList<MemberVO>();
		// 결과값이 여러개가 들어올수있으니 콜렉션 개체에 담는다(ArrayList)
		try {
			pstmt = conn.prepareStatement(SELECT_ALL); // dbms에 sql 전달
			rs = pstmt.executeQuery(); // pstmt 수행결과를 받아서 rs에 담음
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id")); // rs의 id 결과값을 가져와서 MemberVO의 setId에 담는거
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password")); // pw는 안담아와도됨
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
				// vo에 다 담았으면 list에 추가해주자
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public MemberVO select(MemberVO vo) { // 한 행을 찾을때(검색할때) select
		return vo;
	}
	public int insert(MemberVO vo) { // MemberVO(member 테이블)에 insert 추가
		int n = 0;
		
		return n;
	}
	public int update(MemberVO vo) { // MemberVO에 (member 테이블에) update 수정
		int n = 0;
		
		return n;
	}
	public int delete(MemberVO vo) { // MemberVO에 (member 테이블에) delete 삭제
		int n = 0;
		
		return n;
	}
}