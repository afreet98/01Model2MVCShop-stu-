package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO=new PurchaseDAO();
	}

	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.insertPurchase(purchaseVO);
	}
	
	public HashMap<String,Object> getProductList(SearchVO String) throws Exception {
		return purchaseDAO.getPurchaseList(String);
	}
	/*
	public void updateProduct(ProductVO productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}
	
	public ProductVO getProduct(int ProductVO) throws Exception {
		return productDAO.findProduct(ProductVO);
	}
*/
}