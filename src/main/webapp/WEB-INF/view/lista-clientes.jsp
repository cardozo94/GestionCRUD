<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado de Clientes </title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css "/>
	</head>
	<body>
		Hemos llegado a la lista de futuros clientes!!!
		<table>
			<tr>
				<th>nombre</th>
				<th>apellido</th>
				<th>email</th>
			</tr>
			<c:forEach var="cliente" items="${clientes}">	
				<tr>
					<th>${cliente.nombre}</th>
					<th>${cliente.apellido}</th>
					<th>${cliente.email}</th>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>