package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		
		ProductVO productVO=new ProductVO();
		productVO.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));//����
		productVO.setFileName(request.getParameter("fileName"));
		
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		/*HttpSession session=request.getSession();
		String sessionId=String.valueOf(((ProductVO)session.getAttribute("product")).getProdNo());
	
		
		
		if(sessionId.equals(prodNo)){
			session.setAttribute("product", productVO);          
		}
		*/
		
		
		
		return "/getProduct.do?prodNo="+prodNo+"&menu=ok";
	}
}