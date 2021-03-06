package com.kh.service;

//static 필수! .* 필수!
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.exception.ProductException;
import com.kh.model.dao.ProductDao;
import com.kh.model.dto.Product;
import com.kh.model.vo.ProductIO;

public class ProductService {

	public ArrayList<Product> selectAll() throws ProductException { //전체 조회
		Connection conn = getConnection();
		ArrayList<Product> list = new ProductDao().selectAll(conn);
		
		return list;
	}

	public int insertProduct(Product p) throws ProductException { //상품 추가
		Connection conn = getConnection();
		
		int result = new ProductDao().insertProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int updateProduct(Product p) throws ProductException { //상품 수정
		Connection conn = getConnection();
		
		int result = new ProductDao().updateProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteProduct(String id) throws ProductException { //상품 삭제
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteProduct(conn, id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Product> searchProduct(String name) throws ProductException { //상품 검색
		Connection conn = getConnection();
		ArrayList<Product> list = new ProductDao().searchProduct(conn, name);
		
		return list;
	}
	
	///////////////////////////////////////////////////////////////////

	public ArrayList<ProductIO> selectAllIo() throws ProductException { //전체 입출고 내역 조회
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDao().selectAllIo(conn);
		
		return list;
	}

	public ArrayList<ProductIO> selectInOut(int i) throws ProductException { //입/출고 내역 조회
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDao().selectInOut(conn, i);
		
		return list;
	}

	public int ProductInOut(ProductIO p) throws ProductException { //상품 입/출고
		Connection conn = getConnection();
		
		int result = new ProductDao().ProductInOut(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public void exitProgram() {
		close(getConnection());
	}

}
