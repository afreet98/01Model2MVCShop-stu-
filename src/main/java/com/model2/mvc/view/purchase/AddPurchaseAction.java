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
		UserVO vo=(UserVO)session.getAttribute("user"); //���ǿ��� ���̵� �Ҿ���°�
		
		
		
		PurchaseVO purchaseVO=new PurchaseVO();
		purchaseVO.setPurchaseProd(po);//��ǰ��ȣ
		purchaseVO.setBuyer(vo);//������ ���̵�
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));//���Ź��
		purchaseVO.setReceiverName(request.getParameter("receiverName"));//������ �̸�
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));//������ ����ó
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));//������ �ּ�
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));//���ſ�û����
		purchaseVO.setDivyDate(request.getParameter("receiverDate"));//���ſ�û����
		purchaseVO.setTranCode("�����");//���� ���� �ڵ�

		System.out.println(purchaseVO);
		
		PurchaseService service=new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		return "forward:/purchase/addPurchase.jsp";
	}
}