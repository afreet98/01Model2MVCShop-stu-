<%@ page contentType="text/html; charset=euc-kr"%>

<%@ page import="com.model2.mvc.service.purchase.vo.*" %>

<%
	PurchaseVO co = (PurchaseVO)request.getAttribute("co");

	String menu = request.getParameter("menu");
	
%>	

<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=0" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td>10033</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td>user07</td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
			���ݱ���
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td>SCOTT</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td>null</td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td>sdf</td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td>safa</td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td>2024-08-15</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>