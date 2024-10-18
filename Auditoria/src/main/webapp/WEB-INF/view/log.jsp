<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>LOG</h1>
	</div>
	<br />
	<div align = "center">
		<form action="log" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigoLog" name="codigoLog"
					value='<c:out value ="${log.codigoLog }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Mensagem" id="mensagem" name="mensagem"
					value='<c:out value ="${log.mensagem }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="number" step="1" min="0" placeholder="codigoSessao" id="sessaoCodigoSessao" name="sessaoCodigoSessao"
					value='<c:out value ="${log.sessaoCodigoSessao }"></c:out>'>
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
		<c:if test="${not empty logs }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoLog</th>
						<th>mensagem</th>
						<th>sessaoCodigoSessao</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="log" items="${logs }">
					<tr>
						<td><c:out value="${log.codigoLog }" /></td>
						<td><c:out value="${log.mensagem }" /></td>
						<td><c:out value="${log.sessaoCodigoSessao }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>