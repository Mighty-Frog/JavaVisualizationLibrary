package Panel;

import java.awt.*;

/**
 * @author Jin Cheng
 */

public class Title {
    String title;
    int title_x;
    int title_y;
    int X_len;
    int Y_len;
    int origin_x;
    int origin_y;

    public Title(String title, int title_x, int title_y, int X_len, int Y_len, int origin_x, int origin_y){
        this.title = title;
        this.title_x = title_x;
        this.title_y = title_y;
        this.X_len = X_len;
        this.Y_len = Y_len;
        this.origin_x = origin_x;
        this.origin_y = origin_y;
    }

    public void drawTitle(Graphics2D g) {
        Font title_font = new Font("arial", Font.BOLD, 40);
        g.setFont(title_font);
        int title_len = g.getFontMetrics().stringWidth(title);
        title_x = origin_x + X_len / 2 - title_len / 2;
        title_y = origin_y - Y_len - 40 - 10;
        g.drawString(title, title_x, title_y);
    }
}
