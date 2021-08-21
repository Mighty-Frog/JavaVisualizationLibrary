package Accessories;

import Chart.Chart;

import java.awt.*;

/**
 * @author Jin Cheng
 */
public class Lable {
    Chart chart;
    int origin_y;
    int origin_x;
    String[] names;
    double bar_slot_width;
    double bar_width;
    int font_size = 15;

    public Lable(String[] names, double bar_slot_width, double bar_width, int origin_x,int origin_y){
        this.origin_y = origin_y;
        this.origin_x = origin_x;
        this.names = names;
        this.bar_slot_width = bar_slot_width;
        this.bar_width = bar_width;
    }

    public void drawLable_x(Graphics2D g){
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
                //double offset_bar_x = bar_slot_width * i;
                //double bar_x = origin_x + bar_slot_width / 2 - bar_width / 2 + offset_bar_x;
                String n = names[i];
                //int fontLen = g.getFontMetrics().stringWidth(n);
                //g.drawString(n, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (origin_y + font_size * 1.5));
                g.drawString(n, (int) (font_size * 1.5), (int) (bar_slot_width * i + bar_slot_width/2 )* -1);
            }
            g.rotate(Math.toRadians(-90));
            g.translate(-origin_x,-origin_y);
        }
    }
