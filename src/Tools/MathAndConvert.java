package Tools;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class MathAndConvert {
    //show the percentage of an angle (360 degree)
    public static String percentage(Object o) {
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(o);
    }

    //return the max or min of a array
    public static double max(double[] d) {
        return  Arrays.stream(d).max().getAsDouble();
    }
    public static int max(int[] d) {
        return  Arrays.stream(d).max().getAsInt();
    }

    public static double min(double[] d) {
        DoubleStream ds = Arrays.stream(d);
        return  ds.min().getAsDouble();
    }

    public static int min(int[] d) {
        return  Arrays.stream(d).max().getAsInt();
    }

    public static double max(double[][] d) {
      DoubleStream dd = Arrays.stream(d).flatMapToDouble(s -> Arrays.stream(s));
      return dd.max().getAsDouble();
    }

    public static double min(double[][] d) {
        DoubleStream dd = Arrays.stream(d).flatMapToDouble(s -> Arrays.stream(s));
        return dd.min().getAsDouble();
    }

    //convert 2D String array into 2D double Array
   public static double[][] str2ToDouble2(String[][] strArr) {
       double[][] result = Arrays.stream(strArr).map(s ->
               Arrays.stream(s).mapToDouble(Double::parseDouble).toArray())
               .toArray(double[][]::new);
        return result;
        //double[] values2 = Arrays.stream(valuesStr2).mapToDouble(Double::parseDouble).toArray();
//        return  Arrays.stream(strArr).map(s ->
 //               Arrays.stream(s).mapToDouble(Double::parseDouble).toArray()).toArray();
  };
    /*
Excel计算坐标轴刻度使用一种相对复杂的算法.根据最小值和最大值的符号不同，计算也不同(两个正值、两个负值或零，或者是一个正值、一个负值).计算根据:
● “设置坐标轴格式”对话框里的“坐标轴选项”标签中指定的主要刻度单位 ● 最小值(MIN) ● 最大值(MAX) 如果绘图数值都是正数，值坐标轴的最大刻度值自动成为第一个主要刻度单位，它大于等于此表达式所返回的值:
MAX + 0.05 * (MAX-MIN) 另外，值坐标轴的最大值自动成为大于或等于最大值的第一个主要单位.但是如果最大值和最小值之间的差大于最大值的16.667%，则值坐标轴的最小值自动为零.
如果最大值和最小值之间的差小于最大值的16.667%，则值坐标轴的最小值自动成为第一个主要单位，它小于或等于此表达式所返回的值:
MIN-[(MAX-MIN)/2]
但是请等等，如果这个图表是散点图或者是气泡图，则值坐标轴的最小值自动成为第一个主要单位，它小于或等于最小值.Microsoft没有显示主要刻度单位值是
     */
    /*
Excel calculates the axis scale using a relatively complex algorithm. The calculation differs depending on the sign of the minimum and maximum values (two positive values, two negative values or zero, or one positive and one negative value). The calculation is based on :
● The primary scale unit specified in the Axis Options tab of the Set Axis Format dialog box ● The minimum value (MIN) ● The maximum value (MAX) If the plotted values are positive, the maximum scale value of the value axis automatically becomes the first primary scale unit. It is greater than or equal to the value returned by this expression:
MAX + 0.05 * (MAX-MIN) In addition, the maximum value of the value axis automatically becomes the first primary unit greater than or equal to the maximum value. However, if the difference between the maximum value and the minimum value is greater than 16.667% of the maximum value, the minimum value of the value axis is automatically zero.
If the difference between the maximum value and the minimum value is less than 16.667% of the maximum value, then the minimum value of the value axis automatically becomes the first major unit, which is less than or equal to the value returned by this expression:
MIN-[(MAX-MIN)/2]
But wait, if the chart is a scatter or bubble chart, the minimum value of the value axis automatically becomes the first major unit, which is less than or equal to the minimum value.Microsoft does not show that the major scale unit value is

https://blog.csdn.net/lweiyue/article/details/91869984
    https://blog.csdn.net/tiangej/article/details/47731501
     http://www.cppblog.com/guogangj/archive/2009/08/26/94451.html?opt=admin
     */

// automatically generate scale step in 10, 20, 25 ,50 ,100
    public static double getScaleStep(double max, double min , int expected_scale_num){
        double total_gap = max - min;
        if(total_gap <= 0  ) {return 0;}
        double each_gap = total_gap / (expected_scale_num - 1);

        double exp = (int) (Math.log10(each_gap) - 1);
        if(exp < 0) { exp--; }
        int step = (int) (each_gap / Math.pow(10,exp));

        int interval_list[] = new int[] {1, 2, 5, 10 , 20 , 25, 50, 100};
        int interval = 10;
        for (int i = 1; i < interval_list.length ; i++) {
            if(step <= interval_list[i] + interval_list[i-1]/2){
                interval = interval_list[i];
                break;
            }
        }
        //get real scale
        double real_scale = interval * Math.pow(10,exp);
        return real_scale;
    }
    public static void main(String[] args){
        String[][] str= new String[][]{
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"},
        };
     //   double[][] dd = string2ToDouble2(str);
  //      System.out.println(Arrays.deepToString(dd));
    }


}




