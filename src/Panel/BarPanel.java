package Panel;

import Chart.HBarchart;
import Chart.MultiBarchart;
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
public class BarPanel {
    public int frame_width = 1200;
    public int frame_height = 1000;
    JFrame j = new JFrame();
    Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();// get screen size

    public BarPanel(double[] values, String[] names, String title,int horizonal){
        if(horizonal == 1) {
            j.setBounds((screenSize.width - frame_width) / 2, (screenSize.height - frame_height) / 2, frame_width, frame_height);
            j.add(new HBarchart(values, names, title));
            WindowListener wndCloser = new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            };
            j.addWindowListener(wndCloser);
            j.setVisible(true);
        }else{
            j.setBounds((screenSize.width - frame_width) / 2, (screenSize.height - frame_height) / 2, frame_width, frame_height);
            j.add(new Barchart(values, names, title));
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

    public BarPanel(double[] values, String[] names, String title){
        this(values, names, title, 0);
    }

    public BarPanel(double[][] multinumbers, String[] indexnames,String[] columns, String title){
        j.setBounds((screenSize.width-frame_width)/2, (screenSize.height-frame_height)/2,frame_width,frame_height);
        j.add(new MultiBarchart(multinumbers, indexnames,columns, "Tokyo Olympic Medal Table"));
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



