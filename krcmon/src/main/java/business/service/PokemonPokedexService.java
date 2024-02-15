package business.service;

import java.util.ArrayList;
import java.util.List;

import business.dao.PokedexDao;
import dto.DB_POKEDEX;
import dto.PokemonData;

// ポケモン図鑑を取得するサービス
public class PokemonPokedexService {

	private PokedexDao dao = new PokedexDao();

	// ポケモン図鑑テーブルの全件取得するメソッド
	public List<PokemonData> findAll() {

		List<PokemonData> list = new ArrayList<>();

		List<DB_POKEDEX> db_list = dao.findAll();

		for (DB_POKEDEX poke : db_list) {
			list.add(new PokemonData(poke.getName(), poke.getFlavortext(), poke.getImgPath(), poke.getNickName()));

		}

		return list;

	}
}