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
public class BarPanel extends Panel{
    public int frame_width = 1200;
    public int frame_height = 1000;
    public JFrame j = new JFrame();
    HBarchart hBarchart;
    Barchart barchart;
    MultiBarchart multiBarchart;

    Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();// get screen size


    public BarPanel(double[] values, String[] names, String title,int horizonal){
        if(horizonal == 1) {
            j.setBounds((screenSize.width - frame_width) / 2, (screenSize.height - frame_height) / 2, frame_width, frame_height);
            this.hBarchart = new HBarchart(values, names, title);
            j.add(hBarchart);
            //j.setVisible(true);
        }else{
            j.setBounds((screenSize.width - frame_width) / 2, (screenSize.height - frame_height) / 2, frame_width, frame_height);
            this.barchart = new Barchart(values, names, title);
            j.add(barchart);
            //j.setVisible(true);
        }
        }

    public BarPanel(double[] values, String[] names, String title){

        this(values, names, title, 0);
    }

    public BarPanel(double[][] multinumbers, String[] indexnames,String[] columns, String title){
        j.setBounds((screenSize.width-frame_width)/2, (screenSize.height-frame_height)/2,frame_width,frame_height);
        this.multiBarchart = new MultiBarchart(multinumbers, indexnames,columns, "Tokyo Olympic Medal Table");
        j.add(multiBarchart);
        //j.setVisible(true);
    }
    @Override
    public  void show(){
        j.setVisible(true);
    }

    public void setColor(Color c){
        barchart.bar_color = c;
    }


}



