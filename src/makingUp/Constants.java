package makingUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Constants {
    public static final String ARIAL_FONT = "Arial";
    public static final String CALIBRI_FONT = "Calibri";
    public static final String CAMBRIA_FONT = "Cambria";
    public static final String CANDARA_FONT = "Candara";
    public static final String CONSOLAS_FONT = "Consolas";
    public static final String COURIER_NEW_FONT = "Courier New";
    public static final String GEORGIA_FONT = "Georgia";
    public static final String LUCIDA_CONSOLE_FONT = "Arial";
    public static final String SEGOE_FONT = "Segoe UI Light";
    public static final String TIMES_NEW_ROMAN_FONT = "Times New Roman";

    public static AbstractAction actNew = new AbstractAction() {
        {
            putValue( Action.NAME, "New File..." );
            putValue( Action.SMALL_ICON, new ImageIcon( " resource/icons/new.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_N );
            putValue( Action.SHORT_DESCRIPTION, "New file (CTRL+N)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
        }
    };

    public static AbstractAction actOpen = new AbstractAction() {
        {
            putValue( Action.NAME, "Open File..." );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/open.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_O );
            putValue( Action.SHORT_DESCRIPTION, "Open file (CTRL+O)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {

            JFileChooser file_chooser = new JFileChooser();
            file_chooser.setDialogTitle("Opening file");
            file_chooser.showOpenDialog(null);
            file_chooser.setVisible(true);
            String file_selected = file_chooser.getSelectedFile().getAbsolutePath();

            FileReader file_reader =null;
            BufferedReader buffered_reader = null;
            JTextArea j_text_area = null;

            try {
                file_reader = new FileReader(file_selected);
                buffered_reader = new BufferedReader(file_reader);

                String file_content="";
                StringBuilder display_file_content= new StringBuilder();

                while((file_content=buffered_reader.readLine())!=null)
                    display_file_content.append(file_content).append("\r\n");

                assert false;
                j_text_area.setText(display_file_content.toString());

            }catch (Exception exception){
                exception.printStackTrace();
            }finally
                {
                    try {
                        assert file_reader != null;
                        file_reader.close();
                        assert buffered_reader != null;
                        buffered_reader.close();
                    }catch (Exception ex) { ex.printStackTrace();
                }
            }
        }

    };

    public static AbstractAction actSave = new AbstractAction() {
        {
            putValue( Action.NAME, "Save File" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/save.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_S );
            putValue( Action.SHORT_DESCRIPTION, "Save file (CTRL+S)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Save" );
        }
    };

    public static AbstractAction actSaveAs = new AbstractAction() {
        {
            putValue( Action.NAME, "Save As..." );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/save_as.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_A );
            putValue( Action.SHORT_DESCRIPTION, "Save file" );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            JFileChooser file_chooser = new JFileChooser();
            file_chooser.setDialogTitle("Save as ...");
            file_chooser.showSaveDialog(null);
            file_chooser.setVisible(true);
            String file_selected = file_chooser.getSelectedFile().getAbsolutePath();

            FileWriter file_writer =null;
            BufferedWriter buffered_writer = null;
            JTextArea j_text_area = null;

            try {
                file_writer = new FileWriter(file_selected);
                buffered_writer= new BufferedWriter(file_writer);
                assert false;
                buffered_writer.write(j_text_area.getText());
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
                try {
                    assert buffered_writer != null;
                    buffered_writer.close();
                    file_writer.close();
                }catch (Exception i){
                    i.printStackTrace();
                }
            }
        }
    };

    public static AbstractAction actExit = new AbstractAction() {
        {
            putValue( Action.NAME, "Exit" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/exit.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_X );
            putValue( Action.SHORT_DESCRIPTION, "Exit (ALT+F4)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Exit" );
        }
    };

    public static AbstractAction actUndo = new AbstractAction() {
        {
            putValue( Action.NAME, "Undo" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/undo.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_U );
            putValue( Action.SHORT_DESCRIPTION, "Undo (CTRL+Z)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Undo" );
        }
    };

    public static AbstractAction actRedo = new AbstractAction() {
        {
            putValue( Action.NAME, "Redo" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/redo.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_R );
            putValue( Action.SHORT_DESCRIPTION, "Redo (CTRL+U)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Redo" );
        }
    };

    public static AbstractAction actCopy = new AbstractAction() {
        {
            putValue( Action.NAME, "Copy" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/copy.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_C );
            putValue( Action.SHORT_DESCRIPTION, "Copy (CTRL+C)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Copy" );
        }
    };

    public static AbstractAction actCut = new AbstractAction() {
        {
            putValue( Action.NAME, "Cut" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/cut.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_T );
            putValue( Action.SHORT_DESCRIPTION, "Cut (CTRL+X)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Cut" );
        }
    };

    public static AbstractAction actPaste = new AbstractAction() {
        {
            putValue( Action.NAME, "Paste" );
            putValue( Action.SMALL_ICON, new ImageIcon( "resource/icons/paste.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_P );
            putValue( Action.SHORT_DESCRIPTION, "Paste (CTRL+V)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Paste" );
        }
    };
    public static AbstractAction actAbout = new AbstractAction() {
        {
            putValue( Action.NAME,"About NoteBookApp");
            putValue( Action.SMALL_ICON,new ImageIcon("resource/icons/about.png"));
            putValue( Action.MNEMONIC_KEY,KeyEvent.VK_A);
            putValue( Action.SHORT_DESCRIPTION,"About (CTRL+I)" );
            putValue( Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print("SOFTWARE created by Viper23 <https://github.com/TonyV23> <htonnycarlos@gmail.com>");
        }
    };
    public static final Dimension maximum_size = new Dimension(800,450);
    public static final Dimension minimum_size = new Dimension(300,100);
}
