package playerManager;

import java.util.ArrayList;
import java.util.Random;
import mapManager.Room;

import mapManager.Cell;

public class Player {
	
	private int posX, posY;
	private Random rand;

	public Player () {
		this.rand = new Random();
		this.posX = 0;
		this.posY = 0;
		
	}
	
	public boolean Spawn (ArrayList<Room> rooms, Cell[][] map) {
		int roomIndex = rand.nextInt(rooms.size());
		Room room = rooms.get(roomIndex);
		
		posX = room.getCenterX() + rand.nextInt(room.getSizeX());
		posY = room.getCenterY() + rand.nextInt(room.getSizeY());
		
		map[posY][posX].setReference("PLAYER");
		
		return false;
	}
}
