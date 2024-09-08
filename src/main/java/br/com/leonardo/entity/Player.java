package br.com.leonardo.entity;

import br.com.leonardo.config.PlayerConfig;
import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.entity.animation.EntityAnimation;
import br.com.leonardo.keys.KeyHandler;
import br.com.leonardo.service.loader.ResourceLoaderService;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
public class Player extends Controllable {

    private final GameContext gameContext = GameContextSingleton.getInstance();

    private EntityAnimation entityAnimation;

    //The player will be always at the center of the screen
    private Integer screenX = GameContextSingleton.getInstance().getScreenWidth() / 2 - (this.gameContext.getTileSize() / 2);
    private Integer screenY = GameContextSingleton.getInstance().getScreenHeight() / 2 - (this.gameContext.getTileSize() / 2);

    public Player(KeyHandler keyHandler) {
        super(keyHandler);

        final ResourceLoaderService resourceLoaderService = new ResourceLoaderService();

        PlayerConfig playerConfig = resourceLoaderService
                .readConfig("./configs/player/player.yaml", PlayerConfig.class);

        playerConfig.enrichPlayer(this);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 12;
        rectangle.y = 28;
        rectangle.width = 21;
        rectangle.height = 19;


        this.setHasCollision(true);
        this.setCollisionArea(rectangle);
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        graphics2D.drawImage(entityAnimation.getSprite(),
                screenX,
                screenY,
                this.gameContext.getTileSize(),
                this.gameContext.getTileSize(),
                null);

//        graphics2D.setColor(new Color(0, 0, 255, 200));
//        graphics2D.fillRect(screenX + this.getCollisionArea().x, screenY + this.getCollisionArea().y, this.getCollisionArea().width, this.getCollisionArea().height);
//        graphics2D.setColor(new Color(0, 0, 255));
//        graphics2D.drawRect(screenX + this.getCollisionArea().x, screenY + this.getCollisionArea().y, this.getCollisionArea().width, this.getCollisionArea().height);


    }

//    @Override
//    public void update() {
//        super.update();
////        if(getWorldX() < Scene.SCREEN_WIDTH / 2 - (Scene.TILE_SIZE / 2)) {
////            screenX = getWorldX();
////        }
////        if(getWorldY() < Scene.SCREEN_HEIGHT / 2 - (Scene.TILE_SIZE / 2)) {
////            screenY = getWorldY();
////        }
//    }
}
