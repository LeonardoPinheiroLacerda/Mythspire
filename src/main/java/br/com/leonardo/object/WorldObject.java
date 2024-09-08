package br.com.leonardo.object;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.util.CoordinatesUtils;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

@AllArgsConstructor
public class WorldObject {
    private final String name;
    private Integer worldX;
    private Integer worldY;
    private BufferedImage sprite;
    private boolean collisionable;

    public void draw(Graphics2D graphics2D) {
        GameContext gameContext = GameContextSingleton.getInstance();

        int screenX = CoordinatesUtils.getXFromCoordinates(worldX);
        int screenY = CoordinatesUtils.getYFromCoordinates(worldY);

        if(CoordinatesUtils.isTileInsideScreen(screenX, screenY)){
            graphics2D.drawImage(sprite,
                    screenX,
                    screenY,
                    gameContext.getTileSize(),
                    gameContext.getTileSize(),
                    null);
        }

    }



}
