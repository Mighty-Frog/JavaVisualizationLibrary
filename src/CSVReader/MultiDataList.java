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
public class MultiDataList {
    public DataFrame df;
    public String [][] multidataStr;
    public double[][] multidataDouble;

    //String[][]; salary
    public MultiDataList(DataFrame df, String[] names) {
        this.df = df;
        this.multidataStr = new String[df.columnNum][names.length];
        int k =0;
        for(int i = 0; i < df.rowNum; i++) {
            //k < names.length should put in front of conditions
            if( k < names.length && df.getHeader()[i].equals(names[k])){
                System.out.println(df.getHeader()[i]+names[k]);
                for(int j = 0; j < df.columnNum; j++) {
                    //data in dataset is the transpose version of in dataLine
                    multidataStr[j][k] = df.getDataset()[j][i];
                }
                k++;
            }
        }

    }

    //method to convert 2-D String Array to 2-D double array

    public void str2Todouble2() {
        this.multidataDouble =  Arrays.stream(this.multidataStr).map(s
                -> Arrays.stream(s).mapToDouble(Double::parseDouble).toArray())
                .toArray(double[][]::new);
    }

    public static void main(String[] args) throws IOException {
        DataFrame df = new DataFrame(".\\testData\\employees.csv");

        //there is bug there, if input is "Age","Salary", then the second line are full of null
        MultiDataList mdl = new MultiDataList(df, new String[]{ "Salary","Age",});
        mdl.str2Todouble2();
        System.out.println(Arrays.deepToString(mdl. multidataDouble));
    }
}

