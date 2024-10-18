<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>PAGINA</h1>
	</div>
	<br />
	<div align = "center">
		<form action="pagina" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="text" placeholder="#URL" id="url" name="url"
					value='<c:out value ="${pagina.url }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="codigoHtml" id="codigoHtml" name="codigoHtml"
					value='<c:out value ="${pagina.codigoHtml }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="TipoConteudo" id="tipoConteudo" name="tipoConteudo"
					value='<c:out value ="${pagina.tipoConteudo }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="Titulo" id="titulo" name="titulo"
					value='<c:out value ="${pagina.titulo }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="number" placeholder="LenArqBytes" id="lenArqBytes" name="lenArqBytes"
					value='<c:out value ="${pagina.lenArqBytes }"></c:out>'>
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
		<c:if test="${not empty paginas }">
			<table border="1">
				<thead>
					<tr>
						<th>#URL</th>
						<th>codigoHtml</th>
						<th>titulo</th>
						<th>tipoConteudo</th>
						<th>lenArqBytes</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pagina" items="${paginas }">
					<tr>
						<td><c:out value="${pagina.url }" /></td>
						<td><c:out value="${pagina.codigoHtml }" /></td>
						<td><c:out value="${pagina.titulo }" /></td>
						<td><c:out value="${pagina.tipoConteudo }" /></td>
						<td><c:out value="${pagina.lenArqBytes }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>