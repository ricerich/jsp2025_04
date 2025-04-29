package model2.mvcboard;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class MVCBoardDAO extends DBConnPool {

	public List<MVCBoardDTO> selectListPage(Map<String, Object> map) {
		// 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
		List<MVCBoardDTO> board = new Vector<MVCBoardDTO>();
		
		StringBuffer query = new StringBuffer();
		
		query.append(" ");
		query.append(" SELECT "); 
		query.append("         * 									"); 
		query.append(" FROM (     									");
		query.append("         SELECT 								"); 
		query.append("                 Tb.*, ROWNUM rNum 			"); 
		query.append("         FROM  								");
		query.append("               (SELECT 						"); 
		query.append("                         *  					"); 
		query.append("                  FROM  						");
		query.append("                         mvcboard 			");
		
		if(map.get("searchWord") != null) {
			query.append("                WHERE  						");
			query.append("                         "+map.get("searchField")+" LIKE '%"+map.get("searchWord")+"%'  ");         
		}
		
		query.append("              ORDER BY idx DESC  				");    
		query.append("               ) Tb  							");
		query.append("      )   									");
		query.append(" WHERE  										");
		query.append("       rNum BETWEEN ? AND ?  					");
		
		System.out.println(query.toString());
		
//		String query = "" ;
//		query +=" SELECT "; 
//		query +="         * ";
//		query +=" FROM  ";
//		query +="         mvcboard "; 
//		query +=" ORDER BY IDX DESC ";

		try {
//			psmt = con.prepareStatement(query);
			psmt = con.prepareStatement(query.toString());
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
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
	
	
    // 검색 조건에 맞는 게시물의 개수를 반환합니다.
    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM mvcboard";
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " "
                   + " LIKE '%" + map.get("searchWord") + "%'";
        }
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            totalCount = rs.getInt(1);
        }
        catch (Exception e) {
            System.out.println("게시물 카운트 중 예외 발생");
            e.printStackTrace();
        }

        return totalCount;
    }	

//    public MVCBoardDAO() {
//        super();
//    }

}
