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

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td>10033</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td>user07</td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		
			현금구매
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td>SCOTT</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td>null</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td>sdf</td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td>safa</td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td>2024-08-15</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>