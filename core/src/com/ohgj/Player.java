package com.ohgj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.ohgj.gameengine.Components.Body;
import com.ohgj.gameengine.Components.BoxBody;
import com.ohgj.gameengine.Components.CircleBody;
import com.ohgj.gameengine.Components.SpriteRenderer;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.AbstractGameObject;
import com.ohgj.gameengine.Game.Game;
import com.ohgj.gameengine.Util.Keys;

public class Player extends AbstractGameObject {

    Body body;
    Vector2 vel;
    float acceleration = 0.1f, maxSpeed = 15;

    public Player(Transform transform) {
        super(transform);
        body = new BoxBody(this, 0.2f, 0.1f, BodyDef.BodyType.DynamicBody, false);
        body.getBody().setFixedRotation(true);
        addComponent(body);
        addComponent(new SpriteRenderer(this, Gdx.files.internal("player.png"), 0, 0, 0.2f, 0.1f));
        vel = new Vector2(0, 0);
        setTag("Player");
    }

    protected void update(float delta) {

        if (Keys.isKeyPressed(Input.Keys.UP) && vel.y < maxSpeed) {
            vel.y += acceleration;
        }
        if (Keys.isKeyPressed(Input.Keys.DOWN) && vel.y > -maxSpeed) {
            vel.y -= acceleration;
        }
        if (Keys.isKeyPressed(Input.Keys.RIGHT) && vel.x < maxSpeed) {
            vel.x += acceleration;
        }
        if (Keys.isKeyPressed(Input.Keys.LEFT) && vel.x > -maxSpeed) {
            vel.x -= acceleration;
        }
        body.getBody().setAwake(true);
        body.getBody().setLinearVelocity(vel);
        vel.x += -vel.x / 10;
        vel.y += -vel.y / 10;
        Game.debug(1, body.getBody().getPosition());

    }
}
