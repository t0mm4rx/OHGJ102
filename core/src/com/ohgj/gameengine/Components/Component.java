package com.ohgj.gameengine.Components;

import com.ohgj.gameengine.Game.AbstractGameObject;
import com.ohgj.gameengine.Game.Drawable;

public abstract class Component extends Drawable {

   protected float offsetX, offsetY;

   private AbstractGameObject go;

   public Component (AbstractGameObject go) {
      this.go = go;
      offsetX = 0;
      offsetY = 0;
   }

   protected AbstractGameObject getGameObject(){
      return go;
   }

   public abstract void update();

   public abstract void dispose();

   public void setOffset(float x, float y) {
      offsetX = x;
      offsetY = y;
   }

   public float getOffsetY() {
      return offsetY;
   }

   public float getOffsetX() {
      return offsetX;
   }

}
