<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<!--Definido metadatas com pre-configuracoes-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>RomCalculator</title>
<body>
	<%-- <c:import url="cabecalho.jsp" /> --%>
	<div class="container">

		<form action="/pm87-conversor/Decimal" method="post">
			<h2>Página de Numero Decimal</h2> 
			<hr>
			Numero Decimal: ${numeroDecimal} <br/> 
			
		</form>
	</div>
</body>
</html>