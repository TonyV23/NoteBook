package features;

import javax.swing.*;

import makingUp.Constants;

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

        JMenu j_menu_help = new JMenu("Help");
        j_menu_help.setMnemonic('H');
        j_menu_help.add(Constants.actAbout);


        j_menu_bar.add(j_menu_file);
        j_menu_bar.add(j_menu_edit);
        j_menu_bar.add(j_menu_help);

        return j_menu_bar;
    }
}
