package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.PokemonSearchService;
import dto.PokemonData;

// ポケモン検索サーブレット
@WebServlet("/search")
public class PokemonSearchServlet extends HttpServlet {

	// ポケモン検索サービス
	private PokemonSearchService service = new PokemonSearchService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションを取得（存在しなければ新規作成）
		HttpSession session = request.getSession(true);
		// 既存のポケモンデータをセッションから削除
		session.removeAttribute("pokeData");

		// ポケモン検索画面にフォワードする
		String view = "/WEB-INF/view/pokeSearch.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 日本語パラメータの文字コード対応
		request.setCharacterEncoding("UTF-8");
		// リクエストからポケモンの日本名を取得
		String japaneseName = request.getParameter("name");

		// セッションを取得（存在しなければ新規作成）
		HttpSession session = request.getSession(true);
		// 既存のポケモンデータをセッションから削除
		session.removeAttribute("pokeData");

		// ポケモンデータを検索
		PokemonData pokeData = service.fetchPokemonData(japaneseName);

		// ポケモンデータが見つかった場合
		if (pokeData != null) {
			// セッションにポケモンデータを設定
			session.setAttribute("pokeData", pokeData);
		} else {
			// エラーメッセージをリクエストに設定
			request.setAttribute("error", "ポケモンと出会えなかった、、、");
		}

		// ポケモン検索画面にフォワードする
		String view = "/WEB-INF/view/pokeSearch.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
