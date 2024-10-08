package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class PurchaseDAO {
	
	public PurchaseDAO(){
	}
 
	public void insertPurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		//
		String sql = "insert into transaction values (seq_purchase_tran_no.NEXTVAL,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, purchaseVO.getPurchaseProd().getProdNo());//
		stmt.setString(2, purchaseVO.getBuyer().getUserId()); //
		stmt.setString(3, purchaseVO.getPaymentOption());
		stmt.setString(4, purchaseVO.getReceiverName());
		stmt.setString(5, purchaseVO.getReceiverPhone());
		stmt.setString(6, purchaseVO.getDivyAddr());
		stmt.setString(7, purchaseVO.getDivyRequest());
		stmt.setString(8, purchaseVO.getTranCode());
	
		
		stmt.executeUpdate();
		
		con.close();
	}
	
   
	
	
	public HashMap<String,Object> getPurchaseList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select * from purchase ";

		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("�ο��� ��:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				PurchaseVO pv = new PurchaseVO();
				pv.setTranNo(Integer.parseInt(rs.getString("tran_no")));
				pv.setBuyer(rs.getString("buyer_id"));
				pv.setManuDate(rs.getString("payment_option"));
				pv.setPrice(Integer.parseInt(rs.getString("receiver_name")));
				pv.setProdDetail(rs.getString("receiver_phone"));
				pv.setProdName(rs.getString("demailaddr"));
				pv.setRegDate(rs.getDate("dlvy_request"));
				pv.setRegDate(rs.getDate("tran_status_code"));
				pv.setRegDate(rs.getDate("order_data"));
				pv.setRegDate(rs.getDate("dlvy_date"));

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
	/*

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
	*/
}