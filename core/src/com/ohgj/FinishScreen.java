package com.ohgj;

import com.badlogic.gdx.graphics.Color;
import com.ohgj.gameengine.Components.Text;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.Game;
import com.ohgj.gameengine.Game.GameObject;
import com.ohgj.gameengine.Game.Screen;

public class FinishScreen extends Screen {
    public FinishScreen(Game game) {
        super(game);
    }

    public void update() {

    }

    public void show() {
        GameObject text = new GameObject(new Transform(Game.center));
        text.addComponent(new Text(text, "Success !", Color.WHITE));
        add(text);
        Game.waitAndDo(3, () -> {
            setScreen(new GameScreen(game));
            return  false;
        });

    }
}
