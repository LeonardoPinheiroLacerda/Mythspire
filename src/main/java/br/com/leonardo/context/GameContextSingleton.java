package br.com.leonardo.context;

public class GameContextSingleton {

    private final static GameContext INSTANCE = new GameContext();

    static {
        INSTANCE.initializeContext();
    }

    public static GameContext getInstance(){
        return INSTANCE;
    }

}
