package br.com.leonardo.config;

import br.com.leonardo.map.tile.Tile;

import java.util.Map;
import java.util.Set;

public record TileManagerConfig(
        Set<TileConfig> tiles
) {

    public void addTileToContext(Map<String, Tile> managedTiles){
        tiles.forEach(tile -> {
            managedTiles.put(tile.id(), tile.toTile());
        });
    }

}
