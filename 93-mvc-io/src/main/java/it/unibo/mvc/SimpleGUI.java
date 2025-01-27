package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("MOdel-View-Controller");
    /**
     * build the frame.
     *
     * @param simpleController the controller for print in list
     */
    public SimpleGUI(final SimpleController simpleController) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        final JPanel canvas2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        canvas.add(canvas2, BorderLayout.SOUTH);
        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton print = new JButton("PRINT");
        canvas2.add(print, BorderLayout.CENTER);
        final JButton show = new JButton("SHOW HISTORY");
        canvas2.add(show, BorderLayout.CENTER);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                simpleController.setString(textField.getText());
                System.out.println(simpleController.getNextString()); // NOPMD: allowed as this is just an exercise
                simpleController.printCurrentString();
            } 
        });

        show.addActionListener(new ActionListener() {
            private String memory = "";
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (final String string : simpleController.getList()) {
                    memory = memory.concat("\n" + string);
                }
                textArea.setText(memory);
            }
        });
    }
    /**
     * Set the dimension of the screen.
     *
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }
}
