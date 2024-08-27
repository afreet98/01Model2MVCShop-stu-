package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;


public class ProductDAO {
	
	public ProductDAO(){
	}

	public void insertUser(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "insert into product values (seq_product_prod_no.NEXTVAL,?,?,?,?,?,sysdate)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());//제품명
		stmt.setString(2, productVO.getProdDetail());//상품상세보기
		stmt.setString(3, productVO.getManuDate());//제조일자
		stmt.setInt(4, productVO.getPrice());///가격
		stmt.setString(5, productVO.getFileName()); //상품 이미지
	
		
		stmt.executeUpdate();
		
		con.close();
	}
	
	
	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select * from product ";
		if (searchVO.getSearchCondition() != null) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " where prod_name='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " where prod_name='" + searchVO.getSearchKeyword()
						+ "'";
			}
		}
		sql += " order by prod_name";

		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				ProductVO po = new ProductVO();
				po.setProdNo(Integer.parseInt(rs.getString("prod_no")));
				po.setFileName(rs.getString("image_file"));
				po.setManuDate(rs.getString("manufacture_day"));
				po.setPrice(Integer.parseInt(rs.getString("price")));
				po.setProdDetail(rs.getString("prod_detail"));
				po.setProdName(rs.getString("prod_name"));
				po.setRegDate(rs.getDate("reg_date"));

				list.add(po);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}
	

	public void updateProduct(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "update product set prod_name=?,prod_detail=?,manufacture_day=?,price=?,image_file=? where prod_no=?";
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		stmt.setString(5, productVO.getFileName());
		stmt.setInt(6, productVO.getProdNo());
		stmt.executeUpdate();
		
		con.close();
	}
	
public ProductVO findProduct(int ProductVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "select * from product where prod_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, ProductVO);

		ResultSet rs = stmt.executeQuery();

		ProductVO productVO = null;
		while (rs.next()) {
			productVO = new ProductVO();
			productVO.setProdNo(Integer.parseInt(rs.getString("prod_no")));
			productVO.setFileName(rs.getString("image_file"));
			productVO.setManuDate(rs.getString("manufacture_day"));
			productVO.setPrice(Integer.parseInt(rs.getString("price")));
			productVO.setProdDetail(rs.getString("prod_detail"));
			productVO.setProdName(rs.getString("prod_name"));
			productVO.setRegDate(rs.getDate("reg_date"));
		}
		
		con.close();

		return productVO;
	}
	
}