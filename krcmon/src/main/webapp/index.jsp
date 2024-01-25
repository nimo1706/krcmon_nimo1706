<%@page contentType="text/html; charset=UTF-8"%>

<%@ page import="dto.*"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ポケパーク</title>
<link rel="stylesheet" href="./assets/styles.css">
</head>
<%
PokemonData pokeData = (PokemonData) session.getAttribute("pokeData");
String errorMessage = (String) request.getAttribute("error");
%>

<body>
	<div id="root">
		<div class="navBody" id="refindex">
			<h3>ポケモンパーク</h3>
		</div>
		<div class="App">

			<form method="get" action="search">
				<input type="submit" value="ポケモンを捕まえに行く" class="button">
			</form>

			<form method="get" action="pokedex">
				<input type="submit" value="捕まえたポケモンを見に行く" class="button">
			</form>

		</div>
	</div>
	<script src="./assets/script.js"></script>
</body>
</html>
