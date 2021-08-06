package CSVReader;

import CSVReader.DataFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jin Cheng
 */

//将特定列的数据传入到一个array里 ，String[]
public class DataList {
    public String[] dataLineStr;
    public double[] dataLineDouble;
    public DataFrame df;
//String[][]; salary
    public DataList(DataFrame df, String name) {
        this.df = df;
        this.dataLineStr = new String[df.columnNum];
        for(int i = 0; i < df.rowNum; i++) {
            if(df.getHeader()[i].equals(name)){
                for(int j = 0; j < df.columnNum; j++) {
                    dataLineStr[j] = df.getDataset()[j][i];
                }
            }

        }
    }
    public static double[] toDouble(String[] dataLine){
       double[] dataLineDouble = Arrays.stream(dataLine).mapToDouble(Double::parseDouble).toArray();
       return dataLineDouble;
    }

    public static void main(String[] args) throws IOException {
        DataFrame df = new DataFrame(".\\testData\\employees.csv");
        DataList dl = new DataList(df,"Name");
        System.out.println(Arrays.toString(dl.dataLineStr));
    }


}
