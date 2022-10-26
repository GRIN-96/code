package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

import dept.dao.DeptDAO;

//CRUD 구분법 
// 1. 요청에 따라 SERVLET 생성
// 2. request에 요청하는 기능 값을 같이 주어서 if 문으로 기능을 나눠 주기 .

@WebServlet("/dept")  
public class DeptController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오 흐름 정리
		 * - 전달 받은 deptno 값으로 DB에 필요한 정보를 획득한다.
		 * 		-> DeptDAO(deptno)
		 * - 획득한 정보를 endview로 전달한다. 
		 * 		-> view.jsp (request.setAtrribute("dname", dname)
		 * 		-> failView.jsp  ( 객체 값이 없을 때 )
		 */
		
		int deptno = Integer.parseInt(request.getParameter("deptno")) ;
		String commend = request.getParameter("commend");
		
		
			
		System.out.println(deptno);
		if (commend.equals("search")) {
		try {
				String dname = DeptDAO.getDnameByDeptno(deptno);
			if(dname != null) {
				request.setAttribute("dname", dname);  // request set 만드는거 까먹지 않기 !! 중요 -> 호출이 안될 수 있음.
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}else {
				dname = String.valueOf(deptno);
				request.setAttribute("dname", dname);  // request set 만드는거 까먹지 않기 !! 중요 -> 호출이 안될 수 있음.
				request.getRequestDispatcher("failView.jsp").forward(request, response); // 홈페이지 주소 변경 x
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}else if (commend.equals("insert")) {
		String dnames = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		try {
			DeptDAO.insertDnameByDeptno(deptno, dnames, loc);
			request.getRequestDispatcher("succsess.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ss");
	}else if (commend.equals("delete")) {
		try {
			DeptDAO.deleteDnameByDeptno(deptno);
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}else {
		try {
			DeptDAO.updateDnameByDeptno(deptno);
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
	}
