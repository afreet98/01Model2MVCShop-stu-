package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public interface PurchaseService {
	
	public void addPurchase(PurchaseVO purchaseVO) throws Exception;
	
	
	//public HashMap<String, Object> getProductList(SearchVO searchVO) throws Exception;
	
	//public void updateProduct(ProductVO productVO) throws Exception;
	
	//public ProductVO getProduct(int ProductVO) throws Exception;
	
	
	//public boolean checkDuplication(String userId) throws Exception;
	
}