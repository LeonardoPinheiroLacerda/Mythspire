package br.com.leonardo.rendering;

import br.com.leonardo.context.GameContext;
import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.object.WorldObject;
import br.com.leonardo.service.DeltaBasedFpsDelimiterService;
import br.com.leonardo.thread.main.MainGameThreadSingleton;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class Scene extends JPanel {

    private final GameContext gameContext = GameContextSingleton.getInstance();

    public Scene() {
        this.setPreferredSize(new Dimension(gameContext.getScreenWidth(), gameContext.getScreenHeight()));
        this.setBackground(Color.BLACK);

        // This improves the rendering performance
        this.setDoubleBuffered(true);

        this.addKeyListener(gameContext.getKeyHandler());

        //With this the GamePanel can be "focused" to receive key input
        this.setFocusable(true);
    }

    protected void startScene() {
        MainGameThreadSingleton.getInstance()
                .builder()
                .gameScene(this)
                .build()
                .start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //This class extends Graphics and provides more sophisticated control over things we will need
        Graphics2D graphics2D = (Graphics2D) g;

        gameContext.getMap().draw(graphics2D);

        gameContext.getObjects()
                .forEach(worldObject -> worldObject.draw(graphics2D));

        gameContext.getPlayer().draw(graphics2D);

        DeltaBasedFpsDelimiterService.showFps(graphics2D);

        //Dispose of this graphics context and release any system resources that it is using
        graphics2D.dispose();
    }


}
