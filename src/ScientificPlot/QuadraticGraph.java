package ScientificPlot;
/*
* unfinished , just test
 */

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class QuadraticGraph extends JPanel {

        private static int SCALE_X = 40; // X轴缩放倍数
        private static int SCALE_Y = 100; // Y轴缩放倍数
        private static int ORIGIN_X = 50; // 原点X
        private static int ORIGIN_Y = 0; // 原点Y
        private static int END_ARC = 360 * 2; // 画多长

        @Override
        public void paintComponent(Graphics g0) {
            Graphics2D g = (Graphics2D) g0;
            double ox = 0, oy = 0, x = 0, y = 0, arc = 0;


            ORIGIN_Y = this.getHeight() / 2;

            // 画坐标轴
            g.drawLine(ORIGIN_X, ORIGIN_Y, this.getWidth(), ORIGIN_Y); // 横轴
            g.drawLine(ORIGIN_X, 0, ORIGIN_X, this.getHeight()); // 纵轴
            // 每90度画个标尺
            for (int i = 0; i < END_ARC; i += 90) {
                arc = Math.PI * i * 2 / 360;
                x = ORIGIN_X + arc * SCALE_X;
                g.drawLine((int) x, ORIGIN_Y - 10, (int) x, ORIGIN_Y + 10);
            }

            // 画正弦曲线
            g.setColor(Color.RED);
            for (int i = 0; i < END_ARC; i += 10) {
                arc = Math.PI * i * 2 / 360;
                x = ORIGIN_X + arc * SCALE_X;
                y = ORIGIN_Y + Math.sin(arc) * SCALE_Y;
                if (arc > 0) {
                    g.drawLine((int) ox, (int) oy, (int) x, (int) y);
                }
                ox = x;
                oy = y;
            }
        }

        public static void main(String[] args) {
            JFrame j = new JFrame();
            j.add(new QuadraticGraph());
            j.setSize(600, 500);
            j.setVisible(true);
            String[] a = new String[5];
            for (int i = 0; i <a.length ; i+=2) {
                a[i] = "1";
            }
        }
    }

