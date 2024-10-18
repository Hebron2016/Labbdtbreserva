<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sessao</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>SESSAO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="sessao" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" placeholder="#codigoSessao" id="codigoSessao" name="codigoSessao"
					value='<c:out value ="${sessao.codigoSessao }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="usuario" id="usuario" name="usuario"
					value='<c:out value ="${sessao.usuario }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="ip" id="ip" name="ip"
					value='<c:out value ="${sessao.ip }"></c:out>'>
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
		<c:if test="${not empty sessoes }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoSessao</th>
						<th>usuario</th>
						<th>ip</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sessao" items="${sessoes }">
					<tr>
						<td><c:out value="${sessao.codigoSessao }" /></td>
						<td><c:out value="${sessao.usuario }" /></td>
						<td><c:out value="${sessao.ip }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>