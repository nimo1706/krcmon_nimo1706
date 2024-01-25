<%@page contentType="text/html; charset=UTF-8"%>

<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ポケパーク</title>
<link rel="stylesheet" href="./assets/styles.css">
</head>
<%
List<PokemonData> pokeList = (List<PokemonData>) request.getAttribute("pokeList");
%>

<body>
	<div id="root">
		<div class="navBody" id="refindex">
			<h3>ポケモンパーク</h3>
		</div>
		<div class="App">
			<div class="pokemonCardContainer">
				<%
				if (pokeList != null) {
				%>
				<%
				for (PokemonData date : pokeList) {
				%>
				<div class="card">
					<div class="cardImg">
						<img src="<%=date.getImgPath()%>" alt="">
					</div>
					<h3 class="cardNames">
						nickname:<%=date.getNickName()%></h3>
					<h4 class="cardNames">
						name<%=date.getName()%></h4>
				</div>
				<%
				}
				%>
				<%
				}
				%>
			</div>
			<form action="search" method="get">
				<input type="submit" value="ポケモンを探しに行く" class="button">
			</form>
		</div>
	</div>
	</div>

	<script src="./assets/script.js"></script>
</body>
</html>
