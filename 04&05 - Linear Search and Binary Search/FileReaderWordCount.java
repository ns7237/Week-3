import java.io.*;

public class FileReaderWordCount {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\neera\\IdeaProjects\\linearsearch\\src\\example.txt"; // Replace with the path to your file
        String targetWord = "java"; // Replace with the word you want to count
        int wordCount = 0;

        BufferedReader reader = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using space as delimiter
                String[] words = line.split("\\s+");

                // Check each word in the line
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }

            // Print the total occurrences of the target word
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
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
