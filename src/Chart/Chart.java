package Chart;

import javax.swing.*;

/**
 * @author Jin
 */
public abstract class Chart extends JPanel {
    //char body info
    public int origin_x = 200;
    public int origin_y = 700;
    public int X_len = 800;
    public int Y_len = 500;

    public int slot_num_x = 12 ;

    public void set_X_len(int  l){
        this.X_len = l;
    }

    public void set_Y_len(int  l){
        this.Y_len = l;
    }

    public void set_origin_position(int x, int y){
        this.origin_x = x;
        this.origin_y = y;
    }

}
