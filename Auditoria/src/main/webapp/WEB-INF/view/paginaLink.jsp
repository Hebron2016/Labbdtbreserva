<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Link</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>ASSOCIE A PAGINA AO Link</h1>
	</div>
	<br />
	<div align = "center">
		<form action="log" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#PaginaUrl" id="pagina" name="pagina"
					value='<c:out value ="${paginaLink.pagina }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="link" id="link" name="link"
					value='<c:out value ="${paginaLink.link }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="Inserir">
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
		<c:if test="${not empty requisicaoLinks }">
			<table border="1">
				<thead>
					<tr>
						<th>#link</th>
						<th>pagina</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="requisicaoLink" items="${requisicaoLinks }">
					<tr>
						<td><c:out value="${requisicaoLink.pagina }" /></td>
						<td><c:out value="${requisicaoLink.link }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>