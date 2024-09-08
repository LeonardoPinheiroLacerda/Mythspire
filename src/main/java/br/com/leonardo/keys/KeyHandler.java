package br.com.leonardo.keys;

import lombok.Getter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
public class KeyHandler implements KeyListener {

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updatePressedStates(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updatePressedStates(e, false);
    }

    public Boolean isDiagonalKeysPressed() {
        return upPressed && rightPressed ||
                upPressed && leftPressed ||
                downPressed && rightPressed ||
                downPressed && leftPressed;
    }

    public Boolean isIdle() {
        return !upPressed && !downPressed && !leftPressed && !rightPressed;
    }

    private void updatePressedStates(KeyEvent e, Boolean newState) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            leftPressed = newState;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = newState;
        }
        if (code == KeyEvent.VK_W) {
            upPressed = newState;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = newState;
        }
    }
}
