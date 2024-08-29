package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;
import com.model2.mvc.service.user.UserService;



public class AddPurchaseAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		ProductService Product=new ProductServiceImpl();
		ProductVO po=Product.getProduct(prodNo);
		
		HttpSession session=request.getSession();
		UserVO vo=(UserVO)session.getAttribute("user"); //세션에서 아이디 불어오는거
		
		
		
		PurchaseVO purchaseVO=new PurchaseVO();
		purchaseVO.setPurchaseProd(po);//상품번호
		purchaseVO.setBuyer(vo);//구매자 아이디
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));//구매방법
		purchaseVO.setReceiverName(request.getParameter("receiverName"));//구매자 이름
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));//구매자 연락처
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));//구매자 주소
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));//구매요청사항
		purchaseVO.setDivyDate(request.getParameter("receiverDate"));//구매요청사항
		purchaseVO.setTranCode("배송중");//구매 상태 코드

		System.out.println(purchaseVO);
		
		PurchaseService service=new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		return "forward:/purchase/addPurchase.jsp";
	}
}