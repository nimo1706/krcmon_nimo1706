package dto;

public class PokemonData {

	String name;
	String flavortext;
	String imgPath;
	String nickName;

	public PokemonData(String name, String flavortext, String imgPath, String nickName) {
		this.name = name;
		this.flavortext = flavortext;
		this.imgPath = imgPath;
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavortext() {
		return flavortext;
	}

	public void setFlavortext(String flavortext) {
		this.flavortext = flavortext;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
