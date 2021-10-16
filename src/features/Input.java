package features;


import makingUp.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

public class Input {

    public static JTextField drawTextBox(int weight, int height, int border_radius, Color bg, Color font_color,
                                         int font_size){
        JTextField text_field= new JTextField();

        text_field.setPreferredSize(new Dimension(weight,height));
        text_field.setBorder(new CustomBorder(border_radius));
        text_field.setBackground(bg);
        text_field.setForeground(font_color);
        text_field.requestFocus();
        text_field.setEditable(true);
        text_field.setFont(new Font(Constants.CONSOLAS_FONT,Font.PLAIN,font_size));

        return text_field;
    }

    public static JPasswordField drawPasswordBox(int weight, int height, int border_radius, Color bg, Color font_color,
                                                 int font_size){
        JPasswordField password_field = new JPasswordField();

        password_field.setPreferredSize(new Dimension(weight,height));
        password_field.setBorder(new CustomBorder(border_radius));
        password_field.setBackground(bg);
        password_field.setForeground(font_color);
        password_field.requestFocus();
        password_field.setEditable(true);
        password_field.setFont(new Font(Constants.CONSOLAS_FONT,Font.PLAIN,font_size));

        return password_field;
    }

    public static JLabel drawLabel(int height, int weight, int border_radius, Color bg, Color font_color,String label_name,
                                   Image path_icon,int font_size){
        JLabel label= new JLabel();

        label.setPreferredSize(new Dimension(weight,height));
        label.setBorder(new CustomBorder(border_radius));
        label.setBackground(bg);
        label.setForeground(font_color);
        label.setText(label_name);
        label.setIcon(new ImageIcon(path_icon));//location file must be indicated (is it really necessary?)
        label.setFont(new Font(Constants.CONSOLAS_FONT,Font.PLAIN,font_size));

        return label;

    }

    public static JComboBox drawComboBox(String[] items, int height, int weight, int border_radius){

        JComboBox<String> comboBox = new JComboBox<>(items);

        comboBox.setPreferredSize(new Dimension(weight,height));
        comboBox.setBorder(new CustomBorder(border_radius));
        comboBox.setEditor(new ComboBoxEditor());
        comboBox.setRenderer(new ComboBoxRenderer());
        comboBox.setEditable(true);

        return  comboBox;
    }
    public static JCheckBox drawCheckBox(int weight,int height,int border_radius){
        JCheckBox checkBox = new JCheckBox();

        checkBox.setSelected(true);
        checkBox.setPreferredSize(new Dimension(weight,height));
        checkBox.setBorder(new CustomBorder(border_radius));
//        checkBox.setIcon(new ImageIcon(""));
//        checkBox.setSelectedIcon(new ImageIcon(""));
//        checkBox.setDisabledIcon(new ImageIcon(""));
//        checkBox.setDisabledSelectedIcon(new ImageIcon(""));
//        checkBox.setPressedIcon(new ImageIcon(""));
//        checkBox.setRolloverIcon(new ImageIcon(""));
//        checkBox.setRolloverSelectedIcon(new ImageIcon(""));

        return checkBox;
    }


    class CustomBorder implements Border {
        private final int radius;

        public CustomBorder(int radius){
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (c.getParent() != null) {
                Color bc = g.getColor();
                g.setColor(c.getParent().getBackground());
                for (int r = 0; r<radius;r++){
                    g.drawRoundRect(x, y, width - 1, height - 1, r, r);
                }
                g.setColor(bc);
            }
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }

    static class ComboBoxRenderer extends JLabel implements ListCellRenderer{
        public ComboBoxRenderer(){
            setOpaque(true);
            setBackground(Color.DARK_GRAY);
            setForeground(Color.DARK_GRAY);
            setFont(new Font(Constants.CONSOLAS_FONT,Font.PLAIN,10));
        }
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index,

                                                      boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            return this;
        }
    }

    static class ComboBoxEditor extends BasicComboBoxEditor {

        private JLabel label = new JLabel();
        private JPanel panel = new JPanel();
        private Object obj_selected;

        public ComboBoxEditor()
        {
            label.setOpaque(false);
            label.setFont(new Font(Constants.CONSOLAS_FONT,Font.PLAIN,15));
            label.setForeground(Color.DARK_GRAY);

            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 3));
            panel.add(label);
            panel.setBackground(Color.DARK_GRAY);
        }

        public Component getEditorComponent() {
            return this.panel;
        }

        public Object getItem() {
            return "[" + this.obj_selected.toString() + "]";
        }

        public void setItem(Object item) {
            this.obj_selected = item;
            label.setText(item.toString());
        }
    }
}
