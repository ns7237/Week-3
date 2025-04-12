import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\neera\\IdeaProjects\\linearsearch\\src\\example.txt"; // Replace with the absolute path of your file
        BufferedReader reader = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
