package ScientificPlot;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.Arrays;

import Chart.Chart;
import Chart.HistChart;
import Tools.MathAndConvert;

public class Distribution {
    Chart chart;
    double[][] numbers;
    int start_x;
    int start_y;
    int X_len = 800;
    int Y_len = 500;
    int bins;

    public Distribution(Chart chart, double[][] numbers, int origin_x, int origin_y) {
        this.chart = chart;
        this.numbers = numbers;
        this.start_x = origin_x + chart.X_len / chart.slot_num_x;
        this.start_y = origin_y;

    }
    /**
     * modified from http://qtdebug.com/java-smooth-curve/
     *
     * @param
     */
    public void draw( Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        GeneralPath distrCurve = new GeneralPath();

        distrCurve.moveTo(numbers[0][0], start_y);
        distrCurve.moveTo(numbers[0][0], numbers[0][1]);

        System.out.println();
        System.out.println("Arrays to deep "+Arrays.deepToString(numbers));
        System.out.println();

        for (int i = 0; i < numbers.length - 1; ++i) {
            double start_x = numbers[i][0];
            double start_y = numbers[i][1];
            double end_x = numbers[i + 1][0];
            double end_y = numbers[i + 1][1];
            double c1_x = (start_x + end_x) / 2;
            double c1_y = start_y;
            double c2_x = (start_x + end_x) / 2;
            double c2_y = end_y;
            distrCurve.curveTo(c1_x, c1_y, c2_x, c2_y, end_x, end_y);
        }

        //distrCurve.moveTo(numbers[numbers.length - 1][0], start_y);
        //distrCurve.moveTo(numbers[0][0], start_y);
        //distrCurve.moveTo(500, 500);
        g.draw(distrCurve);
        distrCurve.lineTo(numbers[numbers.length - 1][0], start_y);
        distrCurve.lineTo(numbers[0][0], start_y);
        distrCurve.lineTo(numbers[0][0], numbers[0][1]);
        //distrCurve.closePath();
        //g.draw(distrCurve);
        g.setColor(new Color(100,255,0,80));
        g.fill(distrCurve);
    }

}




