package br.com.leonardo.service;

import lombok.Getter;

import java.awt.*;

@Getter
public class DeltaBasedFpsDelimiterService {

    private final Integer FPS = 60;
    private final Long ONE_NANO_SECOND = 1000000000L;
    private final Double DRAW_INTERVAL = (double) ONE_NANO_SECOND / FPS;

    private Double delta = 0.0;
    private Long lastDrawTime = System.nanoTime();

    private Long timer = 0L;
    private Integer drawCount = 0;

    private static Integer actualFPS;

    public void runDelimited(Runnable runnable) {
        this.incrementDelta();
        if(this.shouldDraw()){
            runnable.run();
            this.resetDelta();
        }
        this.registerFpsCount();
    }

    private void incrementDelta() {
        long currentTime = System.nanoTime();

        delta += (currentTime - lastDrawTime) / DRAW_INTERVAL;
        timer += (currentTime - lastDrawTime);
        lastDrawTime = currentTime;
    }

    private void resetDelta() {
        delta = 0.0;
        drawCount++;
    }

    private boolean shouldDraw() {
        return delta >= 1;
    }

    private void registerFpsCount() {
        if (timer >= ONE_NANO_SECOND) {
            actualFPS = drawCount;
            drawCount = 0;
            timer = 0L;
        }
    }

    public static void showFps(Graphics2D graphics2D){
        if(DeltaBasedFpsDelimiterService.actualFPS!= null){
            graphics2D.drawString("FPS: " + DeltaBasedFpsDelimiterService.actualFPS, 10, 20);
        }
    }
}
