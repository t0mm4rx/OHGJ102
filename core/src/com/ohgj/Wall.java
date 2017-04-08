package com.ohgj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.ohgj.gameengine.Components.Body;
import com.ohgj.gameengine.Components.BoxBody;
import com.ohgj.gameengine.Components.SpriteRenderer;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.AbstractGameObject;

public class Wall extends AbstractGameObject{

    Body body;

    public Wall(Transform transform, float width, float height) {
        super(transform);
        body = new BoxBody(this, width, height, BodyDef.BodyType.StaticBody, false);
        addComponent(body);
        addComponent(new SpriteRenderer(this, Gdx.files.internal("wall.jpg"), 0, 0, width, height));
    }

    protected void update(float delta) {

    }

}
