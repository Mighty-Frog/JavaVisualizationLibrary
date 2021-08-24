import CSVReader.DataFrame;

import java.awt.*;
import java.io.IOException;

public class UserExample {
    public static void main(String[] args) throws IOException {
        String user_case = "f";
        switch(user_case) {
            case "a":
                String path = ".\\testData\\employees3.csv";
                DataFrame df = new DataFrame(path);
                Plot plot1 = new Plot(df);
                plot1.barChart("Point","Name","Each Customer's Points");
                plot1.barChart.show();
                break;

            case "a1":
                String path1 = ".\\testData\\employees3.csv";
                DataFrame df1 = new DataFrame(path1);
                Plot plot_k = new Plot(df1);
                plot_k.barChart("Point","Name","Each Customer's Points");
                plot_k.barChart.setColor(Color.red);
                plot_k.barChart.show();
                break;

            case "b":
                Plot plot2 = new Plot(new DataFrame(".\\testData\\employees3.csv"));
                plot2.hBarChart("Age","Name","Each Customer's Age").show();
                break;

            case "c":
                Plot plot3 = new Plot(new DataFrame(".\\testData\\MedalTableShort.csv"));
                plot3.groupedBarChart(new String[]{"Gold", "Silver", "Bronze"}, new String[]{"China", "United States", "Japan", "Australia"}, "Tokyo Olympic Medal Table");
                plot3.barChart.show();
                break;

            case "d":
                Plot plot4 = new Plot(new DataFrame(".\\testData\\employees2.csv"));
                plot4.scatterChart("Age", "Point", "Customer's Age and Points ScatterChart Sample");
                plot4.scatterChart.show();
                break;

            case "e":
                Plot plot5 = new Plot(new DataFrame(".\\testData\\production.csv"));
                plot5.lineChart("Version", "Production", "Production of each version");
                plot5.lineChart.show();
                break;

            case "f":
                Plot plot6 = new Plot(new DataFrame(".\\testData\\employees3.csv"));
                plot6.pieChart("Point", "Name", "Customers' Points PieChart");
                plot6.pieChart.show();
                break;

            default :
                System.out.println("Unknown Case");
        }
    }




}
