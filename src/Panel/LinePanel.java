package Panel;

import Chart.LineChart;
import Chart.Piechart;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Chart.Barchart;

/**
 * @author Jin Cheng
 */

public class LinePanel {

    public int frame_width = 1200;
    public int frame_height = 1000;
    JFrame j = new JFrame();
    Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();// get screen size

    public LinePanel(double[] values, String[] names, String title){
        j.setBounds((screenSize.width-frame_width)/2, (screenSize.height-frame_height)/2,frame_width,frame_height);
        //j.add(new LineChart());


        WindowListener wndCloser = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        j.addWindowListener(wndCloser);
        j.setVisible(true);

    }

}
