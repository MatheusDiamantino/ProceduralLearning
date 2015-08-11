package mapManager;

public class Room {
	private int centerX, centerY;
	private int sizeX, sizeY;
	
	public Room() { }
	
	public int getSizeX () { return this.sizeX; }
	
	public int getSizeY () { return this.sizeY; }
	
	public int getCenterX () { return this.centerX; }
	
	public int getCenterY () { return this.centerY; }
	
	public void setSizeX (int sizeX) { this.sizeX = sizeX; }
	
	public void setSizeY (int sizeY) { this.sizeY = sizeY; }
	
	public void setCenterX (int centerX) { this.centerX = centerX; }
	
	public void setCenterY (int centerY) { this.centerY = centerY; }
	
	public boolean intersects (Room room) {
		return ((this.getCenterX() <= room.getCenterX() + room.getSizeX()) && (room.getCenterX() <= this.getCenterX() + this.getSizeX()) && 
				(this.getCenterY() <= room.getCenterY() + room.getSizeY()) && (room.getCenterY() <= this.getCenterY() + this.getSizeY()));
	}
}
