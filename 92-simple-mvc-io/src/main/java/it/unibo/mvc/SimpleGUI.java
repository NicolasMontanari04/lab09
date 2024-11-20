package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first Java graphical interface");

    /**
     * build the frame.
     *
     * @param controller the controller for print in list
     */
    public SimpleGUI(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        final JTextArea areaText = new JTextArea();
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeString(areaText.getText());
                } catch (IOException event) {
                    JOptionPane.showMessageDialog(null, event.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        canvas.add(areaText, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
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
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
