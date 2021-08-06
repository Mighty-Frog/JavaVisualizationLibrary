package Panel;

/**
 * @author Jin Cheng
 */

import java.awt.*;
import java.awt.geom.Line2D;

public class BarChartLabelAxis {
    double[] numbers;
    int origin_x;
    int origin_y;
    double bar_slot_width;

    //when vertialOrNot is bigger than 0, draw vertial barchart, or draw horizonal barchart

public BarChartLabelAxis(double[] numbers, int origin_x, int origin_y, double bar_slot_width, int vertialOrNot){
    if(vertialOrNot > 0) {
        this.numbers = numbers;
        this.origin_x = origin_x;
        this.origin_y = origin_y;
        this.bar_slot_width = bar_slot_width;
    }else{
        this.numbers = numbers;
        this.origin_x = origin_x;
        this.origin_y = origin_y;
        this.bar_slot_width = bar_slot_width;
    }


}
    public BarChartLabelAxis(double[] numbers, int origin_x, int origin_y, double bar_slot_width){
        this(numbers,origin_x,origin_y,bar_slot_width,1);
    }

    public void drawLabelAxis_x(Graphics2D g) {
        for (int i = 0; i < numbers.length; i++) {
            Line2D X_scale = new Line2D.Double(origin_x + bar_slot_width * i, origin_y,
                    origin_x + bar_slot_width * i, origin_y - 8);
            g.draw(X_scale);
        }
    }

    public void  drawLabelAxis_y(Graphics2D g) {
        for (int i = 0; i < numbers.length; i++) {
            Line2D X_scale = new Line2D.Double(origin_x , origin_y - bar_slot_width * i,
                    origin_x + 8 , origin_y - bar_slot_width * i);
            g.draw(X_scale);
        }
    }
}