package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
	private UserVO buyer; //UserVO Ÿ���� ������ ����						������ ���̵�
	private String divyAddr; //String Ÿ���� ����� �ּ�					������ �ּ�
	private String divyDate; //String Ÿ���� ��� ��� ����				����������
	private String divyRequest; //String Ÿ���� ��۽� �䱸����			���ſ�û����
	private Date orderDate; //java.sql.Date Ÿ���� ���� ����				Date �˾Ƽ���
	private String paymentOption; //String Ÿ���� ���� ���				���Ź��        
	private ProductVO purchaseProd; //ProductVO Ÿ���� ���� ��ǰ ����		��ǰ��ȣ
	private String receiverName; //String Ÿ���� �޴»�� �̸�			������ �̸�
	private String receiverPhone; //String Ÿ���� �޴»�� ��ȭ��ȣ			�����ڿ���ó
	private String tranCode; //String Ÿ���� ���� ���� �ڵ�				���Ž� �ٲ�
	private int tranNo; //int Ÿ���� ���� ��ȣ
	
	public PurchaseVO(){
	}
	
	//UserVO Ÿ���� ������ ����
	public UserVO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserVO buyer) {
		this.buyer = buyer;
	}
	//String Ÿ���� ����� �ּ�
	public String getDivyAddr() {
		return divyAddr;
	}
	public void setDivyAddr(String divyAddr) {
		this.divyAddr = divyAddr;
	}
	//String Ÿ���� ��� ��� ����
	public String getDivyDate() {
		return divyDate;
	}
	public void setDivyDate(String divyDate) {
		this.divyDate = divyDate;
	}
	//String Ÿ���� ��۽� �䱸����
	public String getDivyRequest() {
		return divyRequest;
	}
	public void setDivyRequest(String divyRequest) {
		this.divyRequest = divyRequest;
	}
	//java.sql.Date Ÿ���� ���� ����
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	//String Ÿ���� ���� ���
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	//ProductVO Ÿ���� ���� ��ǰ ����
	public ProductVO getPurchaseProd() {
		return purchaseProd;
	}
	public void setPurchaseProd(ProductVO purchaseProd) {
		this.purchaseProd = purchaseProd;
	}
	//String Ÿ���� �޴»�� �̸�
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	//String Ÿ���� �޴»�� ��ȭ��ȣ
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	//String Ÿ���� ���� ���� �ڵ�
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	//int Ÿ���� ���� ��ȣ
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