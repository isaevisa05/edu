import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main implements NativeKeyListener {

    private boolean isCtrlPressed = false;
    private int send = 0;

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if(e.getKeyCode() == 29) isCtrlPressed = true;
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        if(e.getKeyCode() != 29) return;
        isCtrlPressed = false;
        switch (send) {
            case 113:
                print();
                return;
            default:
                return;
        }
    }

    private void print() {
        new Thread(() -> {
            Robot robot;
            try {
                robot = new Robot();
                char[] chars = new char[14];
                chars[0] = 'P';
                chars[1] = 'R';
                chars[2] = 'I';
                chars[3] = 'V';
                chars[4] = 'E';
                chars[5] = 'T';
                chars[6] = ' ';
                chars[7] = 'P';
                chars[8] = 'I';
                chars[9] = 'D';
                chars[10] = 'O';
                chars[11] = 'R';
                chars[12] = 'A';
                chars[13] = 'Z';
                for(char c : chars) {
                    robot.keyPress(c);
                }
            } catch (AWTException ex) {
                System.out.println(ex.getMessage());
            }
        }).start();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        if(!isCtrlPressed) return;
        int i = e.getKeyChar();
        send = i;
        /*System.out.println(i);
        if(i == 113) {
            new Thread(() -> {
                Robot robot;
                try {
                    robot = new Robot();
                    char[] chars = new char[1];
                    chars[0] = 'P';
                    for(char c : chars) {
                        robot.keyRelease(29);
                        robot.keyPress(c);
                        robot.keyRelease(c);
                        robot.keyPress(29);
                    }
                } catch (AWTException ex) {
                    System.out.println(ex.getMessage());
                }
            }).start();
        }*/
    }

    public static void main(String[] args) {
        try {
            // Регистрация глобального хука
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Добавляем слушатель клавиатуры (Этот класс)
        GlobalScreen.addNativeKeyListener(new Main());
    }
}