import CSVReader.DataFrame;
import CSVReader.DataList;
import CSVReader.MultiDataList;
import Chart.Barchart;
import Chart.MultiBarchart;
import Chart.Piechart;
import Chart.Scatter;
import Panel.BarPanel;
import Panel.PiePanel;
import Panel.ScatterPanel;
import UsingClass.MathAndConvert;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        //testing input arguments
        String arg0 = ".\\testData\\employees.csv"; //data path
        String medalTable = ".\\testData\\MedalTableShort.csv";
        String arg1 = "barChart"; // barchar, scatter, linechart ...
        String arg2 = "Name";   // column——》 get a array String[]
        String arg3 = "Salary";
        String arg4 = "Age";
        String[] columns = new String[]{"Gold", "Silver", "Bronze"};
        String[] indexnames = {"China","United States","Japan","Australia"};

        DataFrame df = new DataFrame(arg0);         //read data file, store in a dataframe
        DataFrame df2 = new DataFrame(medalTable);

        //get data from  one column of the dataframe
        String[] names = new DataList(df, arg2).dataLineStr;
        String[] valuesStr1 = new DataList(df, arg3).dataLineStr;
        String[] valuesStr2 = new DataList(df, arg4).dataLineStr;
        String[][] multiDataList = new MultiDataList(df2, columns).multidataStr;

        System.out.println(Arrays.deepToString(valuesStr1)); // test by print String
        System.out.println(multiDataList.length);
        System.out.println(Arrays.deepToString(multiDataList));

        // convert a String[] to a double[] by using stream
        //Double[] maybe better.  if String[] contains a null, bellow expression will cause error.
        double[] values1 = Arrays.stream(valuesStr1).mapToDouble(Double::parseDouble).toArray(); //transform String[] to int[]
        double[] values2 = Arrays.stream(valuesStr2).mapToDouble(Double::parseDouble).toArray();
        double[][] multivalues = MathAndConvert.str2ToDouble2(multiDataList);

        // plot charts
        new BarPanel(values1, names, "Each Employees' Salary");
        new BarPanel(values1, names, "Each Employees' Salary",1);
        new ScatterPanel(values2, values1,"age", "salary", "Employee's Age and Salary ScatterChart");
        new PiePanel(values1, names, "Each Employees' Salary");
        //there is some errors in multimentional array when parse csv, so multibarchart is not accurate
        new BarPanel(multivalues, indexnames,columns, "Tokyo Olympic Medal Table");
/*

//save image
            BufferedImage myImage = null;
            try {
                myImage = new Robot().createScreenCapture(
                        new Rectangle(0,0,1920,1080));
                ImageIO.write(myImage, "jpg", new File(".\\testData"));
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
 */
        }
}
