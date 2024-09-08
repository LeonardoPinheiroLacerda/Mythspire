package br.com.leonardo.entity.animation;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
    private final List<BufferedImage> sprites;
    private final Integer animationSize;
    private Integer frameIndex = 0;
    private final Long intervalBetweenFrames = 1000L / 10; // 10 per second
    private Long lastChangeOfFrameTimestamp = System.currentTimeMillis();

    public Animation(List<BufferedImage> sprites){
        this.sprites = sprites;
        this.animationSize = sprites.size();
    }

    public BufferedImage nextSprite() {

        if(System.currentTimeMillis() - lastChangeOfFrameTimestamp >= intervalBetweenFrames){
            lastChangeOfFrameTimestamp = System.currentTimeMillis();
        }else{
            return sprites.get(frameIndex);
        }

        BufferedImage sprite = sprites.get(frameIndex);

        frameIndex = frameIndex + 1 == animationSize
                ? 0
                : frameIndex + 1;

        return sprite;
    }

    public void resetAnimation() {
        frameIndex = 0;
    }

}
