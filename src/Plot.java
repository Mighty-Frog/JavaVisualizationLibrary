import CSVReader.DataFrame;
import CSVReader.DataList;
import CSVReader.MultiDataList;
import Panel.BarPanel;
import Tools.MathAndConvert;
import Panel.ScatterPanel;
import Panel.LinePanel;
import Panel.PiePanel;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class Plot {
    DataFrame dataFrame;
    String chart;
    String column_name;
    double[][] multi_numbers;
    double[][] multi_names;
    double[] numbers;
    String[] names;
    BarPanel barChart;
    ScatterPanel scatterChart;
    LinePanel lineChart;
    PiePanel pieChart;

    public Plot(DataFrame dataFrame){
        this.dataFrame = dataFrame;
    }

    public BarPanel barChart(String values_column, String names_column, String title){
        String[] names = new DataList(dataFrame, names_column).dataLineStr;
        String[] values_String = new DataList(dataFrame, values_column).dataLineStr;
        double[] values_doule = Arrays.stream(values_String).mapToDouble(Double::parseDouble).toArray();
        this.barChart =  new BarPanel(values_doule, names, title);
        return barChart;
    }

    public BarPanel hBarChart(String values_column, String names_column, String title){
        String[] names = new DataList(dataFrame, names_column).dataLineStr;
        String[] values_String = new DataList(dataFrame, values_column).dataLineStr;
        double[] values_doule = Arrays.stream(values_String).mapToDouble(Double::parseDouble).toArray();
        this.barChart =  new BarPanel(values_doule, names, title,1);
        return barChart;
    }

    public BarPanel groupedBarChart(String[] column_names_of_multivalues, String[] indexnames, String title){
        String[][] multiDataList = new MultiDataList(dataFrame, column_names_of_multivalues).multidataStr;
        double[][] multinumbers = MathAndConvert.str2ToDouble2(multiDataList);
        this.barChart = new BarPanel(multinumbers, indexnames,column_names_of_multivalues, title);
        return barChart;
    }

    public ScatterPanel scatterChart(String column_name_value_x, String column_name_value_y, String title){
        String[] value_x_String = new DataList(dataFrame, column_name_value_x).dataLineStr;
        String[] value_y_String = new DataList(dataFrame, column_name_value_y).dataLineStr;
        double[] values_x_doule = Arrays.stream(value_x_String).mapToDouble(Double::parseDouble).toArray();
        double[] values_y_doule = Arrays.stream(value_y_String).mapToDouble(Double::parseDouble).toArray();
        this.scatterChart = new ScatterPanel(values_x_doule, values_y_doule,column_name_value_x,column_name_value_y,title);
        return scatterChart;
    }

    public LinePanel lineChart(String column_name_value_x, String column_name_value_y, String title){
        String[] value_x_String = new DataList(dataFrame, column_name_value_x).dataLineStr;
        String[] value_y_String = new DataList(dataFrame, column_name_value_y).dataLineStr;
        double[] values_x_doule = Arrays.stream(value_x_String).mapToDouble(Double::parseDouble).toArray();
        double[] values_y_doule = Arrays.stream(value_y_String).mapToDouble(Double::parseDouble).toArray();
        this.lineChart = new LinePanel(values_x_doule, values_y_doule,column_name_value_x,column_name_value_y,title);
        return lineChart;
    }

    public PiePanel pieChart(String values_column, String names_column, String title){
        String[] names = new DataList(dataFrame, names_column).dataLineStr;
        String[] values_String = new DataList(dataFrame, values_column).dataLineStr;
        double[] values_doule = Arrays.stream(values_String).mapToDouble(Double::parseDouble).toArray();
        this.pieChart =  new PiePanel(values_doule, names, title);
        return pieChart;
    }

    //HistPanel hist =  new HistPanel(values1,values1, 10, "Points Histogram");
   // public HistPanel histChart(String values_column, String names_column, String title){
      //  String[] names = new DataList(dataFrame, names_column).dataLineStr;
      //  String[] values_String = new DataList(dataFrame, values_column).dataLineStr;
      //  double[] values_doule = Arrays.stream(values_String).mapToDouble(Double::parseDouble).toArray();
     //   this.pieChart =  new PiePanel(values_doule, names, title);
      //  return pieChart;
   // }


}

