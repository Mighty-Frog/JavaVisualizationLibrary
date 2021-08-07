package Chart;

import javax.swing.*;
import Tools.ColorSet;
import Tools.MathAndConvert;
import Accessories.Scale;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Jin Cheng
 */

public class MultiBarchart extends JPanel {

    //double[] numbers;
    double[][]  multinumbers;
    String[] columns;
    int bar_num_each_slot;
    int sub_bar_width;

    String[] names;
    String title;

    int origin_x = 200;
    int origin_y = 700;
    int X_len = 700;
    int Y_len = 500;

    int axis_scale_num;
    int max_scale_y;
    int scale_num = 2;

    int title_x;
    int title_y;

    double max_num;
    double min_num;
    int bar_width = 30;
    double bar_slot_width;
    Line2D bottom = new Line2D.Double(origin_x,origin_y,origin_x + X_len, origin_y);
    Line2D top = new Line2D.Double(origin_x,origin_y-Y_len,origin_x + X_len, origin_y-Y_len);
    Line2D left = new Line2D.Double(origin_x,origin_y, origin_x, origin_y-Y_len);
    Line2D right = new Line2D.Double(origin_x+X_len,origin_y, origin_x+X_len, origin_y-Y_len);

    public MultiBarchart(double[][] multinumbers, String[] indexnames,String[] columns, String title){

        this.multinumbers = multinumbers;
        this.names = indexnames;
        this.columns = columns;
        this.bar_num_each_slot = columns.length;
        this.sub_bar_width = bar_width/bar_num_each_slot;
        this.title = title;
        bar_slot_width = X_len/multinumbers.length;
        max_num = MathAndConvert.max(multinumbers);
    }

    public MultiBarchart(double[][] v, String[] n,String[] columns){
        this.multinumbers = v;
        this.names = n;
        this.columns = columns;
        this.bar_num_each_slot = columns.length;
        this.sub_bar_width = bar_width/bar_num_each_slot;
        bar_slot_width = X_len/multinumbers.length;
        max_num = MathAndConvert.max(multinumbers);
    }

    @Override
    public void  paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        super.paintComponent(g);

        //Remove text jaggies
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //Remove graph jaggies
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        bar_slot_width = X_len/multinumbers.length;
        max_num = MathAndConvert.max(multinumbers);
        min_num = MathAndConvert.min(multinumbers);


        //draw rect of barchart

        g.draw(bottom);
        g.draw(top);
        g.draw(left);
        g.draw(right);

        //draw title
        Font title_font = new Font("arial", Font.BOLD,40);
        g.setFont(title_font);
        int title_len= g.getFontMetrics().stringWidth(title);
        title_x = origin_x + X_len/2 - title_len/2;
        title_y = origin_y - Y_len - 40 - 10;
        g.drawString(title,title_x,title_y);

        //draw X-axis and scale

        for (int i = 0; i < multinumbers.length; i++) {
            Line2D X_scale = new Line2D.Double(origin_x + bar_slot_width * i, origin_y,
                    origin_x + bar_slot_width*i, origin_y - 8 ) ;
            g.draw(X_scale);
        }

        //draw Y-axis, scale or net

        for (int i = 0; i < scale_num + 1; i++) {
            g.setColor(new Color(100,100,100,30));
            Line2D Y_scale = new Line2D.Double(origin_x , origin_y - Y_len / (scale_num) * i,
                    origin_x + 8, origin_y - Y_len / (scale_num)  * i ) ;
            g.draw(Y_scale);
            //net
            Line2D Y_net = new Line2D.Double(origin_x , origin_y - Y_len / (scale_num) * i,
                    origin_x + X_len, origin_y - Y_len / (scale_num) * i ) ;
            g.draw(Y_net);


            String scale_y = String.valueOf(max_num/scale_num * i);
            Font font = new Font("arial",Font.PLAIN,15);
            g.setFont(font);
            g.setColor(Color.gray);
            g.drawString(scale_y,origin_x-55, (float) (origin_y - Y_len / (scale_num) * i));

        }

        // draw bars and bar names
        double modified_max = Scale.getRealMax(max_num,min_num);
        double mulitBarWidth = bar_width * multinumbers[0].length;
        for(int i = 0; i < multinumbers.length; i++){
            double offset_slot_x = bar_slot_width * i;
            for(int j = 0; j < multinumbers[i].length; j++){
                double offset_bar_x = bar_width * j;
                double bar_x = origin_x + bar_slot_width / 2 -mulitBarWidth/2 + offset_bar_x + offset_slot_x;
                double bar_y = origin_y - multinumbers[i][j] /  (modified_max ) * Y_len;
                Rectangle2D bar = new Rectangle2D.Double(bar_x, bar_y, bar_width, origin_y - bar_y);
                g.setColor(ColorSet.Medal[j % 3]);
                g.fill(bar);

                //draw numbers above each bar
                g.setColor(new Color(0, 0, 100, 80));
                int fontLen = g.getFontMetrics().stringWidth(String.valueOf(multinumbers[i][j]));
                g.drawString(String.valueOf(multinumbers[i][j]), (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (bar_y - 10));

            }
            //draw label
            String n = names[i];
            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            int fontLen = g.getFontMetrics().stringWidth(n);
            g.drawString(n, (int) (origin_x + offset_slot_x + bar_slot_width / 2 - fontLen / 2), (int) (origin_y + 20 + 10));

        }



/*
        for (int i = 0; i < numbers.length; i++) {
            double offset_bar_x = bar_slot_width * i;
            double bar_x = origin_x + bar_slot_width / 2 - bar_width / 2 + offset_bar_x;
            double bar_y = origin_y - numbers[i] / (max_num * 21 / 20) * Y_len;
            Rectangle2D bar = new Rectangle2D.Double(bar_x, bar_y, bar_width, origin_y - bar_y);
            g.setColor(new Color(0, 0, 100, 60));
            g.fill(bar);
            String n = names[i];
            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            int fontLen = g.getFontMetrics().stringWidth(n);
            g.drawString(n, (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (origin_y + 20 + 10));
            g.setColor(new Color(0, 0, 100, 80));
            g.drawString(String.valueOf(numbers[i]), (int) (bar_x + bar_width / 2 - fontLen / 2), (int) (bar_y - 10));
        }
*/

        // draw labels


    }







}


/**
 import javax.swing.*;
 import java.awt.*;



 import java.awt.*;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;
 import java.awt.event.WindowListener;

 import javax.swing.JFrame;
 import javax.swing.JPanel;

 public class Barchart extends JPanel {
 private double[] values;

 private String[] names;

 private String title;

 private Color BackgroundColor;

 public Barchart(double[] v, String[] n, String t) { //constructor
 names = n;
 values = v;
 title = t;
 }

 @Override
 public void paintComponent(Graphics g0) {
 //swing 组件使用paintComponet方法绘制图形，在显示框架或重新定位框架时，调用该方法。
 Graphics2D g = (Graphics2D) g0;// graphic 类是在不同的平台的屏幕显示图形和图像的抽象类，Graphics类在本地的平台JVM类执行，
 //当使用paintComponent 方法在图形上下文g上绘制时，这个g就是指定平台的抽象类Graphics的一个实例，Graphics类封装了平台的细节
 //使得可以不考虑平台的类型，绘制统一图形。
 super.paintComponent(g); //清空之前的浏览区域，若不调用，则会显示之前的图
 setBackground(new Color(105, 105, 105, 50));

 // find max and min of a datalist
 double minValue = 0;
 double maxValue = 0;
 for (int i = 0; i < values.length; i++) {
 if (minValue > values[i])
 minValue = values[i];
 if (maxValue < values[i])
 maxValue = values[i];
 }

 //Dimension d = getSize(); //the combination of Component's height and breadth
 int frame_width  = 900;
 int frame_height = 600;
 int clientWidth = frame_width-300;
 int clientHeight = frame_height-200;
 int barWidth = clientWidth / values.length; //divide the length to parts according to the numbers of bar

 //set title Font and label Font
 Font titleFont = new Font("DialogInput", Font.BOLD, 20);
 FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
 FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

 int titleWidth = titleFontMetrics.stringWidth(title);
 int y = titleFontMetrics.getAscent();
 int x = (clientWidth - titleWidth) / 2;
 g.setFont(titleFont);
 g.drawString(title, x, y);

 int top = titleFontMetrics.getHeight();
 int bottom = labelFontMetrics.getHeight();
 if (maxValue == minValue)
 return;
 double scale = (clientHeight - top - bottom) / (maxValue - minValue);
 y = clientHeight - labelFontMetrics.getDescent();
 g.setFont(labelFont);

 //draw bars
 for (int i = 0; i < values.length; i++) {
 int valueX = i * barWidth + 1;
 int valueY = top;
 int height = (int) (values[i] * scale);   //height of bar
 if (values[i] >= 0)
 valueY += (int) ((maxValue - values[i]) * scale);
 else {
 valueY += (int) (maxValue * scale);
 height = -height;
 }

 g.setColor(new Color(20,50,75));
 g.fillRect(valueX, valueY, barWidth - barWidth/3, height);
 g.setColor(Color.black);
 g.drawRect(valueX, valueY, barWidth - barWidth/3, height);
 int labelWidth = labelFontMetrics.stringWidth(names[i]);
 x = i * barWidth + (barWidth - labelWidth) / 2;
 g.drawString(names[i], x, y);
 }
 }


 }


 }
 */
