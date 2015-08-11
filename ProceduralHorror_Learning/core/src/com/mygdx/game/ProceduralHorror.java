package com.mygdx.game;

import modes.MapScreen;
import modes.TitleScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProceduralHorror extends Game {
	SpriteBatch batch;
	Texture img;
	
	public TitleScreen titleScreen;
	public MapScreen mapScreen;
	
	public static final String NAME = "UMBRA", VERSION = "2.0 Early Build";
	
	@Override
	public void create () {
		titleScreen = new TitleScreen(this);
		mapScreen = new MapScreen(this);		
		setScreen(titleScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
	}
	
	
}
