package mapManager;

public class Cell {
	
	private boolean wall, player;
	private String reference;
	
	public Cell() {
		reference = new String();
		this.wall = false;
		this.player = false;
		reference = " ";
	}
	
	public boolean getWall() {
		return wall;
	}
	
	public void setWall(boolean wall, boolean player) {
		this.wall = wall;
		this.player = player;
		
		if (wall && !player) {
			reference = ". ";
		} else {
			if(!player) {
				reference = "# ";
			}
		}
		
		if(player) {
			reference = "P ";
		}
	}
	
	public String getReference () {
		return reference;
	}
	
}
