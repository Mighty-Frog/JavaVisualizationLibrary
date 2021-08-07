package Panel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

import Chart.Scatter;

/**
 * @author Jin Cheng
 */

public class ScatterPanel {

    public int frame_width = 1200;
    public int frame_height = 1000;
    JFrame j = new JFrame();
    Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();// get screen size

    public ScatterPanel(double[] numbers_x, double[] numbers_y,String name_x, String name_y, String title){
        j.setBounds((screenSize.width-frame_width)/2, (screenSize.height-frame_height)/2,frame_width,frame_height);
        j.add(new Scatter(numbers_x, numbers_y,name_x, name_y, title));
        j.setVisible(true);
//        WindowListener wndCloser = new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
 //       };
 //       j.addWindowListener(wndCloser);

    }

}
