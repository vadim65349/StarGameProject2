package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.MenuScreen;

public class StarGame extends Game {

	
	@Override
	public void create () {
		setScreen(new MenuScreen());
	}
}
