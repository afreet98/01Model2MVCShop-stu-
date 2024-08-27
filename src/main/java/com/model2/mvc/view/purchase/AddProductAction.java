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
		purchaseVO.setProdName(request.getParameter("prodName"));//��ǰ��
		purchaseVO.setProdDetail(request.getParameter("prodDetail"));//��ǰ������
		purchaseVO.setManuDate(request.getParameter("manuDate"));//��������
		purchaseVO.setPrice(Integer.parseInt(request.getParameter("price")));//����		
		purchaseVO.setFileName(request.getParameter("fileName"));//��ǰ�̹���

		System.out.println(purchaseVO);
		
		PurchaseService service=new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		return "redirect:/product/addProductView.jsp";
		//return "redirect:/user/loginView.jsp";
	}
}