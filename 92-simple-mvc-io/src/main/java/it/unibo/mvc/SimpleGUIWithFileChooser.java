package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first Java graphical interface");

    /**
     * build the frame.
     *
     * @param controller the controller for print in list
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        final JPanel canvas2 = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas2.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.add(canvas2, BorderLayout.NORTH);
        final JTextArea areaText = new JTextArea();
        final JButton save = new JButton("Save");
        final JTextArea areaText2 = new JTextArea();
        areaText2.setEditable(false);
        areaText2.setText(controller.getCurrentPath());
        final JButton browse = new JButton("Browse....");
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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (controller.getCurrentFile() != null) {
                    fileChooser.setSelectedFile(controller.getCurrentFile());
                }
                final int result = fileChooser.showSaveDialog(frame); // Show Save Dialog
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file and display its path in the text field
                    areaText2.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (result == JFileChooser.CANCEL_OPTION) { 
                    System.out.println("do nothing"); // NOPMD: allowed as this is just an exercise
                } else {
                    JOptionPane.showMessageDialog(frame, result, "fail", JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
        canvas2.add(areaText2, BorderLayout.CENTER);
        canvas2.add(browse, BorderLayout.LINE_END);
        canvas.add(areaText, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(canvas2, BorderLayout.NORTH);
        frame.setVisible(true);
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
        final SimpleGUIWithFileChooser guiC = new SimpleGUIWithFileChooser(new Controller());
        guiC.display();
    }

}
