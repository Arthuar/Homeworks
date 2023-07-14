package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstButton {
    public void firstWindow(){
        JFrame f = new JFrame("\n" +
                " Гра в міста ");
        JLabel jl = new JLabel("      Вітаємо у грі дитинства");
        jl.setBounds(30,15,200,30);
        JButton b = new JButton("Початок");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new NextWindow().secondWindow();
            }
        });
        b.setBounds(280, 15, 70, 30);
        f.add(b);
        f.add(jl);
        f.setSize(400, 120);
        f.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = f.getWidth();
        int windowHeight = f.getHeight();
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        f.setLocation(windowX, windowY);
        f.setVisible(true);

    }
}
