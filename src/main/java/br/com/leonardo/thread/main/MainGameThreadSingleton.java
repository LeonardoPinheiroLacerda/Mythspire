package br.com.leonardo.thread.main;

public abstract class MainGameThreadSingleton {
    private final static MainGameThread INSTANCE = new MainGameThread();
    public static MainGameThread getInstance() {
        return INSTANCE;
    }
}
