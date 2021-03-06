package com.mygdx.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.screens.GameWorld;
import com.mygdx.screens.PlayScreen;
import com.mygdx.utils.Constants;
import com.mygdx.utils.UserData;

public class CellComponent implements Component{

    private float row, col; // maze indexes

    private int type; // block type;

    private Entity bomb; // if not null this cell contains a bomb

    private Body body; // The body block (SOLID or Destructible)

    private Entity explosion; // if not null, the cell contains an explosion

    private GameWorld gameWorld; // we need a reference to the world class in order to create bodies.

    private Entity power_up; // if not null, the cell constains a power up

    public CellComponent(GameWorld gameWorld, float row, float col, float width, float height, int type){
        this.gameWorld = gameWorld;
        this. row = row;
        this.col = col;
        this.type = type;
        bomb = null;
        explosion = null;
        power_up = null;
        if(type == Constants.SOLID_BLOCK || type == Constants.DESTRUCTIBLE_BLOCK) {
            Vector2 v = gameWorld.maze_to_world_coords(col, row);
            body = gameWorld.createWallBody(v.x, v.y, width, height);
        }else
            body = null;
    }

    public float getRow() {
        return row;
    }

    public float getCol() {
        return col;
    }

    public int getType() {
        return type;
    }

    public Entity getBomb() {
        return bomb;
    }

    public Body getBody() {
        return body;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setBomb(Entity bomb) {
        this.bomb = bomb;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setExplosion(Entity explosion){
        this.explosion = explosion;
    }

    public Entity getExplosion() {
        return explosion;
    }

    public void setPower_up(Entity power_up) {
        this.power_up = power_up;
    }

    public Entity getPower_up() {
        return power_up;
    }
}
