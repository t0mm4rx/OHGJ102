package com.ohgj;

import fr.tommarx.gameengine.Game.Game;

public class GameClass extends Game {

	public void init() {
		setScreen(new GameScreen(this));
	}
}
