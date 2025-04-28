package model2.mvcboard;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
						throws ServletException, IOException {
		
	       // DAO 생성
	       MVCBoardDAO dao = new MVCBoardDAO();
	       
	       //중간에 코드 많음 1.검색, 2.페이징
	       
//	       List<MVCBoardDTO> boardLists = dao.selectListPage(map);  // 게시물 목록 받기
	       List<MVCBoardDTO> boardLists = dao.selectListPage();  // 게시물 목록 받기
	       
	        // 전달할 데이터를 request 영역에 저장 후 List.jsp로 포워드
	        req.setAttribute("boardLists", boardLists);
//	        req.setAttribute("map", map);
	        
	       //respone 뷰페이지 작성
	       req.getRequestDispatcher("/14MVCBoard/List.jsp").forward(req, resp);
		
	       
	}
	

}
