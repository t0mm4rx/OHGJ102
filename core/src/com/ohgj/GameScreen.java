package com.ohgj;

import com.badlogic.gdx.graphics.Color;

import fr.tommarx.gameengine.Components.Text;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Game.GameObject;
import fr.tommarx.gameengine.Game.Screen;

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
