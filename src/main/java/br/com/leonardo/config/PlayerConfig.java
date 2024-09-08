package br.com.leonardo.config;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.entity.Player;

public record PlayerConfig(
        EntityAnimationConfig animations,
        PositionConfig defaultPosition,
        Float speed
) {

    public void enrichPlayer(Player player) {
        final GameContext gameContext = GameContextSingleton.getInstance();
        final Integer tileSize = gameContext.getTileSize();

        player.setSpeed(speed);
        player.setWorldX(tileSize * defaultPosition.x());
        player.setWorldY(tileSize * defaultPosition.y());
        player.setEntityAnimation(animations.toLivingBeingAnimation(player));
    }
}
