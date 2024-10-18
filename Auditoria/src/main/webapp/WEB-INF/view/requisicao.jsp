<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Requisicao</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>REQUISICAO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="requisicao" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step=1 min=0 placeholder="#Codigo" id="codigoRequisicao" name="codigoRequisicao"
					value='<c:out value ="${requisicao.codigoRequisicao }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="Http" id="http" name="http"
					value='<c:out value ="${requisicao.http }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="number" placeholder="Tempo" id="tempo" name="tempo"
					value='<c:out value ="${requisicao.tempo }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="number" placeholder="CodigoSessao" id="sessaoCodigoSessao" name="sessaoCodigoSessao"
					value='<c:out value ="${requisicao.sessaoCodigoSessao }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="URLpagina" id="paginaUrl" name="paginaUrl"
					value='<c:out value ="${requisicao.paginaUrl }"></c:out>'>
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
		<c:if test="${not empty requisicoes }">
			<table border="1">
				<thead>
					<tr>
						<th>#Codigo</th>
						<th>http</th>
						<th>tempo</th>
						<th>codigoSessao</th>
						<th>URLpagina</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="requisicao" items="${requisicoes }">
					<tr>
						<td><c:out value="${requisicao.codigoRequisicao }" /></td>
						<td><c:out value="${requisicao.http }" /></td>
						<td><c:out value="${requisicao.tempo }" /></td>
						<td><c:out value="${requisicao.sessaoCodigoSessao }" /></td>
						<td><c:out value="${requisicao.paginaUrl }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>