package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class DeptDAO {
	
	
	// 1. dname 으로 입력값 찾아보기 .
	// deptno -> dname
	// Query : SELECT dname From dept WHERE deptno = ?;
	public static String getDnameByDeptno(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT dname From dept WHERE deptno = ?";
		String dname = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				dname =rset.getString("dname");
			}
		}finally {
			rset.close();
			pstmt.close();
			con.close();
		}
		
		
		return dname;
	}
	
	
	// 2. dname insert
	public static boolean insertDnameByDeptno(int deptno, String dname, String loc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rset = null;
		
		String sql = "insert into dept values(? , ? , ?)";
//		String dname = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("추가가 완료 되었습니다.");
				return true;
			}
		}finally {
			pstmt.close();
			con.close();
		}
		
		
		return false;
	}
	
	// 3. 수정하기
	public static boolean updateDnameByDeptno(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rset = null;
		
		String sql = "update dept set loc = \"suncheon\" where  deptno = ?";
//		String dname = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("수정이 완료 되었습니다.");
				return true;
			}
		}finally {
			pstmt.close();
			con.close();
		}
		
		
		return false;
	}
	
	
	// 4. 삭제하기
	public static boolean deleteDnameByDeptno(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rset = null;
		
		String sql = "delete FROM dept WHERE deptno = ?";
//		String dname = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("삭제가 완료 되었습니다.");
				return true;
			}
		}finally {
			pstmt.close();
			con.close();
		}
		
		
		return false;
	}
}
