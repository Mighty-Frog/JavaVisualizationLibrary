package additionalFunction;

/**
*
 */
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author
 */
public class Draw3D {
    public static void main(String[] args) throws IOException {
        BufferedImage img = new BufferedImage(500,500, BufferedImage.TYPE_INT_RGB); // 创建画布

        Graphics2D g = (Graphics2D) img.getGraphics();
        g.setColor(Color.magenta);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //抗锯齿，避免栅格严重

        g.fillRect(0, 0, 100, 100); //清除背景， 会将颜色设为白色

        g.setColor(new Color(0, 0, 0)); //设置颜色为黑色

        g.setFont(new Font("黑体", Font.PLAIN, 18)); //设置字体

        g.drawString("hi", 200, 200); //绘制文本

//画线

        g.draw(new Line2D.Double(70, 70, 270, 270));

//利用形状绘图

        Shape circle = new Arc2D.Double(20, 20, 90, 90, 0, 360, Arc2D.CHORD); //整圆

        g.fill(circle); //填充

        g.draw(circle); //绘制轮廓

//路径

        GeneralPath path = new GeneralPath();

        path.moveTo(500, 500);

        path.lineTo(400, 400);

        path.closePath();

        g.fill(path); //填充

        g.draw(path); //绘制轮廓

//注：路径支持直线和贝塞尔曲线，但残疾的是不支持圆弧，

//如果需要对含有圆弧的区域进行填充就只能自己拆分成多边形拟合了

        String imgPath = "D:\\BOOK-SHELF";
       // BufferedImage img = ImageIO.read(new File(imgPath)); //加载图像

        String fileName = "bigimage";
        ImageIO.write(img, "png", new File(fileName)); //保存图像

        g.drawImage(img, 400, 400, null); //绘制图像，支持拉伸
    }
}

