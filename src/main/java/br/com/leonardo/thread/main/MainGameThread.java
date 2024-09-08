package br.com.leonardo.thread.main;

import br.com.leonardo.context.GameContextSingleton;
import br.com.leonardo.entity.Player;
import br.com.leonardo.rendering.Scene;
import br.com.leonardo.service.DeltaBasedFpsDelimiterService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter(AccessLevel.PROTECTED)
@Slf4j
public class MainGameThread extends Thread {

    //Attributes
    private Scene scene;

    //Dependencies
    private final DeltaBasedFpsDelimiterService fpsDelimiterService = new DeltaBasedFpsDelimiterService();

    protected MainGameThread() {
        this.setName("Main-game-thread");
    }

    public MainGameThreadBuilder builder() {
        return new MainGameThreadBuilder(this);
    }

    @Override
    public void run() {
        if(scene == null) {
            throw new IllegalArgumentException("To run Main-game-thread the attribute scene must not be null.");
        }

        log.info("Starting main thread");

        final Player player = GameContextSingleton.getInstance().getPlayer();

        while (this.isAlive()) {
            fpsDelimiterService.runDelimited(() -> {
                player.update();
                scene.repaint(); //this will call paintComponent method
            });
        }
    }

}
