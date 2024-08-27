package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
	private UserVO buyer; //UserVO 타입의 구매자 정보						구매자 아이디
	private String divyAddr; //String 타입의 배송지 주소					구매자 주소
	private String divyDate; //String 타입의 배송 희망 일자				배송희망일자
	private String divyRequest; //String 타입의 배송시 요구사항			구매요청사항
	private Date orderDate; //java.sql.Date 타입의 구매 일자				Date 알아서됨
	private String paymentOption; //String 타입의 지불 방식				구매방법        
	private ProductVO purchaseProd; //ProductVO 타입의 구매 물품 정보		상품번호
	private String receiverName; //String 타입의 받는사람 이름			구매자 이름
	private String receiverPhone; //String 타입의 받는사람 전화번호			구매자연락처
	private String tranCode; //String 타입의 구매 상태 코드				구매시 바뀜
	private int tranNo; //int 타입의 구매 번호
	
	public PurchaseVO(){
	}
	
	//UserVO 타입의 구매자 정보
	public UserVO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserVO buyer) {
		this.buyer = buyer;
	}
	//String 타입의 배송지 주소
	public String getDivyAddr() {
		return divyAddr;
	}
	public void setDivyAddr(String divyAddr) {
		this.divyAddr = divyAddr;
	}
	//String 타입의 배송 희망 일자
	public String getDivyDate() {
		return divyDate;
	}
	public void setDivyDate(String divyDate) {
		this.divyDate = divyDate;
	}
	//String 타입의 배송시 요구사항
	public String getDivyRequest() {
		return divyRequest;
	}
	public void setDivyRequest(String divyRequest) {
		this.divyRequest = divyRequest;
	}
	//java.sql.Date 타입의 구매 일자
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	//String 타입의 지불 방식
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	//ProductVO 타입의 구매 물품 정보
	public ProductVO getPurchaseProd() {
		return purchaseProd;
	}
	public void setPurchaseProd(ProductVO purchaseProd) {
		this.purchaseProd = purchaseProd;
	}
	//String 타입의 받는사람 이름
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	//String 타입의 받는사람 전화번호
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	//String 타입의 구매 상태 코드
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	//int 타입의 구매 번호
	public int getTranNo() {
		return tranNo;
	}
	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}
	
	@Override
	public String toString() {
		return "PurchaseVO [buyer=" + buyer + ", divyAddr=" + divyAddr
				+ ", divyDate=" + divyDate + ", divyRequest=" + divyRequest
				+ ", orderDate=" + orderDate + ", paymentOption="
				+ paymentOption + ", purchaseProd=" + purchaseProd
				+ ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", tranCode=" + tranCode + ", tranNo="
				+ tranNo + "]";
	}
}