package Chart;

import javax.swing.*;
import UsingClass.MathAndConvert;
import Panel.Scale;
import Panel.BarChartLabelAxis;
import Panel.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
/**
 * @author Jin Cheng
 */
public class Barchart extends JPanel {

    double[] numbers;
    String[] names;
    String title;

    //char body info
    int origin_x = 200;
    int origin_y = 700;
    int X_len = 700;
    int Y_len = 500;

    //axis info
    int axis_scale_num;
    int max_scale_y;
    int expected_scale_num = 10;

    //title position info
    int title_x;
    int title_y;

    double max_num;
    double min_num;
    int bar_width = 20;
    double bar_slot_width;

    //char body line
    Line2D bottom = new Line2D.Double(origin_x,origin_y,origin_x + X_len, origin_y);
    Line2D top = new Line2D.Double(origin_x,origin_y-Y_len,origin_x + X_len, origin_y-Y_len);
    Line2D left = new Line2D.Double(origin_x,origin_y, origin_x, origin_y-Y_len);
    Line2D right = new Line2D.Double(origin_x+X_len,origin_y, origin_x+X_len, origin_y-Y_len);

    //constructor1
    public Barchart(double[] numbers, String[] names, String title){
        this.numbers = numbers;
        this.names = names;
        this.title = title;
    }
    //Constructor2
    public Barchart(double[] v, String[] n){
        this.numbers = v;
        this.names = n;

    }

        @Override
        public void  paintComponent(Graphics g0) {
            Graphics2D g = (Graphics2D) g0;
            super.paintComponent(g);
            //Remove stroke jaggies
            g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
            //Remove text jaggies
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //Remove graph jaggies
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //calculate some variables
            bar_slot_width = X_len/numbers.length;
            max_num = MathAndConvert.max(numbers);
            min_num = MathAndConvert.min(numbers);

            //draw rect of barchart

            g.draw(bottom);
            g.draw(top);
            g.draw(left);
            g.draw(right);

            //draw title
            new Title(title, title_x, title_y, X_len, Y_len, origin_x, origin_y).drawTitle(g);

            //draw X-axis and scale
            new BarChartLabelAxis(numbers, origin_x,origin_y, bar_slot_width).drawLabelAxis_x(g);

            //draw Y-axis, scale or net
            new Axis( numbers, origin_x, origin_y,max_num,min_num,X_len,Y_len).drawAxis_y(g);

            //draw vertical grid
            new Grid( numbers,origin_x,origin_y, max_num,min_num, X_len, Y_len).drawGrid_y(g);

            // draw bars and bar names
                double modified_max = Scale.getRealMax(max_num,min_num);
                for (int i = 0; i < numbers.length; i++) {
                    double offset_bar_x = bar_slot_width * i;
                    double bar_x = origin_x + bar_slot_width / 2 - bar_width / 2 + offset_bar_x;
                    double bar_y = origin_y - numbers[i] / (modified_max ) * Y_len;
                    Rectangle2D bar = new Rectangle2D.Double(bar_x, bar_y, bar_width, origin_y - bar_y);
                    g.setColor(new Color(160, 160, 206));
                    g.fill(bar);
                    //draw name of each bar
                    String n = names[i];
                    g.setColor(Color.black);
                    g.setFont(new Font("arial", Font.PLAIN, 15));
                    int fontLen = g.getFontMetrics().stringWidth(n);
                    g.drawString(n, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (origin_y + 20 + 10));
                    //draw specific number of each bar
                    g.setColor(new Color(0, 0, 100, 80));
                    g.drawString(String.valueOf(numbers[i]), (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (bar_y - 10));
                }
    }
}
