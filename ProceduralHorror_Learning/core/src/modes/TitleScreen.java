package modes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.ProceduralHorror;

import textDrawSystem.IComunicator;
import textDrawSystem.TextComunicator;

public class TitleScreen implements Screen{
	
	private ProceduralHorror game;
	
	private ShapeRenderer shape;
	private SpriteBatch batch;
	private IComunicator titleTxt;
	private IComunicator playTxt;
	private IComunicator exitTxt;
	private int rectX, rectY, rectSizeX, rectSizeY;
	private int addPos, index;
	
	// Number of options on the menu
	private static final int maxIndex = 2;

	public TitleScreen (ProceduralHorror game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		rectX = 347;
		rectY = 258;
		rectSizeX = 85;
		rectSizeY = -30;
		addPos = 50;
		index = 1;
		
		titleTxt = new TextComunicator(new SpriteBatch(), new BitmapFont(Gdx.files.internal("Fonts/proggy.fnt")));
		titleTxt.newText("U M B R A", 330, 350, Gdx.graphics.getWidth() - 200f, true, true);
		
		playTxt = new TextComunicator(new SpriteBatch(), new BitmapFont(Gdx.files.internal("Fonts/proggy22.fnt")));
		playTxt.newText("Play", 370, 250, Gdx.graphics.getWidth() - 200f, false, false);
		
		exitTxt = new TextComunicator(new SpriteBatch(), new BitmapFont(Gdx.files.internal("Fonts/proggy22.fnt")));
		exitTxt.newText("Exit", 370, 200, Gdx.graphics.getWidth() - 200f, false, false);
		
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Draw texts
		titleTxt.update(delta);
		titleTxt.draw();
		//titleTxt.getInput();
		
		//playTxt.update(delta);
		playTxt.draw();
		
		//exitTxt.update(delta);
		exitTxt.draw();
		
		// Set the rect position 
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			index++;
			
			if(index > maxIndex) {
				index = 1;
				rectY += addPos * (maxIndex - 1);
			} else {
				rectY -= addPos;
			}
		} else {
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				index--;
				
				if(index < 1) {
					index = maxIndex;
					rectY -= addPos * (maxIndex - 1);
				} else {
					rectY += addPos;
				}
			}
		}
		
		// Draws the rectangle for the selection
		shape.begin(ShapeType.Line);
		shape.setColor(1, 1, 1, 1);
		shape.rect(rectX, rectY, rectSizeX, rectSizeY);
		shape.end();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			
			if(index == 1) {
				game.setScreen(game.mapScreen);
			} else {
				if(index == 2) {
					Gdx.app.exit();
				}
			}
			
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
		batch.dispose();
		shape.dispose();
		
	}

}
