package main;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

import features.Menu;
import features.WindowController;
import makingUp.Constants;

public class Driver extends JFrame{
    public Driver(){
        super("NoteBookApp");
        this.setMaximumSize(new Dimension(Constants.maximum_size));
        this.setMinimumSize(new Dimension(Constants.maximum_size));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int closingW = JOptionPane.showConfirmDialog(Driver.this,
                        "Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
                if (closingW == JOptionPane.YES_OPTION){
                    Driver.this.dispose();
                }
            }
        });
        this.setLocationRelativeTo(null);
        this.setJMenuBar(Menu.createMenuBar());

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(WindowController.createTextArea());
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Driver driver = new Driver();
        driver.setVisible(true);
    }

}
