package br.com.leonardo.map;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.entity.Player;
import br.com.leonardo.map.tile.Tile;
import br.com.leonardo.map.tile.TileManager;
import br.com.leonardo.service.loader.ResourceLoaderService;
import lombok.Getter;

import java.awt.*;
import java.util.Arrays;

public class Map {

    private final GameContext gameContext = GameContextSingleton.getInstance();

    @Getter
    private final Tile[][] tiles;
    private final String SEPARATOR = " ";

    public Map(String mapPath) {
        final ResourceLoaderService resourceLoaderService = new ResourceLoaderService();
        this.tiles = resourceLoaderService.consumeFile(mapPath,
                reader -> reader
                        .lines()
                        .map(line -> line.split(SEPARATOR))
                        .map(line ->
                                Arrays.stream(line)
                                        .map(TileManager::findTileById)
                                        .toArray(Tile[]::new)
                        )
                        .toArray(Tile[][]::new)
        );
    }

    //The map will be rendered around player's position, where the player ALWAYS will be centered.
    public void draw(Graphics2D graphics2D) {
        final Integer tileSize = gameContext.getTileSize();

        for (int rowIndex = 0; rowIndex < this.tiles.length; rowIndex++) {
            final Tile[] row = this.tiles[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                final Tile column = row[columnIndex];

                final int screenX = getScreenXCoordinate(columnIndex);
                final int screenY = getScreenYCoordinate(rowIndex);

                if (isTileInsideScreen(screenX, screenY)) {
                    graphics2D.drawImage(column.getTile(), screenX, screenY, tileSize, tileSize, null);
                    if(column.isCollisionable()){
//                        graphics2D.setColor(new Color(255, 0, 0, 200));
//                        graphics2D.fillRect(screenX, screenY, tileSize, tileSize);
//                        graphics2D.setColor(new Color(255, 0, 0));
//                        graphics2D.drawRect(screenX, screenY, tileSize, tileSize);
                    }
                }

            }
        }
    }

    private boolean isTileInsideScreen(int screenX, int screenY) {
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

    private int getScreenXCoordinate(int columnIndex) {
        final Player player = gameContext.getPlayer();
        final Integer tileSize = gameContext.getTileSize();

        final int worldX = columnIndex * tileSize;
        return worldX - player.getWorldX() + player.getScreenX();
    }

    private int getScreenYCoordinate(int rowIndex) {
        final Player player = gameContext.getPlayer();
        final Integer tileSize = gameContext.getTileSize();

        final int worldY = rowIndex * tileSize;
        return worldY - player.getWorldY() + player.getScreenY();
    }

    public Tile getTileFromWorldCoordinates(Integer screenX, Integer screenY) {
        int x = screenX / gameContext.getTileSize();
        int y = screenY / gameContext.getTileSize();
        return this.tiles[y][x];
    }

}
