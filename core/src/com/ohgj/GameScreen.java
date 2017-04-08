package com.ohgj;

import com.badlogic.gdx.math.Vector2;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.Game;
import com.ohgj.gameengine.Game.Screen;

public class GameScreen extends Screen {

    public GameScreen(Game game) {
        super(game);
    }

    Player p;
    Wall b;

    public void show() {
        world.setGravity(new Vector2(0, 0));
        Game.debugging = true;
        p = new Player(new Transform(Game.center));
        add(p);

        b = new Wall(new Transform(new Vector2(4, 2)), 1, 1);
        add(b);

    }

    public void update() {

    }

}
