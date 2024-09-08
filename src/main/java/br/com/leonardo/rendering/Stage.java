package br.com.leonardo.rendering;

import lombok.Getter;

import javax.swing.*;

@Getter
public class Stage extends JFrame {

    private Scene scene;

    public Stage(String title) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(title);
    }

    public void start() {
        this.setVisible(true);
        this.scene.startScene();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.add(scene);

        //This will make the JFrame to be sized to fit the preferred size and layout of its subcomponents
        this.pack();
        //This makes stage open centered
        this.setLocationRelativeTo(null);
    }

}
