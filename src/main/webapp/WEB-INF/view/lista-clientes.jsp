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
		<h1>Lista de clientes</h1>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				
				<th>Editar</th>
			</tr>
			<c:forEach var="cliente" items="${clientes}">
				<c:url var="linkActualizar" value="/cliente/formularioActualizar">
					<c:param name="clienteId" value="${cliente.id}"/>
				</c:url>	
				<tr>
					<td>${cliente.nombre}</td>
					<td>${cliente.apellido}</td>
					<td>${cliente.email}</td>
					<td><a href="${linkActualizar}"><input type="button" value="Editar"/></a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<input type="button" value="Agregar Cliente" onclick="window.location.href='formularioAgregar'; return false;"/>
	</body>
</html>