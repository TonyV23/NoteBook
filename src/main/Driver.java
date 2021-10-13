package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Driver extends JFrame{
    public Driver(){
        super("Note Book App");
        this.setPreferredSize(new Dimension(700,450));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
