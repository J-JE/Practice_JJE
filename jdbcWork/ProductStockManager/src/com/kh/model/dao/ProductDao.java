package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.exception.ProductException;
import com.kh.model.dto.Product;
import com.kh.model.vo.ProductIO;

public class ProductDao {
	
	private Properties prop = null;
	
	public ProductDao() {

		try {
			prop = new Properties();
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Product> selectAll(Connection conn) throws ProductException { //전체 조회
		ArrayList<Product> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<Product>();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("STOCK"));
				
				list.add(p);
			}
			
		} catch (Exception e) {
			throw new ProductException("selectAll 에러 : "+e.getMessage());
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int insertProduct(Connection conn, Product p) throws ProductException { //상품 추가
		int result = 0;
		
		PreparedStatement pstmt = null;
//		ResultSet rset = null; //결과 출력 필요 없음
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("insertProduct 에러 : "+e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateProduct(Connection conn, Product p) throws ProductException { //상품 수정
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateProduct");
		//UPDATE PRODUCT_STOCK SET P_NAME = ?, PRICE = ?, DESCRIPTION = ? WHERE PRODUCT_ID = ?
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getpName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getDescription());
			pstmt.setString(4, p.getProductId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("updateProduct 에러 : "+e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteProduct(Connection conn, String id) throws ProductException { //상품 삭제
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("deleteProduct 에러 : "+e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Product> searchProduct(Connection conn, String name) throws ProductException { //상품 검색
		ArrayList<Product> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("STOCK"));
				
				list.add(p);
			}
			
		} catch (Exception e) {
			throw new ProductException("searchProduct 에러 : "+e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<ProductIO> selectAllIo(Connection conn) throws ProductException { //전체 입출고 내역 조회
		ArrayList<ProductIO> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllIo");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<ProductIO>();
			
			while(rset.next()) {
				ProductIO p = new ProductIO();
				
				p.setIoNum(rset.getInt("IO_NUM"));
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setIoDate(rset.getDate("IO_DATE"));
				p.setAmount(rset.getInt("AMOUNT"));
				p.setStatus(rset.getString("STATUS"));
				
				list.add(p);
			}
		
		} catch (Exception e) {
			throw new ProductException("selectAllIo 에러 : "+e.getMessage());
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	public ArrayList<ProductIO> selectInOut(Connection conn, int i) throws ProductException { //입/출고 내역 조회
		ArrayList<ProductIO> list = null;
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectInOut");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			String select = null;
			if(i == 0) {
				select = "입고";
			}else if(i == 1){
				select = "출고";
			}
			
			pstmt.setString(1,select);
			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<ProductIO>();
			
			while(rset.next()) {
				ProductIO p = new ProductIO();
				
				p.setIoNum(rset.getInt("IO_NUM"));
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setIoDate(rset.getDate("IO_DATE"));
				p.setAmount(rset.getInt("AMOUNT"));
				p.setStatus(rset.getString("STATUS"));
				
				list.add(p);
			}
		
		} catch (Exception e) {
			throw new ProductException("selectInOut 에러 : "+e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int ProductInOut(Connection conn, ProductIO p) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("ProductInOut");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getProductId());
			pstmt.setInt(2, p.getAmount());
			pstmt.setString(3, p.getStatus());
			
			result = pstmt.executeUpdate();
			

		} catch (Exception e) {
			throw new ProductException("selectInOut 에러 : "+e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
