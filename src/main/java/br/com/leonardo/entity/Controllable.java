package br.com.leonardo.entity;

import br.com.leonardo.entity.collision.EntityCollisionChecker;
import br.com.leonardo.entity.enumarate.Direction;
import br.com.leonardo.keys.KeyHandler;

public abstract class Controllable extends Entity {

    protected final KeyHandler keyHandler;


    protected Controllable(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    @Override
    public void update() {

        if (this.keyHandler.isDiagonalKeysPressed())
            setSpeed((float) (getSpeed() / Math.sqrt(2)));

        if (this.keyHandler.isUpPressed()
                && entityCollisionChecker.checkCollision(Direction.UP)
        ) {
            this.moveUp();
        }
        if (this.keyHandler.isDownPressed()
                && entityCollisionChecker.checkCollision(Direction.DOWN)
        ) {
            this.moveDown();
        }
        if (this.keyHandler.isRightPressed()
                && entityCollisionChecker.checkCollision(Direction.RIGHT)
        ) {
            this.moveRight();
        }
        if (this.keyHandler.isLeftPressed()
                && entityCollisionChecker.checkCollision(Direction.LEFT)
        ) {
            this.moveLeft();
        }

        if (this.keyHandler.isDiagonalKeysPressed())
            setSpeed((float) (getSpeed() * Math.sqrt(2)));

        idle = keyHandler.isIdle();
    }
}
