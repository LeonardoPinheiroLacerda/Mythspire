package br.com.leonardo.config;

import br.com.leonardo.map.tile.Tile;
import br.com.leonardo.service.loader.ResourceLoaderService;

public record TileConfig(
        String id,
        String tilePath,
        boolean collisionable
) {

    public Tile toTile(){
        final ResourceLoaderService resourceLoaderService = new ResourceLoaderService();
        return new Tile(resourceLoaderService.loadImage(this.tilePath), this.collisionable);
    }
}
