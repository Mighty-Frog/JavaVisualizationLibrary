package Chart;

import Accessories.Title;
import Tools.ColorSet;
import Panel.PiePanel;
import Tools.MathAndConvert;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * @author Jin Cheng
 */

public class Piechart extends JPanel {
    String title = "Each Employee's Salary Proportion";
    double[] nums;
    String[] names;
    PiePanel pp = new PiePanel();
    Color[] colorSet = ColorSet.light;

    public void setTitle(String s){
        this.title = s;
    }

    public Piechart(double[] nums, String[] names){
        this.names = names;
        this.nums = nums;
    }

    public Piechart(double[] nums, String[] names, String title ){
        this(nums,names);
        this.title = title;
    }

    @Override
    public void paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        super.paintComponent(g);
        //Remove stroke jaggies
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        //Remove text jaggies
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //Remove graph jaggies
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g); //清空之前的浏览区域，若不调用，则会显示之前的图
        setBackground(new Color(205, 205, 205,50));
        double sum = Arrays.stream(nums).parallel().reduce(0, Double::sum);
        int size = nums.length;
        double angleIncrease = 360 / sum;
        double startnAgle = 90;
        double arcAngle = 0;
        double labelAngle = 0;

        //draw title
        new Title(title,pp.pie_heart_x, pp.pie_heart_y,pp.pie_diameter).drawTitle_pie(g);

        //a loop to print every arc
        for (int i = 0; i < size; i++) {
            // each element's angle
            arcAngle = nums[i] * angleIncrease;
            // label angle using for making name of the element
            labelAngle = startnAgle + arcAngle / 2 - 90;
            //System.out.println("labelAngle: " + labelAngle);
            // iterated 14 colors in the colorSet
            g.setColor(colorSet[i % colorSet.length]);
            // draw arc, x,y the upper left coordinate,here is ((1000-500)/2,(1000-500)/2,)
            g.fillArc((pp.frame_width - pp.pie_diameter) / 2, (pp.frame_height - pp.pie_diameter) / 2, pp.pie_diameter, pp.pie_diameter, (int) Math.round(startnAgle), (int) Math.round(arcAngle));

            //System.out.println("startAngle: " + (startnAgle - 90));
            // update the start angle for next element;
            startnAgle += arcAngle;
            //set the font and color of each element's name
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.black);
            int stringLength = g.getFontMetrics().stringWidth(names[i]);
            //get label position and print them., NOTICE: angle must be transform to radians to get trigonometric value;
            double str_position_x = pp.pie_heart_x - Math.sin(Math.toRadians(labelAngle)) * pp.pie_radius;
            double str_position_y = pp.pie_heart_y - Math.cos(Math.toRadians(labelAngle)) * pp.pie_radius;
            double percentage_position_x = pp.pie_heart_x - (Math.sin(Math.toRadians(labelAngle)) * pp.pie_radius)/2;
            double percentage_position_y = pp.pie_heart_y - (Math.cos(Math.toRadians(labelAngle)) * pp.pie_radius)/2;
            if (labelAngle < 180) {
                g.drawString(names[i], (float) str_position_x - stringLength - 10, (float) str_position_y);
                //print percentage
                g.drawString(MathAndConvert.percentage(arcAngle/360), (float) percentage_position_x  , (float) percentage_position_y);

            } else {
                g.drawString(names[i], (float) str_position_x + 10, (float) str_position_y);
                //print percentage
                g.drawString(MathAndConvert.percentage(arcAngle/360), (float) percentage_position_x  , (float) percentage_position_y);

            }
        }

        //draw border of each arc
        for (int i = 0; i < size; i++) {
            // each element's angle
            arcAngle = nums[i] * angleIncrease;
            // label angle using for making name of the element
            g.setColor(Color.white);
            g.drawArc((pp.frame_width - pp.pie_diameter) / 2, (pp.frame_height - pp.pie_diameter) / 2, pp.pie_diameter, pp.pie_diameter, (int) Math.round(startnAgle), (int) Math.round(arcAngle));
            startnAgle += arcAngle;
        }



        // element label cube
        int labelColorCubeSize = 15;
        int lableColorCubeNum = 0;
        int stringLength = 0;
        int stringLengthSum = 0;
        int layer = 0;
        for (int i = 0; i < size; i++) {
            g.setColor(colorSet[i % colorSet.length]);
            int colorCube_x = pp.pie_position_x +(labelColorCubeSize+1) * lableColorCubeNum + stringLengthSum ;
            int colorCube_y = pp.pie_position_y+ pp.pie_diameter + 50 + layer * (labelColorCubeSize + 5);

            g.fillRect(colorCube_x, colorCube_y, labelColorCubeSize,labelColorCubeSize);
            lableColorCubeNum ++; // update cube nums


            //draw words
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.black);
            stringLength = g.getFontMetrics().stringWidth(names[i]) + 5;

            int lable_x = pp.pie_position_x +(labelColorCubeSize +1) * lableColorCubeNum + stringLengthSum;
            int lable_y =  pp.pie_position_y+ pp.pie_diameter + 50 +  layer * (labelColorCubeSize + 5) + labelColorCubeSize ;
            g.drawString(names[i], lable_x, lable_y );

            stringLengthSum += stringLength;

            if(colorCube_x + (labelColorCubeSize+1) + stringLength >=pp.pie_heart_x + pp.pie_diameter/2){
                lableColorCubeNum= 0;
                stringLengthSum = 0;
                layer++;
            }

            //System.out.println("0000000000     " + (pp.pie_position_x ));
            //System.out.println("0000000000    " + pp.pie_position_y + pp.pie_diameter*1);

      }
        //System.out.println("pp.pie_heart_x: " + pp.pie_heart_x + " pp.pie_heart_y: " + pp.pie_heart_y);
        //g.setFont(new Font("arial", Font.PLAIN, 10));
        //g.drawString("CenterPositoinTest", (float)pp.pie_heart_x , (float) pp.pie_heart_y);
    }

}
