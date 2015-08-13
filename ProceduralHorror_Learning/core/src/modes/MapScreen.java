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
	private Player player;
	
	public MapScreen (ProceduralHorror game) {
		this.game = game;
		map = new StringBuilder();
		mapCells = new MapMaker();
		this.player = new Player();
		
		mapCells.createMap(10, this.player);
		// Convert cells to String and build what needs to be printed
		map = mapCells.mapToStringBuilder();
	}
	
	@Override
	public void show() {
		text = new TextComunicator(new SpriteBatch(), new BitmapFont(Gdx.files.internal("Fonts/proggy.fnt")));
		text.newText(map.toString(), 30, 460, Gdx.graphics.getWidth() - 100f, false, false);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			mapCells.createMap(10, this.player);
			map = new StringBuilder();
			map = mapCells.mapToStringBuilder();
			text.newText(map.toString(), 30, 460, Gdx.graphics.getWidth() - 100f, false, false);
		}
		text.draw();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			game.setScreen(game.titleScreen);
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
