package CSVReader;

import java.io.*;
import java.util.*;

/**
 * @author Jin Cheng
 */

public class DataFrame {
    /**
     * store the  CSV file as a String[][], first entry are headers of the csv
     *constructor:
     * @param file path
     * @param has header or not
     * @param (not mandatory) separator, for example" ", ",", default: ","
     * @param (not mandatory) header, the array of all column names
     * @return getdata() returns a String[][]
     */

    private String filePath = "";
    private String[][] dataset;
    private boolean hasHeader = true;
    private String [] header;
    public String separator = ",";
    public int rowNum = 0;
    public int columnNum = 0;
    //Sperator sp = null;

    public String getFilePath(){
        return filePath;
    }
    public String[] getHeader(){
        return header;
    }
    public String[][] getDataset(){
        return dataset;
    }

    //constructor 1
    public  DataFrame(String path, String separator) throws IOException {
        this.filePath =path;
        BufferedReader reader = new BufferedReader(new FileReader(
                filePath));
        //fill header
        Scanner scanner = null;
        String  line = reader.readLine();
        List<String> headerList = new ArrayList<>();
        scanner = new Scanner(line);
        scanner.useDelimiter(separator);
        while (scanner.hasNext()) {
            String data = scanner.next();
            headerList.add(data);
        }
        //get Column Number
        rowNum = headerList.size();
        header = headerList.toArray(new String[0]);

        //loops through every line until null found
        List<String[]> empList = new ArrayList<>();
        int index_row = 0;
        while ((line = reader.readLine()) != null) {  //// read file line by line
            String[] emp = new String[rowNum];
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            //scan each record
            while (scanner.hasNext()) {
                String data = scanner.next();
                emp[index_row] = data;
                index_row++;
            }
            index_row = 0;
            empList.add(emp);  // fill each record to the empList
            //get columNumber
            columnNum++;
        }
        //close reader
        reader.close();
        //set field dataset
        dataset = empList.toArray(new String[empList.size()][]);
        }
    //constructor 2
    public DataFrame(String path) throws IOException {
        this(path, ",");
    }
    //constructor 3
    public DataFrame(String path,  boolean hasHeader) throws IOException {
        this(path, ",");
    }

    //constructor 4
    public DataFrame(String path, String separator, boolean hasHeader) throws IOException {
        //if has header use same constructor
        this(path);
        //if not, insert header to new dataset and set header with numbers
        if(hasHeader == false){
            hasHeader = false;
            columnNum = columnNum + 1;
            String[][] temp = new String[columnNum][rowNum];
            temp[0] = header;
            for(int i=1; i< columnNum; i++) {
                temp[i] = dataset[i-1];
            }
            for(int i=0; i< rowNum; i++){
                header[i] = String.valueOf(i+1);
            }
        }
     }

    //constructor 5
    public DataFrame(String path, String separator, boolean hasheader, String[] columnNames) throws IOException {
        this(path,separator,hasheader);
        header = columnNames;
    }

    //constrcutor 6
    public DataFrame(String path, boolean hasheader, String[] columnNames) throws IOException {
        this(path,",", hasheader,columnNames);
    }

    //file save
    public void saveFile(String pathName) throws IOException {
        File file = new File(pathName);  //file stored data
        FileWriter out = new FileWriter(file);
        //write record to the file, each data is separated by ","
        for(int i=0;i<rowNum;i++){
            out.write(header[i]+",");
        }
        out.write("\r\n");

        for(int i=0;i<columnNum;i++){
            for(int j=0;j<rowNum;j++){
                out.write(dataset[i][j]+",");
            }
            out.write("\r\n");
        }
        out.close();
    }

    //Test
    public static void main(String[] args) throws IOException {
        String path = ".\\testData\\employees.csv";
        DataFrame df = new DataFrame(path, true);
        System.out.println(Arrays.deepToString(df.dataset));
        System.out.println("column number :"+ df.columnNum);
        System.out.println("header:"+ Arrays.deepToString(df.header));
        System.out.println("row number:"+ df.rowNum);
        System.out.println(3 + 'i');
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s) ;
        System.out.println(s.hashCode() + " " + sb.hashCode());
    }
}



