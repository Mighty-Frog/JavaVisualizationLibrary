package Accessories;

import Chart.Chart;

import java.awt.*;

/**
 * @author Jin Cheng
 */
public class Label {
    Chart chart;
    String label_x_name = "label_x";
    String label_y_name = "label_y";
    int origin_y;
    int origin_x;
    String[] names;
    double bar_slot_width;
    double bar_width;
    int font_size = 15;
    int X_len;
    int Y_len;


    public Label(String[] names, double bar_slot_width, double bar_width, int origin_x, int origin_y, int X_len, int Y_len){
        this.origin_y = origin_y;
        this.origin_x = origin_x;
        this.names = names;
        this.bar_slot_width = bar_slot_width;
        this.bar_width = bar_width;
        this.X_len = X_len;
        this.Y_len = Y_len;
    }

    public void drawLable_x(Graphics2D g){
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.black);
        for (String n : names) {
            int font_len = g.getFontMetrics().stringWidth(n);
            if (font_len >= bar_slot_width) {
                 label_slope(g);
                 return;
            }
        }
            label_horizonal(g);
    }

    public void drawLabel_name_x(Graphics2D g){
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, (int) (1.5 * font_size)));
        int label_font_len = g.getFontMetrics().stringWidth(label_x_name);
        for (String n : names) {
            int font_len = g.getFontMetrics().stringWidth(n);
            if (font_len >= bar_slot_width) {
                g.drawString(label_x_name, (int) (origin_x + X_len + label_font_len / 2), origin_y + font_size );
                return;
            }
        }
        g.drawString(label_x_name,(int) (origin_x + (bar_slot_width* names.length/2) - label_font_len/2),origin_y + font_size * 3);
    }

    public void drawLabel_name_y(Graphics2D g){
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, (int) (1.5 * font_size)));
        int label_font_len = g.getFontMetrics().stringWidth(label_x_name);

        g.drawString(label_y_name,(int) (origin_x - label_font_len/2),origin_y - Y_len - font_size);
    }


    public void label_horizonal(Graphics2D g) {
        for (int i = 0; i < names.length; i++) {
            double offset_bar_x = bar_slot_width * i;
            double bar_x = origin_x + bar_slot_width / 2 - bar_width / 2 + offset_bar_x;
            String n = names[i];
            int fontLen = g.getFontMetrics().stringWidth(n);
            g.drawString(n, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (origin_y + font_size * 1.5));
        }
    }

        public void label_slope(Graphics2D g) {
        g.translate(origin_x,origin_y);
        g.rotate(Math.toRadians(90));
            for (int i = 0; i < names.length; i++) {
                String n = names[i];
                g.drawString(n, (int) (font_size * 1.5), (int) (bar_slot_width * i + bar_slot_width/2 )* -1);
            }
            g.rotate(Math.toRadians(-90));
            g.translate(-origin_x,-origin_y);
        }
    }
