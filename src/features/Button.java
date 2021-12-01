package features;

import makingUp.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class Button {
    public static JButton draw(int width, int height, String text, int border_radius,
                               Color bg, Color font_color, int font_size){
        JButton button = new JButton();

        button.setPreferredSize(new Dimension(width,height));
        button.setText(text);
        button.setBorder(new CustomBorder(border_radius));
        button.setBackground(bg);
        button.setForeground(font_color);
        button.setFont(new Font(Constants.ARIAL_FONT, Font.BOLD, font_size));
        button.setOpaque(true);

        button.setUI(new BasicButtonUI(){
            @Override
            public void update(Graphics g, JComponent c) {
                if (c.isOpaque()) {
                    Color fillColor = c.getBackground();

                    AbstractButton button = (AbstractButton) c;
                    ButtonModel model = button.getModel();

                    if (model.isPressed()) {
                        fillColor = fillColor.darker();
                    } else if (model.isRollover()) {
                        fillColor = fillColor.brighter();
                    }

                    g.setColor(fillColor);
                    g.fillRoundRect(0, 0, c.getWidth(),c.getHeight(), 20, 20);
                }
                paint(g, c);
            }
        });
        return button;
    }
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