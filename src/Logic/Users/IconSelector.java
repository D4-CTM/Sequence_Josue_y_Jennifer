/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Users;

/**
 *
 * @author jenniferbueso
 */
import javax.swing.*;
import java.awt.event.*;

public class IconSelector {
    private JFrame frame;
    private JButton button;
    private JLabel label;

    public IconSelector() {
        frame = new JFrame("Icon Selector");
        button = new JButton("Seleccionar Ícono");
        label = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Ícono 1", "Ícono 2", "Ícono 3" };
                int n = JOptionPane.showOptionDialog(frame,
                        "Selecciona un ícono",
                        "Selector de Ícono",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);

                switch (n) {
                    case 0:
                        label.setIcon(new ImageIcon("ruta/al/ícono1.png"));
                        break;
                    case 1:
                        label.setIcon(new ImageIcon("ruta/al/ícono2.png"));
                        break;
                    case 2:
                        label.setIcon(new ImageIcon("ruta/al/ícono3.png"));
                        break;
                }
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(button);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new IconSelector();
    }
}

