package business.service;

import java.util.List;

import business.dao.PokedexDao;
import dto.PokemonData;

// ポケモン図鑑を取得するサービス
public class PokemonPokedexService {

	private PokedexDao dao = new PokedexDao();

	// ポケモン図鑑テーブルの全件取得するメソッド
	public List<PokemonData> findAll() {

	}

}
