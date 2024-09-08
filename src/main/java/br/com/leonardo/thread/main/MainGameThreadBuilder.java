package br.com.leonardo.thread.main;

import br.com.leonardo.rendering.Scene;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainGameThreadBuilder {
    private final MainGameThread mainGameThread;

    public MainGameThreadBuilder gameScene(Scene scene) {
        this.mainGameThread.setScene(scene);
        return this;
    }

    public MainGameThread build(){
        return this.mainGameThread;
    }

}
