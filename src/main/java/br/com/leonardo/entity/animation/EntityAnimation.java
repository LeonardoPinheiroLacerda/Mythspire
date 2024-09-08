package br.com.leonardo.entity.animation;

import br.com.leonardo.entity.Entity;
import lombok.RequiredArgsConstructor;

import java.awt.image.BufferedImage;

@RequiredArgsConstructor
public class EntityAnimation {

    private final Entity entity;

    private final Animation idleLookingDownAnimation;
    private final Animation idleLookingUpAnimation;
    private final Animation idleLookingLeftAnimation;
    private final Animation idleLookingRightAnimation;

    private final Animation walkingDownAnimation;
    private final Animation walkingUpAnimation;
    private final Animation walkingLeftAnimation;
    private final Animation walkingRightAnimation;
    private Animation lastActiveAnimation;

    public BufferedImage getSprite() {
        Animation actualAnimation = null;

        if (entity.isIdle()) {
            actualAnimation = switch (entity.getDirection()){
                case UP -> idleLookingUpAnimation;
                case DOWN -> idleLookingDownAnimation;
                case LEFT -> idleLookingLeftAnimation;
                case RIGHT -> idleLookingRightAnimation;
            };
        }else {
            actualAnimation = switch (entity.getDirection()){
                case UP -> walkingUpAnimation;
                case DOWN -> walkingDownAnimation;
                case LEFT -> walkingLeftAnimation;
                case RIGHT -> walkingRightAnimation;
            };
        }

        if(actualAnimation != lastActiveAnimation){
            actualAnimation.resetAnimation();
            lastActiveAnimation = actualAnimation;
        }

        return actualAnimation.nextSprite();
    }


}
