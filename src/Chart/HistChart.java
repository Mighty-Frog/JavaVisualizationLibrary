package Chart;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import Accessories.Axis;
import Accessories.Grid;
import Accessories.Scale;
import Accessories.Title;
import ScientificPlot.Distribution;
import Tools.MathAndConvert;

import javax.swing.*;

/**
 * @author Jin Cheng
 */
public class HistChart extends Chart {

  public  double[] numbers;
  public  double[] counts;
  public  int bins;
  public  String title;

  //char body info
  public  int origin_x = 200;
  public  int origin_y = 700;
  public int X_len = 800;
  public  int Y_len = 500;

  //axis info
  public  int axis_scale_num;
  public  int max_scale_y;
  public  int expected_scale_num = 10;

  //title position info
  public  int title_x;
  public  int title_y;

    //bar top position array
    public double[][] bar_top;

    double max_num;
    double min_num;
    double bar_width;

    Distribution distribution;
    //char body line
    Line2D bottom = new Line2D.Double(origin_x, origin_y, origin_x + X_len, origin_y);
    Line2D top = new Line2D.Double(origin_x, origin_y - Y_len, origin_x + X_len, origin_y - Y_len);
    Line2D left = new Line2D.Double(origin_x, origin_y, origin_x, origin_y - Y_len);
    Line2D right = new Line2D.Double(origin_x + X_len, origin_y, origin_x + X_len, origin_y - Y_len);

    //constructor1
    public HistChart(double[] numbers, double[] counts, int bins,  String title) {
        this.numbers = numbers;
        this.counts = counts;
        this.bins = bins;
        this.title = title;
    }

    @Override
    public void paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        super.paintComponent(g);
        //Remove stroke jaggies
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        //Remove text jaggies
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //Remove graph jaggies
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //calculate some variables

        //bar_width =  X_len / (bins + 2); // get 66.0

        bar_width = (double) X_len / (bins + 2); // get 66.67

        //System.out.println("bar_width in HIstchart " + bar_width);
        max_num = MathAndConvert.max(counts);
        min_num = MathAndConvert.min(counts);

        //draw rect of barchart

        g.draw(bottom);
        g.draw(top);
        g.draw(left);
        g.draw(right);

        //draw title
        new Title(title, title_x, title_y, X_len, Y_len, origin_x, origin_y).drawTitle(g);

        //draw Y-axis, scale or net
        new Axis(counts, origin_x, origin_y, max_num, min_num, X_len, Y_len).drawAxis_y(g);

        //draw vertical grid
        new Grid(numbers, origin_x, origin_y, max_num, min_num, X_len, Y_len).drawGrid_y(g);

        // draw histogram bars and bar names
        double modified_max = Scale.getRealMax(max_num,min_num);
        double modified_min = Scale.getRealMin(max_num,min_num);
        double modified_range = modified_max-modified_min;

        bar_top = new double[numbers.length][2];

        //the x_axis was divided into bins + 2 rather than bins, so that can left
        //empty space for both left and right side.
        for (int i = 0; i < numbers.length ; i++) {
            double offset_bar_x = bar_width * (i+1);
            double bar_x = origin_x + offset_bar_x;
            double bar_y =origin_y - (numbers[i]-modified_min)/modified_range * Y_len;
            Rectangle2D.Double bar = new Rectangle2D.Double(bar_x, bar_y, bar_width, origin_y - bar_y);

            bar_top[i][0] = bar_x + bar_width/2;
            bar_top[i][1] = bar_y;
            //System.out.println("(numbers.length"+ numbers.length + " bar width" + bar_width);

            g.setColor(new Color(160, 160, 206));
            g.fill(bar);
            g.setColor(Color.white);
            g.draw(bar);
            //draw name of each bar
            //String n = names[i];
            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            //int fontLen = g.getFontMetrics().stringWidth(n);
            //g.drawString(n, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (origin_y + 20 + 10));
            //draw specific number of each bar
            String numberStr = String.valueOf(numbers[i]);
            int fontLen = g.getFontMetrics().stringWidth(numberStr);
            g.setColor(new Color(0, 0, 100, 80));
            g.drawString(numberStr, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (bar_y - 10));
        }

        //draw X-axis and scale
        new Axis(numbers, origin_x, origin_y, max_num, min_num, X_len, Y_len).drawAxis_Hist(g);

        new Distribution(this, this.bar_top,this.origin_x, this.origin_y).draw(g);
    }

}