package features;

import makingUp.Constants;

import javax.swing.*;
import java.awt.*;

public class WindowController {
    public static JScrollPane createTextArea(){

        JTextArea j_text_area = new JTextArea();
        j_text_area.setLineWrap(false);
        j_text_area.setFont(Font.getFont(Constants.SEGOE_FONT));

        return new JScrollPane(j_text_area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
