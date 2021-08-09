package Accessories;

import Tools.MathAndConvert;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @author Jin Cheng
 */

public class Axis {
    double[] numbers;
    int origin_x;
    int origin_y;

    double max_num;
    double min_num;
    int expected_scale_num = 10;
    int Y_len;
    int X_len;

    //number of bins, using for histogram
    int  bins = expected_scale_num;

    //Constructor

    public Axis(double[] numbers, int origin_x, int origin_y,
                double max_num, double min_num, int X_len, int Y_len) {
        this.numbers = numbers;
        this.origin_x= origin_x;
        this.origin_y = origin_y;
        this.max_num = max_num;
        this.min_num = min_num;
        this.Y_len = Y_len;
        this.X_len = X_len;
    }

    //drawing method

    public void  drawAxis_y(Graphics2D g) {
        //calculate some variables
        double modified_max = Scale.getRealMax(max_num,min_num);
        double modified_min = Scale.getRealMin(max_num,min_num);
        double modified_range = modified_max-modified_min;
        double real_scale_setp = Scale.getScaleStepFromRaw(max_num,min_num,expected_scale_num);
        double scale_num_with_fraction = modified_range/ real_scale_setp;
        int modified_scale_num = (int) scale_num_with_fraction;
        //a loop to draw each interval of scale
        for (int i = 0; i < scale_num_with_fraction ; i++) {
            g.setColor(Color.black);
            Line2D Y_scale = new Line2D.Double(origin_x , origin_y - Y_len / (scale_num_with_fraction) * i,
                    origin_x + 8, origin_y - Y_len / (scale_num_with_fraction)  * i ) ;
            g.draw(Y_scale);
            //draw numbers of each scale
            String scale_y = String.valueOf(real_scale_setp * i);
            Font font = new Font("arial",Font.PLAIN,15);
            g.setFont(font);
            g.setColor(Color.black);
            int strWidth = g.getFontMetrics().stringWidth(scale_y);
            g.drawString(scale_y,origin_x - strWidth , (float) (origin_y - Y_len / (scale_num_with_fraction) * i)+5);
        }
    }

    public void  drawAxis_x(Graphics2D g) {
        //calculate some variables
        double modified_max = Scale.getRealMax(max_num,min_num);
        double modified_min = Scale.getRealMin(max_num,min_num);
        double modified_range = modified_max-modified_min;
        double real_scale_setp = Scale.getScaleStepFromRaw(max_num,min_num,expected_scale_num);
        double scale_num_with_fraction = modified_range/ real_scale_setp;
        int modified_scale_num = (int) scale_num_with_fraction;
        //a loop to draw each interval of scale
        for (int i = 0; i < scale_num_with_fraction ; i++) {
            g.setColor(Color.black);
            Line2D Y_scale = new Line2D.Double(origin_x +  X_len / (scale_num_with_fraction) * i , origin_y ,
                    origin_x + X_len / (scale_num_with_fraction)  * i , origin_y - 8) ;
            g.draw(Y_scale);
            //draw numbers of each scale
            String scale_y = String.valueOf(real_scale_setp * i);
            Font font = new Font("arial",Font.PLAIN,15);
            g.setFont(font);
            g.setColor(Color.black);
            int strWidth = g.getFontMetrics().stringWidth(scale_y);
            g.drawString(scale_y, (float) (origin_x +  X_len / (scale_num_with_fraction) * i - strWidth/2),
                        origin_y +15);
        }
    }
    public void  drawAxis_Hist(Graphics2D g) {
        //calculate some variables
        double modified_max = MathAndConvert.max(numbers);
        double modified_min = MathAndConvert.min(numbers);
        double modified_range = modified_max-modified_min;

        double real_scale_value = modified_range/bins;
        double slot_num = bins + 2 ;
        System.out.println(modified_max);
        System.out.println(modified_min);
        System.out.println(slot_num);
        //double scale_num_with_fraction = modified_range/ real_scale_setp;
        //int modified_scale_num = (int) scale_num_with_fraction;
        //a loop to draw each interval of scale
        for (int i = 0; i < slot_num - 1 ; i++) {
            //draw scale
            g.setColor(Color.black);
            Line2D.Double Y_scale = new Line2D.Double(origin_x +  X_len / slot_num * (i+1) , origin_y ,
            origin_x + X_len / slot_num  * (i+1) , origin_y - 8) ;

            System.out.println("X_len / slot_num" +  X_len / slot_num);

            g.draw(Y_scale);

            //draw numbers of each scale
            String scale_y = String.valueOf(modified_min +real_scale_value * i);
            Font font = new Font("arial",Font.PLAIN,15);
            g.setFont(font);
            g.setColor(Color.black);
            int strWidth = g.getFontMetrics().stringWidth(scale_y);
            g.drawString(scale_y, (float) (origin_x +  X_len / slot_num * (i+1) - strWidth/2),
                    origin_y +15);
        }
    }

}
