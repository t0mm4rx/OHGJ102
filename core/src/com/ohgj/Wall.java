package com.ohgj;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.ohgj.gameengine.Components.Body;
import com.ohgj.gameengine.Components.BoxBody;
import com.ohgj.gameengine.Components.Transform;
import com.ohgj.gameengine.Game.AbstractGameObject;

public class Wall extends AbstractGameObject{

    Body body;

    public Wall(Transform transform, float width, float height) {
        super(transform);
        body = new BoxBody(this, width, height, BodyDef.BodyType.StaticBody, false);
        addComponent(body);
    }

    protected void update(float delta) {

    }

}
