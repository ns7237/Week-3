import java.io.*;

public class InputStreamReaderExample {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\neera\\IdeaProjects\\linearsearch\\src\\example.txt";
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
