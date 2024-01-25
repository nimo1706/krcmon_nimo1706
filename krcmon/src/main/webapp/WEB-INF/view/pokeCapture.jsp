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
%>
<body>
	<div id="root">
		<div class="navBody" id="refindex">
			<h3>ポケモンパーク</h3>
		</div>
		<div class="App">

			<h2>捕まえました！</h2>
			<img src="<%=pokeData.getImgPath()%>" class="centeredImage">
			<h3 class="cardNames"><%=pokeData.getName()%></h3>

			<form method="post" action="capture">
				ニックネーム： <input type="text" name="nickName" value="<%=pokeData.getName()%>" class="intext">
				<input type="submit" value="図鑑に登録" class="button">
			</form>

			<form method="get" action="search">
				<input type="submit" value="逃がす" class="button">
			</form>

		</div>
	</div>
	<script src="./assets/script.js"></script>
</body>
</html>
