package mapManager;

public class Cell {
	
	//private enum references {DOOR, WALL, FLOOR, PLAYER, ENEMY, ITEM};
	private String reference;
	
	public Cell() {
		reference = new String();
		reference = " ";
	}
	
	public void setReference (String ref) {
		switch (ref) {
			case "FLOOR":
				this.reference = "# ";
				break;
			case "WALL":
				this.reference = ". ";
				break;
			case "DOOR":
				this.reference = "D ";
				break;
			case "PLAYER":
				this.reference = "@ ";
				break;
		}
	}
	
	public String getReference () {
		return reference;
	}
	
}
