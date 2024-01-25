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

	// ポケモン図鑑テーブルの全件取得するメソッド
	public List<DB_POKEDEX> findAll() {

	}

	// ポケモン図鑑テーブルのIDの最大値を返す
	public int getMaxId() {


}
