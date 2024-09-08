package br.com.leonardo.config;

import br.com.leonardo.entity.animation.Animation;
import br.com.leonardo.service.loader.ResourceLoaderService;
import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.util.List;

@Slf4j
public record AnimationConfig(List<String> spritePath) {
    public Animation toAnimation(){
        final ResourceLoaderService resourceLoaderService = new ResourceLoaderService();
        List<BufferedImage> sprites = spritePath.stream()
                .map(resourceLoaderService::loadImage)
                .toList();
        return new Animation(sprites);
    }
}
