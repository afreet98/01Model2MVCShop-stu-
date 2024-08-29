package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class GetProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service=new ProductServiceImpl();
		ProductVO po=service.getProduct(prodNo);
		
        //////////////////////////////////////////////////////////////////////////////////////////////////
        // 히스토리 쿠키 관리
        String history = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("history".equals(cookie.getName())) {
                	history = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }
        
        // 현재 상품 번호를 히스토리에 추가
        if (history == null) {
            history = Integer.toString(po.getProdNo());
        } else {
            String[] historyArray = history.split(",");
            boolean exists = false;
            for (String item : historyArray) {
                if (item.equals(Integer.toString(po.getProdNo()))) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                history = history + "," + po.getProdNo();
            }
        }
        
        // 쿠키에 업데이트된 히스토리 저장
        Cookie historyCookie = new Cookie("history", URLEncoder.encode(history, "UTF-8"));
     
        response.addCookie(historyCookie);
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		request.setAttribute("po", po);
		System.out.println(po);
		return "forward:/product/getProduct.jsp";
	}
}