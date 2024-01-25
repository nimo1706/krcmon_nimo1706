package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.PokemonCaptureService;
import dto.PokemonData;

// ポケモン捕獲処理を行うサーブレット
@WebServlet("/capture")
public class PokemonCaptureServlet extends HttpServlet {

	// ポケモン捕獲サービス
	private PokemonCaptureService service = new PokemonCaptureService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションを取得
		HttpSession session = request.getSession(false);

		// セッションがnull、またはポケモンデータがセッションにない場合
		if (session == null || session.getAttribute("pokeData") == null) {
			// メイン画面にリダイレクト
			response.sendRedirect(request.getContextPath());
		} else {
			// ポケモン捕獲画面にフォワード
			String view = "/WEB-INF/view/pokeCapture.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 日本語パラメータの文字コード対応
		request.setCharacterEncoding("UTF-8");

		// セッションからポケモンデータを取得
		HttpSession session = request.getSession(false);
		PokemonData pokeData = (PokemonData) session.getAttribute("pokeData");

		// リクエストからニックネームを取得してポケモンデータに設定
		String nickName = (String) request.getParameter("nickName");
		pokeData.setNickName(nickName);

		// ポケモン捕獲サービスを呼び出し
		service.capture(pokeData);

		// ポケモン図鑑画面にフォワード
		response.sendRedirect(request.getContextPath() + "/pokedex");
	}
}
