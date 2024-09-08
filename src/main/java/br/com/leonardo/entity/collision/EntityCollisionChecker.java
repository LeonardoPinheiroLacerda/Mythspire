package br.com.leonardo.entity.collision;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.entity.Player;
import br.com.leonardo.entity.enumarate.Direction;
import br.com.leonardo.map.Map;

public class EntityCollisionChecker {

    private final GameContext gameContext = GameContextSingleton.getInstance();

    public boolean checkCollision(Direction direction){

        // Obtém o jogador e o mapa do contexto global do jogo
        Player player = gameContext.getPlayer();
        Map map = gameContext.getMap();

        // Arredonda a velocidade do jogador
        int playerSpeed = Math.round(player.getSpeed());

        // Define os quatro pontos ao redor da área de colisão do jogador
        int left = player.getCollisionArea().x + player.getWorldX();
        int top = player.getCollisionArea().y + player.getWorldY();
        int right = player.getCollisionArea().x + player.getCollisionArea().width + player.getWorldX();
        int bottom = player.getCollisionArea().y + player.getCollisionArea().height + player.getWorldY();

        // Ajusta os pontos de colisão de acordo com a direção do movimento
        switch (direction) {
            case UP:
                top -= playerSpeed;
                break;
            case DOWN:
                bottom += playerSpeed;
                break;
            case LEFT:
                left -= playerSpeed;
                break;
            case RIGHT:
                right += playerSpeed;
                break;
        }

        // Verifica se há colisão com tiles sólidos nas coordenadas ajustadas
        return switch (direction) {
            case UP -> !map.getTileFromWorldCoordinates(left, top).isCollisionable()
                    && !map.getTileFromWorldCoordinates(right, top).isCollisionable();

            case DOWN -> !map.getTileFromWorldCoordinates(left, bottom).isCollisionable()
                    && !map.getTileFromWorldCoordinates(right, bottom).isCollisionable();

            case LEFT -> !map.getTileFromWorldCoordinates(left, top).isCollisionable()
                    && !map.getTileFromWorldCoordinates(left, bottom).isCollisionable();

            case RIGHT -> !map.getTileFromWorldCoordinates(right, top).isCollisionable()
                    && !map.getTileFromWorldCoordinates(right, bottom).isCollisionable();
        };
    }
}
