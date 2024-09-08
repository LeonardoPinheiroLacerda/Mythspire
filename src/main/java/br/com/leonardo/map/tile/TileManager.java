package br.com.leonardo.map.tile;

import br.com.leonardo.config.TileManagerConfig;
import br.com.leonardo.service.loader.ResourceLoaderService;

import java.util.HashMap;
import java.util.Map;

public class TileManager {

    private static final Map<String, Tile> managedTiles = new HashMap<>();

    static {
        final ResourceLoaderService resourceLoaderService = new ResourceLoaderService();
        TileManagerConfig tileManagerConfig = resourceLoaderService
                .readConfig("configs/tiles/tiles.yaml", TileManagerConfig.class);
        tileManagerConfig.addTileToContext(managedTiles);
    }

    public static Tile findTileById(String id) {
        return managedTiles.get(id);
    }

}
