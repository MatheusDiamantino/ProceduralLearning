package mapManager;

import java.util.ArrayList;
import java.util.Random;

import playerManager.Player;

public class MapMaker {
	
	public static final int SIZE_X = 35, SIZE_Y = 25;
	
	private ArrayList<Room> rooms;
	private Random rand;
	
	private Cell[][] cell;
	
	public MapMaker () {
		ArrayList<Room> rooms = new ArrayList<Room>();
		rand = new Random();
		this.cell = new Cell[SIZE_Y][SIZE_X];
		
		for(int y = 0; y < SIZE_Y; y++) {
			for(int x = 0; x < SIZE_X; x++) {
				this.cell[y][x] = new Cell();
				this.cell[y][x].setReference("WALL"); 
			}
		}
	}
	
	public Cell[][] getMap () {
		return this.cell;
	}
	
	// Creates all the rooms on the map
	public void createMap (int nRooms, Player player) {
		// Flag representing if the room has been created successfully or not
		boolean failed = false;
		// Clear the room array to make a hole new map
		rooms = new ArrayList<Room>();
		
		// Set all the positions to be a wall
		for(int y = 0; y < SIZE_Y; y++) {
			for(int x = 0; x < SIZE_X; x++) {
				this.cell[y][x].setReference("WALL"); 
			}
		}

		// Creates rooms with the max number given
		for(int i = 0; i < nRooms; i++) {
			failed = false;
			Room room = new Room();
			room.setSizeX(rand.nextInt(10) + 3);
			room.setSizeY(rand.nextInt(8) + 3);
			room.setCenterX(rand.nextInt(SIZE_X - room.getSizeX()) + 1);
			room.setCenterY(rand.nextInt(SIZE_Y - room.getSizeY()) + 1);
			
			for(Room roomTested : rooms) {
				if(room.intersects(roomTested)) {
					failed = true;
					break;
				}
			}
			
			if(!failed) {
				rooms.add(room);
				for(int y = room.getCenterY(); y < room.getCenterY() + room.getSizeY() && y < SIZE_Y - 1; y++) {
					for(int x = room.getCenterX(); x < room.getCenterX() + room.getSizeX() && x < SIZE_X - 1; x++) {
						this.cell[y][x].setReference("FLOOR"); 
					}
				}
			}
		}
		
		// Makes the connections between rooms
		for(int j = 0; j < rooms.size() - 1; j++ ) {
			this.makeCorridor(rooms.get(j), rooms.get(j+1));
		}
		
		player.Spawn(rooms, this.getMap());
	}
	
	// Creates a corridor between two rooms
	private void makeCorridor (Room r1, Room r2) {
		int centerX1 = (2 * r1.getCenterX() + r1.getSizeX()) / 2,
				centerY1 = (2 * r1.getCenterY() + r1.getSizeY()) / 2,
				centerX2 = (2 * r2.getCenterX() + r2.getSizeX()) / 2,
				centerY2 = (2 * r2.getCenterY() + r2.getSizeY()) / 2;
		
		for(int x = Math.min(centerX1, centerX2); x <= Math.max(centerX1, centerX2); x++ ) {
			this.cell[centerY1][x].setReference("FLOOR");
		}
		for(int y = Math.min(centerY1, centerY2); y < Math.max(centerY1, centerY2); y++ ) {
				this.cell[y][centerX2].setReference("FLOOR");
			}
	}
	
	public ArrayList<Room> getRooms () {
		return this.rooms;
	}
	
	public StringBuilder mapToStringBuilder () {
		StringBuilder map = new StringBuilder();
		
		if (cell.length != 0) {
			for(Cell[] cellRow : cell) {
				for(Cell cells : cellRow) {
					map.append(cells.getReference());
				}
			}
		}
		
		return map;
	}
	
}
