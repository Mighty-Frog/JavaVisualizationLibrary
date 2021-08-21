import CSVReader.DataFrame;
import CSVReader.DataList;
import CSVReader.MultiDataList;
import Chart.HistChart;
import Panel.BarPanel;
import Panel.HistPanel;
import Panel.PiePanel;
import Panel.ScatterPanel;
import ScientificPlot.Distribution;
import Tools.ColorSet;
import Tools.MathAndConvert;


import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Jin Cheng
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //testing input arguments
        String arg0 = ".\\testData\\employees.csv"; //data path
        String medalTable = ".\\testData\\MedalTableShort.csv";
        String employees5 = ".\\testData\\employees5.csv";
        String arg1 = "barChart"; // barchar, scatter, linechart ...
        String arg2 = "Name";   // column——》 get a array String[]
        String arg3 = "Salary";
        String arg4 = "Age";
        String[] columns = new String[]{"Gold", "Silver", "Bronze"};
        String[] indexnames = {"China","United States","Japan","Australia"};

        DataFrame df = new DataFrame(arg0);         //read data file, store in a dataframe
        DataFrame df2 = new DataFrame(medalTable);
        DataFrame df3 = new DataFrame(employees5);

        //get data from  one column of the dataframe
        String[] names = new DataList(df, arg2).dataLineStr;
        String[] valuesStr1 = new DataList(df, arg3).dataLineStr;
        String[] valuesStr2 = new DataList(df, arg4).dataLineStr;
        String[] valuesStr3 = new DataList(df3, arg3).dataLineStr;
        String[][] multiDataList = new MultiDataList(df2, columns).multidataStr;

        System.out.println(Arrays.deepToString(valuesStr1)); // test by print String
        System.out.println(multiDataList.length);
        System.out.println(Arrays.deepToString(multiDataList));

        // convert a String[] to a double[] by using stream
        //Double[] maybe better.  if String[] contains a null, bellow expression will cause error.
        double[] values1 = Arrays.stream(valuesStr1).mapToDouble(Double::parseDouble).toArray(); //transform String[] to int[]
        double[] values2 = Arrays.stream(valuesStr2).mapToDouble(Double::parseDouble).toArray();
        double[] values3 = Arrays.stream(valuesStr3).mapToDouble(Double::parseDouble).toArray();
        double[][] multivalues = MathAndConvert.str2ToDouble2(multiDataList);

        // plot charts
        BarPanel barpanel =    new BarPanel(values1, names, "Each Customer's points");
        barpanel.setColor(ColorSet.RoyalBlue);
        barpanel.show();


        BarPanel hpanel= new BarPanel(values1, names, "Each Customer's Points",1);
        //hpanel.show();

        //new ScatterPanel(values2, values1,"age", "salary", "Customers' Age and Points ScatterChart");
        //new PiePanel(values1, names, "Each Customer's Points");

       //new BarPanel(multivalues, indexnames,columns, "Tokyo Olympic Medal Table");
       // HistPanel hist =  new HistPanel(values1,values1, 10, "Points Histogram");
        //hist.drawDistri();
        //hist.show();

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
