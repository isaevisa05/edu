package c7_4;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.addMouseListener(new MouseListener());
    }
}
