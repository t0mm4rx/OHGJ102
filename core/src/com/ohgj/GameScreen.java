package com.ohgj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.ohgj.gameengine.Components.SpriteRenderer;
import com.ohgj.gameengine.Components.Text;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.Game;
import com.ohgj.gameengine.Game.GameObject;
import com.ohgj.gameengine.Game.Screen;
import com.ohgj.gameengine.Util.MapInterface;
import com.ohgj.gameengine.Util.MapReader;

public class GameScreen extends Screen {

    public GameScreen(Game game) {
        super(game);
        lastUpadate = System.currentTimeMillis();
    }

    Player p;
    GameObject timer;
    int timerValue = 30;
    long lastUpadate;

    public void show() {
        world.setGravity(new Vector2(0, 0));
        //Game.debugging = true;
        p = new Player(new Transform(Game.center));
        add(p);

        MapReader.parse(Gdx.files.internal("map1.png"), 50, new MapInterface() {
            public void onPixel(Color color, float x, float y) {
                if (color.r == 0) {
                    add(new Wall(new Transform(new Vector2(x, y)), 0.5f, 0.5f));
                }
                if (color.r > 0.5f) {
                    System.out.println("Adding ");
                    add(new Finish(new Transform(new Vector2(x, y))));
                }
            }
        });


        timer = new GameObject(new Transform(new Vector2(10.3f, 6.4f)));
        timer.addComponent(new SpriteRenderer(timer, Gdx.files.internal("hud2.png"), -8.5f / 2, -6.4f / 2));
        timer.addComponent(new Text(timer, timerValue + " seconds remaining", Color.WHITE));
        add(timer);

        GameObject background = new GameObject(new Transform(Game.center));
        background.addComponent(new SpriteRenderer(background, Gdx.files.internal("background.jpeg"), 0, 0, 1280 / 100, 720 / 100));
        add(background);
        background.setLayout(-1);

    }

    public void update() {
        if (System.currentTimeMillis() - lastUpadate >= 1000) {
            if (timerValue > 0) {
                timerValue--;
                ((Text) timer.getComponentByClass("Text")).setText(timerValue + " seconds remaining");
            } else {
                setScreen(new GameOver(game));
            }
            lastUpadate = System.currentTimeMillis();
        }
    }

}
