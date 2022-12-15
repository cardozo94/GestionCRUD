<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registro</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css "/>
	</head>
	<body>
		<h1>Inserte los datos del cliente</h1>
		<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>Nombre: </td>
					<td><form:input path="nombre"/> </td>
				</tr>
				<tr>
					<td>Apellido: </td>
					<td><form:input path="apellido"/> </td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email"/> </td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Insertar"></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>