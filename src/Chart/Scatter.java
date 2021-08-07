package Chart;

import Accessories.Axis;
import Accessories.Grid;
import Accessories.Scale;
import Accessories.Title;
import Tools.ColorSet;
import Tools.MathAndConvert;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @author Jin Cheng
 */

public class Scatter extends JPanel {
    //parameters info
    double[] numbers_x;
    double[] numbers_y;
    String name_x;
    String name_y;
    String names;
    String title;

    //chart body info
    int origin_x = 200;
    int origin_y = 700;
    int X_len = 700;
    int Y_len = 500;

    //axis info
    int numbers_x_max = 0;
    int numbers_x_min = 0;
    int numbers_y_max = 0;
    int numbers_y_min = 0;
    int range_x_min = 0;
    int range_x_max = 0;
    int range_y_min = 0;
    int range_y_max = 0;
    int axis_scale_num = 0;
    int max_scale_y = 0;
    int expected_scale_num = 20;

    //title position info
    int title_x;
    int title_y;

    double max_num_x;
    double max_num_y;
    double min_num_x;
    double min_num_y;

    //int bar_width = 20;
    //double bar_slot_width;

    //chart body lines
    Line2D bottom = new Line2D.Double(origin_x,origin_y,origin_x + X_len, origin_y);
    Line2D top = new Line2D.Double(origin_x,origin_y-Y_len,origin_x + X_len, origin_y-Y_len);
    Line2D left = new Line2D.Double(origin_x,origin_y, origin_x, origin_y-Y_len);
    Line2D right = new Line2D.Double(origin_x+X_len,origin_y, origin_x+X_len, origin_y-Y_len);

    //constructor1
    public Scatter(double[] numbers_x, double[] numbers_y,String name_x, String name_y, String title){
        this.numbers_x = numbers_x;
        this.numbers_y = numbers_y;
        this.name_x = name_x;
        this.name_y = name_y;
        this.title = title;
    }

    public Scatter(double[] numbers_x, double[] numbers_y){
        this.numbers_x = numbers_x;
        this.numbers_y = numbers_y;
    }

    @Override
    public void  paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        super.paintComponent(g);

        max_num_x = MathAndConvert.max(numbers_x);
        max_num_y = MathAndConvert.max(numbers_y);
        min_num_x = MathAndConvert.min(numbers_x);
        min_num_y = MathAndConvert.min(numbers_y);

        double modified_max_x = Scale.getRealMax(max_num_x,min_num_x);
        double modified_min_x = Scale.getRealMin(max_num_x,min_num_x);
        double modified_max_y = Scale.getRealMax(max_num_y,min_num_y);
        double modified_min_y = Scale.getRealMin(max_num_y,min_num_y);
        double modified_range_x = modified_max_x-modified_min_x;
        double modified_range_y = modified_max_y-modified_min_y;

        //draw rect of barchart

        g.draw(bottom);
        g.draw(top);
        g.draw(left);
        g.draw(right);

        //draw title
        new Title(title, title_x, title_y, X_len, Y_len, origin_x, origin_y).drawTitle(g);

        //draw X-axis
        new Axis( numbers_x, origin_x, origin_y,max_num_x,min_num_x,X_len,Y_len).drawAxis_x(g);

        //draw Y-axis,
        new Axis( numbers_y, origin_x, origin_y,max_num_y,min_num_y,X_len, Y_len).drawAxis_y(g);

        //draw vertical grid
         new Grid(numbers_y,origin_x,origin_y,max_num_y,min_num_y,X_len,Y_len).drawGrid_y(g);
        new Grid(numbers_x,origin_x,origin_y,max_num_x,min_num_x,X_len,Y_len).drawGrid_x(g);

        //draw points
        for (int i = 0; i <numbers_x.length ; i++) {
            int position_x = (int) (origin_x + (numbers_x[i]-modified_min_x)/modified_range_x * X_len);
            int position_y = (int) (origin_y - (numbers_y[i]-modified_min_y)/modified_range_y * Y_len);
            g.setColor(ColorSet.Dark[(i)%6]);
            g.fillOval(position_x,position_y,15,15);
            System.out.println("position_x"+position_x+"position_y"+position_y);

        }


    }
}
