package Panel;

import Chart.Piechart;
import Chart.Scatter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jin Cheng
 */
public class PiePanel extends JPanel {
    public JFrame j = new JFrame();
    //height and width of the frame;
    public int frame_width = 1200;
    public int frame_height = 1000;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// get screen size
    // left top position of the frame;
    public int bounds_x = (screenSize.width - frame_width) / 2;
    public int bounds_y = (screenSize.height - frame_height) / 2;

    // pie graph info
    public int pie_diameter = 500;
    public int pie_radius = pie_diameter / 2;
    public int pie_position_x = (frame_width - pie_diameter) / 2;
    public int pie_position_y = (frame_height - pie_diameter) / 2;
    public int pie_heart_x = pie_position_x + pie_diameter / 2;
    public int pie_heart_y = pie_position_y + pie_diameter / 2;

    Piechart peichart = null;

    public PiePanel() {
    };

    public PiePanel(double[] values,String[] names, String title){
        PiePanel p = new PiePanel();
        j.setBounds((screenSize.width-frame_width)/2, (screenSize.height-frame_height)/2,frame_width,frame_height);
        j.add(new Piechart(values, names, title));
        //f.setVisible(true);
/*        WindowListener wndCloser = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        f.addWindowListener(wndCloser);
*/        }
    @Override
    public  void show(){
        j.setVisible(true);
    }

}

