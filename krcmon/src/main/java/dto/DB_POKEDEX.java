package dto;

public class DB_POKEDEX {

	int ID;
	String NAME;
	String FLAVOR_TEXT;
	String IMG_PATH;
	String NICK_NAME;

	public DB_POKEDEX(int id, String name, String flavortext, String imgPath, String nickName) {
		this.ID = id;
		this.NAME = name;
		this.FLAVOR_TEXT = flavortext;
		this.IMG_PATH = imgPath;
		this.NICK_NAME = nickName;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getName() {
		return NAME;
	}

	public void setName(String name) {
		this.NAME = name;
	}

	public String getFlavortext() {
		return FLAVOR_TEXT;
	}

	public void setFlavortext(String flavortext) {
		this.FLAVOR_TEXT = flavortext;
	}

	public String getImgPath() {
		return IMG_PATH;
	}

	public void setImgPath(String imgPath) {
		this.IMG_PATH = imgPath;
	}

	public String getNickName() {
		return NICK_NAME;
	}

	public void setNickName(String nickName) {
		this.NICK_NAME = nickName;
	}

}
