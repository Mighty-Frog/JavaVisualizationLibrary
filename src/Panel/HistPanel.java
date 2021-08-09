package Panel;

import Chart.*;
import ScientificPlot.Distribution;
//import Chart.HistChart;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jin Cheng
 */
public class HistPanel {
    HistChart histChart;
    public int frame_width = 1200;
    public int frame_height = 1000;
    JFrame j = new JFrame();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// get screen size

    public HistPanel(double[] values,
                     double[] counts,
                     int bins,
                     String title
                     ) {
        j.setBounds((screenSize.width - frame_width) / 2, (screenSize.height - frame_height) / 2, frame_width, frame_height);
        HistChart histChart = new HistChart(values, counts, bins, title);
        this.histChart = histChart;
        j.add(histChart);
        //j.setVisible(true);
    }
    public void show(){
        this.j.setVisible(true);
    }

    public void drawDistri(){


    }


}
