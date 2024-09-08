package br.com.leonardo.config;

import br.com.leonardo.object.WorldObject;
import br.com.leonardo.service.loader.ResourceLoaderService;

public record WorldObjectConfig(
        String name,
        Integer x,
        Integer y,
        String spritePath,
        boolean collisionable
) {

    public WorldObject toWorldObject() {
        ResourceLoaderService resourceLoaderService = new ResourceLoaderService();

        return new WorldObject(
                this.name,
                x,
                y,
                resourceLoaderService.loadImage(this.spritePath),
                collisionable
        );
    }


}
