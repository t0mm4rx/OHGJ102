package com.ohgj;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.ohgj.gameengine.Collisions.CollisionsListener;
import com.ohgj.gameengine.Collisions.CollisionsManager;
import com.ohgj.gameengine.Components.Body;
import com.ohgj.gameengine.Components.BoxBody;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.AbstractGameObject;
import com.ohgj.gameengine.Game.Game;

public class Finish extends AbstractGameObject {

    Body body;

    public Finish(Transform transform) {
        super(transform);
        body = new BoxBody(this, 0.5f, 0.5f, BodyDef.BodyType.StaticBody, true);
        addComponent(body);
        setTag("Finish");
        new CollisionsManager(new CollisionsListener() {
            public void collisionEnter(AbstractGameObject a, AbstractGameObject b, Contact contact) {
                if ((a.getTag().equals("Player") && b.getTag().equals("Finish")) || (b.getTag().equals("Player") && a.getTag().equals("Finish")) ) {
                    Game.getCurrentScreen().setScreen(new FinishScreen(Game.getCurrentScreen().game));
                }
            }

            public void collisionEnd(AbstractGameObject a, AbstractGameObject b, Contact contact) {

            }
        });
    }

    protected void update(float delta) {

    }
}
