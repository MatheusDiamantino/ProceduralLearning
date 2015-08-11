package modes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.IComunicator;
import com.mygdx.game.TextComunicator;
import com.mygdx.game.ProceduralHorror;

import mapManager.Cell;
import mapManager.MapMaker;
import playerManager.Player;

public class MapScreen implements Screen{
	
	private ProceduralHorror game;
	
	private IComunicator text;
	private StringBuilder map;
	private MapMaker mapCells;
	private Cell cells[][];
	private Player player;
	
	public MapScreen (ProceduralHorror game) {
		this.game = game;
		map = new StringBuilder();
		mapCells = new MapMaker();
		cells = mapCells.getMap();
		this.player = new Player();
	}
	
	@Override
	public void show() {
		mapCells.makeRooms(10);
		
		// Convert cells to String and build what needs to be printed
		for(Cell[] cellRow : cells) {
			for(Cell cell : cellRow) {
				map.append(cell.getReference());
			}
			map.append("\n");
		}
		
		text = new TextComunicator(new SpriteBatch(), new BitmapFont(Gdx.files.internal("Fonts/proggy.fnt")));
		text.newText(map.toString(), 30, 460, Gdx.graphics.getWidth() - 100f, false, false);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			mapCells.makeRooms(10);
			player.Spawn(mapCells.getRooms(), mapCells.getMap());
			map = new StringBuilder();
			for(Cell[] cellRow : cells) {
				for(Cell cell : cellRow) {
					map.append(cell.getReference());
				}
				map.append("\n");
			}
			text.newText(map.toString(), 30, 460, Gdx.graphics.getWidth() - 100f, false, false);
		}
		text.draw();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
