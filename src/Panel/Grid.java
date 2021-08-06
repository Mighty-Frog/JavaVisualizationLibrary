package Panel;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @author Jin Cheng
 */

public class Grid  {
    double[] numbers;
    int origin_x;
    int origin_y;

    double max_num;
    double min_num;
    int expected_scale_num = 10;
    int X_len;
    private int Y_len;


    public Grid( double[] numbers, int origin_x, int origin_y,
                 double max_num, double min_num,int X_len, int Y_len) {
        this.numbers = numbers;
        this.origin_x= origin_x;
        this.origin_y = origin_y;
        this.max_num = max_num;
        this.min_num = min_num;
        this.X_len = X_len;
        this.Y_len = Y_len;
    }


    public void drawGrid_y(Graphics2D g) {

        double modified_max = Scale.getRealMax(max_num,min_num);
        double modified_min = Scale.getRealMin(max_num,min_num);
        double modified_range = modified_max-modified_min;

        double real_scale_setp = Scale.getScaleStepFromRaw(max_num,min_num,expected_scale_num);
        double scale_num_with_fraction = modified_range/ real_scale_setp;
        int modified_scale_num = (int) scale_num_with_fraction;
        for (int i = 0; i < scale_num_with_fraction ; i++) {
            g.setColor(new Color(100,100,100,30));
            Line2D Y_net = new Line2D.Double(origin_x , origin_y - Y_len / (scale_num_with_fraction) * i,
                origin_x + X_len, origin_y - Y_len / (scale_num_with_fraction) * i ) ;
        g.draw(Y_net);
        }
    }
    public void drawGrid_x(Graphics2D g) {

        double modified_max = Scale.getRealMax(max_num,min_num);
        double modified_min = Scale.getRealMin(max_num,min_num);
        double modified_range = modified_max-modified_min;

        double real_scale_setp = Scale.getScaleStepFromRaw(max_num,min_num,expected_scale_num);
        double scale_num_with_fraction = modified_range/ real_scale_setp;
        int modified_scale_num = (int) scale_num_with_fraction;
        for (int i = 0; i < scale_num_with_fraction ; i++) {
            g.setColor(new Color(100,100,100,30));
            Line2D Y_net = new Line2D.Double(origin_x + X_len /(scale_num_with_fraction) * i , origin_y,
                    origin_x + + X_len /(scale_num_with_fraction) * i , origin_y - Y_len);
            g.draw(Y_net);
        }
    }

}

