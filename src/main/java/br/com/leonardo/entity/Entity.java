package br.com.leonardo.entity;

import br.com.leonardo.entity.collision.EntityCollisionChecker;
import br.com.leonardo.entity.enumarate.Direction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class Entity {

    //Attributes
    private Float worldX;
    private Float worldY;
    private Float speed;

    private Rectangle collisionArea;
    private Boolean hasCollision = false;

    protected Direction direction = Direction.DOWN;
    @Getter
    protected boolean idle = true;

    protected final EntityCollisionChecker entityCollisionChecker = new EntityCollisionChecker();

    public Integer getWorldX() {
        return Math.round(this.worldX);
    }
    public Integer getWorldY() {
        return Math.round(this.worldY);
    }

    protected void moveUp(){
        this.worldY -= speed;
        this.direction = Direction.UP;
    }
    protected void moveDown(){
        this.worldY += speed;
        this.direction = Direction.DOWN;
    }
    protected void moveLeft(){
        this.worldX -= speed;
        this.direction = Direction.LEFT;
    }
    protected void moveRight(){
        this.worldX += speed;
        this.direction = Direction.RIGHT;
    }

    abstract public void update();

    abstract public void draw(Graphics2D graphics2D);
}
