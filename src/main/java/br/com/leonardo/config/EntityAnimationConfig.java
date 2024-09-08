package br.com.leonardo.config;

import br.com.leonardo.entity.Entity;
import br.com.leonardo.entity.animation.EntityAnimation;

public record EntityAnimationConfig(
         AnimationConfig idleLookingDownAnimation,
         AnimationConfig idleLookingUpAnimation,
         AnimationConfig idleLookingLeftAnimation,
         AnimationConfig idleLookingRightAnimation,
         AnimationConfig walkingDownAnimation,
         AnimationConfig walkingUpAnimation,
         AnimationConfig walkingLeftAnimation,
         AnimationConfig walkingRightAnimation
) {

    public EntityAnimation toLivingBeingAnimation(Entity entity) {
        return new EntityAnimation(
                entity,
                this.idleLookingDownAnimation().toAnimation(),
                this.idleLookingUpAnimation().toAnimation(),
                this.idleLookingLeftAnimation().toAnimation(),
                this.idleLookingRightAnimation().toAnimation(),
                this.walkingDownAnimation().toAnimation(),
                this.walkingUpAnimation().toAnimation(),
                this.walkingLeftAnimation().toAnimation(),
                this.walkingRightAnimation().toAnimation()
        );
    }

}
