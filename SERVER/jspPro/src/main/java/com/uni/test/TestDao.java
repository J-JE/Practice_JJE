package com.uni.test;
//package com.kh.test.model.TestDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {

	 public List<Test> selectList() {
		List<Test> list = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TEST";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(" jdbc:oracle:thin:@192.168.10.3:1521:xe", "kh", "kh");
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<Test>();
			
			while(rset.next()) {
				Test t = new Test(rset.getInt("SEQ"),
								  rset.getString("WRITER"),
								  rset.getString("TITLE"),
								  rset.getString("CONTENT"),
								  rset.getDate("REGDATE")
								 );
				list.add(t);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
