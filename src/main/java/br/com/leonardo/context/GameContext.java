package br.com.leonardo.context;

import br.com.leonardo.config.WorldObjectsConfig;
import br.com.leonardo.entity.Player;
import br.com.leonardo.keys.KeyHandler;
import br.com.leonardo.map.Map;
import br.com.leonardo.object.WorldObject;
import br.com.leonardo.service.loader.ResourceLoaderService;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class GameContext {

    //Attributes
    private final Integer originalTileSize = 16; //16x16 tile
    private final Integer scale = 3;
    private final Integer tileSize = originalTileSize * scale; //48x48 real size tile

    private final Integer maxScreenColumn = 16;
    private final Integer maxScreenRow = 12;
    private final Integer screenWidth = tileSize * maxScreenColumn; //768 pixels
    private final Integer screenHeight = tileSize * maxScreenRow; //576 pixels

    //Dependencies
    private KeyHandler keyHandler;
    private Player player;
    private Map map;
    private Set<WorldObject> objects = new HashSet<>();

    protected GameContext(){}

    protected void initializeContext() {
        ResourceLoaderService resourceLoaderService = new ResourceLoaderService();

        this.keyHandler = new KeyHandler();
        this.player = new Player(this.keyHandler);
        this.map = new Map("maps/world01.txt");

        WorldObjectsConfig worldObjectsConfig = resourceLoaderService.readConfig(
                "configs/objects/objects.yaml",
                WorldObjectsConfig.class
        );

        worldObjectsConfig
                .objects()
                .forEach(worldObjectConfig -> {
                    objects.add(worldObjectConfig.toWorldObject());
                });
    }

}
