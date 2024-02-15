package presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.PokemonPokedexService;
import dto.PokemonData;

// ポケモン図鑑を表示するサーブレット
@WebServlet("/pokedex")
public class PokemonPokedexServlet extends HttpServlet {

	// ポケモン図鑑のデータを提供するサービス
	private PokemonPokedexService service = new PokemonPokedexService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// サービスを通じて全ポケモンのリストを取得し、リクエスト属性に設定
		List<PokemonData> list = service.findAll();
		request.setAttribute("pokeList", list);

		// ポケモン図鑑のビューにフォワード
		String view = "/WEB-INF/view/pokedex.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
