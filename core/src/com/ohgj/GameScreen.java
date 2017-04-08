package com.ohgj;

import com.badlogic.gdx.graphics.Color;

import com.ohgj.gameengine.Components.Text;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.Game;
import com.ohgj.gameengine.Game.GameObject;
import com.ohgj.gameengine.Game.Screen;

public class GameScreen extends Screen {

    GameObject text;

    public GameScreen(Game game) {
        super(game);
    }

    public void show() {
        text = new GameObject(new Transform(Game.center));
        text.addComponent(new Text(text, "Test !", Color.WHITE));
        add(text);
    }

    public void update() {

    }

}
