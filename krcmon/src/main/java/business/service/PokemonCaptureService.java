package business.service;

import business.dao.PokedexDao;
import dto.DB_POKEDEX;
import dto.PokemonData;

// ポケモン捕獲処理を行うサービス
public class PokemonCaptureService {

	private PokedexDao dao = new PokedexDao();

	// ポケモン図鑑テーブルにデータをインサートするメソッド
	public int capture(PokemonData pokeDate) {

		DB_POKEDEX poke = new DB_POKEDEX(dao.getMaxId()+1,pokeDate.getName(),pokeDate.getFlavortext(),pokeDate.getImgPath(),pokeDate.getNickName());
		
		return dao.insert(poke);
		
	}
		
}
