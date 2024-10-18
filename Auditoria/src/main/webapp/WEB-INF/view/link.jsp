<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Link</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>LINK</h1>
	</div>
	<br />
	<div align = "center">
		<form action="link" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigolink" name="codigoLink"
					value='<c:out value ="${link.codigoLink }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Titulo" id="titulo" name="titulo"
					value='<c:out value ="${link.titulo }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="Target" id="target" name="target"
					value='<c:out value ="${link.target }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="Inserir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Atualizar">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Excluir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Listar">
					</td>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty saida }">
			<c:out value="${saida }" />
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty erro }">
			<c:out value="${erro }" />
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty links }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoLink</th>
						<th>titulo</th>
						<th>target</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="link" items="${links }">
					<tr>
						<td><c:out value="${link.codigoLink }" /></td>
						<td><c:out value="${link.titulo }" /></td>
						<td><c:out value="${link.target }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>