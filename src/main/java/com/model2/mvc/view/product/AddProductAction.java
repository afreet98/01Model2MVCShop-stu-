package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productVO=new ProductVO();
		productVO.setProdName(request.getParameter("prodName"));//상품명
		productVO.setProdDetail(request.getParameter("prodDetail"));//상품상세정보
		productVO.setManuDate(request.getParameter("manuDate"));//제조일자
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));//가격		
		productVO.setFileName(request.getParameter("fileName"));//상품이미지

		System.out.println(productVO);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(productVO);
		
		return "redirect:/product/addProductView.jsp";
		//return "redirect:/user/loginView.jsp";
	}
}