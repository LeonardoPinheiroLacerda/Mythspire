package br.com.leonardo.util;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;

public class CoordinatesUtils {

    private final static GameContext gameContext = GameContextSingleton.getInstance();

    public static int getYFromCoordinates(int y) {
        return y * gameContext.getTileSize() - gameContext.getPlayer().getWorldY() + gameContext.getPlayer().getScreenY();
    }

    public static int getXFromCoordinates(int x) {
        return x * gameContext.getTileSize() - gameContext.getPlayer().getWorldX() + gameContext.getPlayer().getScreenX();
    }

    public static boolean isTileInsideScreen(int screenX, int screenY) {
        final Integer screenWidth = gameContext.getScreenWidth();
        final Integer screenHeight = gameContext.getScreenHeight();
        final Integer tileSize = gameContext.getTileSize();

        final int rightLimit = tileSize * -1;
        final int topLimit = tileSize * -1;
        final int leftLimit = screenWidth;
        final int bottomLimit = screenHeight;

        return screenX > rightLimit
                && screenX < leftLimit
                && screenY > topLimit
                && screenY < bottomLimit;
    }
}
