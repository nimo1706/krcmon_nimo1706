package business.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.PokemonData;

// ポケモンのデータ検索サービス
public class PokemonSearchService {

	private static final String API_PATH = "https://pokeapi.co/api/v2/";
	private JsonNode translationJson;

	// コンストラクタ
	public PokemonSearchService() {
		// ローカルのJSONファイルから日本語名と英語名のマッピングを読み込む
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("pokemon.json")) {
			ObjectMapper mapper = new ObjectMapper();
			translationJson = mapper.readTree(is);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 指定された日本語のポケモン名からデータを検索するメソッド
	public PokemonData fetchPokemonData(String japaneseName) throws IOException {
		PokemonData pokeData = null;
		// 日本語名を英語名に翻訳
		String englishName = translateName(japaneseName);

		if (!englishName.isEmpty()) {
			// ポケモンの種別と基本情報のURLを構築
			String speciesUrl = API_PATH + "pokemon-species/" + englishName;
			String pokemonUrl = API_PATH + "pokemon/" + englishName;

			try {
				// 外部APIからJSONデータを取得
				JsonNode speciesJson = fetchJsonFromUrl(speciesUrl);
				JsonNode pokemonJson = fetchJsonFromUrl(pokemonUrl);

				// JSONデータを処理してポケモンの情報を取得
				String flavortext = processSpeciesJson(speciesJson);
				String imgPath = processPokemonJson(pokemonJson);

				// 取得した情報を元にポケモンデータを構築
				if (!flavortext.isEmpty() && !imgPath.isEmpty()) {
					pokeData = new PokemonData(japaneseName, flavortext, imgPath, "");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return pokeData;
	}

	// URLからJSONデータを取得するメソッド
	private JsonNode fetchJsonFromUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

		try (InputStream stream = urlConnection.getInputStream()) {
			return new ObjectMapper().readTree(stream);
		} finally {
			urlConnection.disconnect();
		}
	}

	// 種別JSONからフレーバーテキストを処理するメソッド
	private String processSpeciesJson(JsonNode json) {
		for (int i = 0; i < json.path("flavor_text_entries").size(); i++) {
			if (json.path("flavor_text_entries").path(i).path("language").path("name").asText().equals("ja")) {
				return json.path("flavor_text_entries").path(i).path("flavor_text").asText();
			}
		}
		return "";
	}

	// ポケモン基本情報JSONから画像パスを取得するメソッド
	private String processPokemonJson(JsonNode json) {
		return json.path("sprites").path("other").path("official-artwork").path("front_default").asText();
	}

	// 日本語名を英語名に翻訳するメソッド
	private String translateName(String japaneseName) {
		for (int i = 0; i < translationJson.size(); i++) {
			if (translationJson.path(i).path("ja").asText().equals(japaneseName)) {
				return translationJson.path(i).path("en").asText();
			}
		}
		return "";
	}
}
