package features;

import javax.swing.*;

import main.Driver;
import makingUp.Constants;

import java.awt.event.ActionEvent;

public class Menu {
    public static JMenuBar createMenuBar(){
        JMenuBar j_menu_bar = new JMenuBar();
        
        JMenu j_menu_file = new JMenu("File");
        j_menu_file.setMnemonic('F');
        j_menu_file.add(Constants.actNew);
        j_menu_file.addSeparator();
        j_menu_file.add(Constants.actOpen);
        j_menu_file.addSeparator();
        j_menu_file.add(Constants.actSave);
        j_menu_file.addSeparator();
        j_menu_file.add(Constants.actSaveAs);
        j_menu_file.addSeparator();
        j_menu_file.add(Constants.actExit);
        
        JMenu j_menu_edit = new JMenu("Edit");
        j_menu_edit.setMnemonic('E');
        j_menu_edit.add(Constants.actUndo);
        j_menu_edit.addSeparator();
        j_menu_edit.add(Constants.actRedo);
        j_menu_edit.addSeparator();
        j_menu_edit.add(Constants.actCopy);
        j_menu_edit.addSeparator();
        j_menu_edit.add(Constants.actCut);

        /*JMenu j_menu_window = new JMenu("Window");
        j_menu_window.setMnemonic('W');
        j_menu_window.add(new JMenuItem("Zoom in"));
        j_menu_window.add(new JMenuItem("Zoom out"));
        j_menu_window.add(new JMenuItem("Default Zoom"));
*/
        JMenu j_menu_help = new JMenu("Help");
        j_menu_help.setMnemonic('H');
        j_menu_help.add(Constants.actShowHelp);
        j_menu_help.add(Constants.sendComments);
        j_menu_help.addSeparator();
        j_menu_help.add(Constants.actAbout);


        j_menu_bar.add(j_menu_file);
        j_menu_bar.add(j_menu_edit);
  //      j_menu_bar.add(j_menu_window);
        j_menu_bar.add(j_menu_help);

        return j_menu_bar;
    }
}
