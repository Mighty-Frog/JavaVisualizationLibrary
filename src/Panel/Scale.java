package Panel;

import UsingClass.MathAndConvert;

/**
 * @author Jin Cheng
 */

public class Scale {
    //suppose number_max and number_min are all positive
    public static double getScaleStepFromRaw(double number_max, double number_min, int scale_num){
        double max = getRealMax(number_max, number_min);
        double min = getRealMin(number_max,number_min);
        return MathAndConvert.getScaleStep(max, min, scale_num);
    }

    public static double getRealMax(double number_max, double number_min){
        double max = number_max + 0.1 * (number_max - number_min);
        return max;
    }

    public static double getRealMin(double number_max, double number_min){
        double max = number_max + 0.1 * (number_max - number_min);
        double min = number_max + 0.1 * (number_max - number_min);
        if((max - min)/max >= 1/5){
            min = 0;}
        return min;
    }
}
