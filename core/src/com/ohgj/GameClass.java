package com.ohgj;

import com.ohgj.gameengine.Game.Game;

public class GameClass extends Game {

	public void init() {
		setScreen(new GameScreen(this));
	}
}
