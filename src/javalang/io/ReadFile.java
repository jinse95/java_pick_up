package javalang.io;

import java.io.*;

/**
 * @author J
 * @time 2018/11/15 21:05
 * @description
 **/
public class ReadFile {

    public static void main(String[] args) {
        String fileName = "d:/workspace/data/test.md";
        File file = new File(fileName);
        System.out.println(file.isDirectory());
        try (
                InputStream stream = new FileInputStream(file);
                InputStreamReader reader = new FileReader(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (
                FileWriter fileWriter = new FileWriter(fileName, true);
        ) {
            fileWriter.write("\r\n");
            fileWriter.write("换行了");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
