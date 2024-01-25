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
			<form method="post" action="search">
				<input type="text" name="name" placeholder="探したいポケモンの名前を入力してね" class="intext">
				<input type="submit" value="探す" class="button">
			</form>
			<%
				if (pokeData != null) {
				%>
			<img src="<%=pokeData.getImgPath()%>" class="centeredImage">
			<h3 class="cardNames"><%=pokeData.getName()%></h3>
			<%=pokeData.getFlavortext()%>

			<form method="get" action="capture">
				<input type="submit" value="捕まえる" class="button">
			</form>
			<%
				}else if(errorMessage != null){
					%>
				<%= errorMessage%>
			<%
				}
				%>

		</div>
	</div>
	<script src="./assets/script.js"></script>
</body>
</html>
