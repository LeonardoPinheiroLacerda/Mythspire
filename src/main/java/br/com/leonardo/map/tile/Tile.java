package br.com.leonardo.map.tile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.awt.image.BufferedImage;

@RequiredArgsConstructor
@Getter
public class Tile {
    private final BufferedImage tile;
    private final boolean collisionable;
}
