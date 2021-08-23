import CSVReader.DataFrame;

import java.awt.*;
import java.io.IOException;

public class UserExample {
    public static void main(String[] args) throws IOException {
        char user_case = 'a';
        switch(user_case) {
            case 'a':
                String path = ".\\testData\\employees3.csv";
                DataFrame df = new DataFrame(path);
                Plot plot1 = new Plot(df);
                plot1.barChart("Age","Name","Each Customer");
                plot1.barChart.setColor(Color.green);
                plot1.barChart.show();
                break;

            case 'b':
                Plot plot2 = new Plot(new DataFrame(".\\testData\\employees3.csv"));
                plot2.hBarChart("Age","Name","Each Customer").show();
                break;

            case 'c':
                Plot plot3 = new Plot(new DataFrame(".\\testData\\MedalTableShort.csv"));
                plot3.groupedBarChart(new String[]{"Gold", "Silver", "Bronze"}, new String[]{"China", "United States", "Japan", "Australia"}, "Tokyo Olympic Medal Table");
                plot3.barChart.show();
                break;

            default :
                System.out.println("Unknown Case");
        }
    }




}
