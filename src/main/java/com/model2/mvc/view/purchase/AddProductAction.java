package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		PurchaseVO purchaseVO=new PurchaseVO();
		purchaseVO.setProdName(request.getParameter("prodName"));//상품명
		purchaseVO.setProdDetail(request.getParameter("prodDetail"));//상품상세정보
		purchaseVO.setManuDate(request.getParameter("manuDate"));//제조일자
		purchaseVO.setPrice(Integer.parseInt(request.getParameter("price")));//가격		
		purchaseVO.setFileName(request.getParameter("fileName"));//상품이미지

		System.out.println(purchaseVO);
		
		PurchaseService service=new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		return "redirect:/product/addProductView.jsp";
		//return "redirect:/user/loginView.jsp";
	}
}