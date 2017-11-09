package coursera.week1;

import org.junit.Test;

import java.io.*;

public class FileReadDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("src/main/resources/input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fi));
            String line;
            // System.out.println(System.getProperty("user.dir"));
            while ((line = br.readLine()) != null) {
                int tmp = Integer.parseInt(line);
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
