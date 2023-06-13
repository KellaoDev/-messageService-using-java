<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html lang="pt-br">

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="./Style/index.css">
			<title>Mensageria</title>
		</head>

		<body>
			<header>
				<h1>Serviço de Mensageria</h1>
				<hr>
				<p>Formulário para envio de e-mails</p>
			</header>
			<main>
				<form action="mensageria" method="post">
					<div>
						<label for="usuarios">E-mail:</label> 
						<select name="email" id="usuarios" required>
							<option value=""></option>
							<c:forEach items="${listaDeUsuario}" var="usu">
								<option value="${usu.email}">${usu.email}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="radio" name="valorCumprimento" value="cumprimentoFormal" id="valorRadio">
						<label for="valorRadio">Cumprimento Formal</label>
						<input type="radio" name="valorCumprimento" value="cumprimentoHorario" id="valorRadio">
						<label for="valorRadio">Cumprimento conforme horário</label>
					</div>
					<div>
						<input type="checkbox" name="valorCheckbox" id="valorCheckbox">
						<label for="valorCheckbox">Incluir aviso de "E-mail automático"</label>
					</div>
					<div>
						<label for="valorTitulo">Título:</label>
						<input type="text" name="valorTitulo" id="valorTitulo" required>
					</div>
					<div>					
					<label for="valorTexto">Texto</label>
					</div>
					<div>
						<input type="text" name="valorTexto" id="valorTexto" required>
					</div>
					<button type="submit" id="button01">Entrar</button>
					<button type="button" id="button02">Voltar</button>
				</form>		
			</main>
		</body>
		</html>