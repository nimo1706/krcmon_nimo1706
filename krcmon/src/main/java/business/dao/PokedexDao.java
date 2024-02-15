package business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DB_POKEDEX;

public class PokedexDao extends DAOTemplate {

	// ポケモン図鑑テーブルに引数のデータをインサートするメソッド
	public int insert(DB_POKEDEX pokedex) {

		//TODO①SQLを変数に格納
		String sql = "INSERT INTO pokedex VALUES (?,?,?,?,?)";

		//TODO②DBとのconnectionの確率
		//TODO③prepareStatementの生成

		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//TODO④プレースホルダに値を設定
			pstmt.setInt(1, pokedex.getId());
			pstmt.setString(2, pokedex.getName());
			pstmt.setString(3, pokedex.getFlavortext());
			pstmt.setString(4, pokedex.getImgPath());
			pstmt.setString(5, pokedex.getNickName());

			//TODO⑤SQLの実行（戻り値:レコードの更新結果）
			//（戻り値:レコードの更新結果）

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ポケモン図鑑テーブルの全件取得するメソッド
	public List<DB_POKEDEX> findAll() {

		//TODO①SQLを変数に格納
		String sql = "SELECT * FROM krcmon.pokedex";

		//TODO②DBとのconnectionの確率
		//TODO③prepareStatementの生成

		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//TODO⑤SQLの実行
			ResultSet rs = pstmt.executeQuery();

			//TODO⑥SQLの実行結果をDTO（tweet）に格納する
			//TODO⑦ ⑥の処理を繰り返す

			List<DB_POKEDEX> list = new ArrayList<>();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String NAME = rs.getNString("NAME");
				String FLAVOR_TEXT = rs.getNString("FLAVOR_TEXT");
				String IMG_PATH = rs.getNString("IMG_PATH");
				String NICK_NAME = rs.getNString("NICK_NAME");

				list.add(new DB_POKEDEX(ID, NAME, FLAVOR_TEXT, IMG_PATH, NICK_NAME));
			}

			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// ポケモン図鑑テーブルのIDの最大値を返す
		public int getMaxId() {

			// SQLを作成
			String sql = "SELECT MAX(ID) AS MAX FROM pokedex";

			// DBとのconnection確立とpreparedStatementの生成(SQL実行準備)
			try (Connection con = createConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);) {

				// IDのMAXを取得
				ResultSet rs = pstmt.executeQuery();

				int maxId = 0;
				// 取得結果があれば
				if (rs.next()) {
					// 最大値を取得
					maxId = rs.getInt("MAX");
				}

				// 最大値
				return maxId;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
