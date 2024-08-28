package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;



public class AddPurchaseViewAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		//HttpSession session=request.getSession();
		//String sessionId=((UserVO)session.getAttribute("user")).getUserId(); //세션에서 아이디 불어오는거
		
		
		ProductService service=new ProductServiceImpl();
		ProductVO po=service.getProduct(prodNo);
		
		
		request.setAttribute("po", po);
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
}
