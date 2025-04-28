package model2.mvcboard;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MVCBoardDAO extends DBConnPool {

	public List<MVCBoardDTO> selectListPage() {
		// 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
		List<MVCBoardDTO> board = new Vector<MVCBoardDTO>();
		
		StringBuffer query = new StringBuffer();
		
		query.append("");
		query.append(" SELECT "); 
		query.append(" 			IDX, NAME, TITLE, CONTENT, POSTDATE, " );
		query.append(" 			OFILE, SFILE, DOWNCOUNT, PASS,	VISITCOUNT "); 
		query.append(" FROM "); 
		query.append("        mvcboard "); 
		query.append(" ORDER BY ");
		query.append(" 			IDX DESC ");
		
//		String query = "" ;
//		query +=" SELECT "; 
//		query +="         * ";
//		query +=" FROM  ";
//		query +="         mvcboard "; 
//		query +=" ORDER BY IDX DESC ";

		try {
//			psmt = con.prepareStatement(query);
			psmt = con.prepareStatement(query.toString());
//			psmt.setString(1, map.get("start").toString());
//			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				MVCBoardDTO dto = new MVCBoardDTO();

				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));

				board.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}

//    public MVCBoardDAO() {
//        super();
//    }

}
