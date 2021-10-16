package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Driver extends JFrame{
    public Driver(){
        super("Note Book App");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(700,400));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int closingW = JOptionPane.showConfirmDialog(Driver.this,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
                if (closingW == JOptionPane.YES_OPTION){
                    Driver.this.dispose();
                }
            }
        });
        this.setBackground(Color.DARK_GRAY);        
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Driver driver = new Driver();
        driver.setVisible(true);
    }

}
