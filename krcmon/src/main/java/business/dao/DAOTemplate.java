/**
 * クラス名：	OrderControlDBAccess
 * 概要　　：	DBアクセス用スーパークラス
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package business.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOTemplate {

	protected Connection createConnection() {

		Connection con = null;

		try {
			// JDBCドライバをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DBMSとの接続を確立
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KRCMON", "webapp", "webapp");
			return con;

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
