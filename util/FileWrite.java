package doctor.clinic.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite {

    public static <T> void writeToFile(String filename, List<T> list) {
        File myObj = new File(filename + ".txt");
        System.out.println("File created: " + myObj.getName());

        try {
            FileWriter myWriter = new FileWriter(filename + ".txt");
            for (T t : list) {
                myWriter.write(t.toString());
                myWriter.write(System.getProperty("line.separator"));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
