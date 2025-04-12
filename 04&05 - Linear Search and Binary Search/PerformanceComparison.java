import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PerformanceComparison {

    public static void main(String[] args) {
        // Measure StringBuilder and StringBuffer performance for string concatenation
        String testString = "hello";  // String to concatenate
        int iterations = 1000000;  // Number of times to concatenate

        // Measure StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("StringBuilder took: " + stringBuilderTime / 1000000 + " milliseconds");

        // Measure StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(testString);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("StringBuffer took: " + stringBufferTime / 1000000 + " milliseconds");
        // Measure FileReader and InputStreamReader performance for file reading
        String fileName = "C:\\Users\\neera\\IdeaProjects\\linearsearch\\src\\example.txt";; // Ensure this file exists and is large (100MB)

        // Measure FileReader
        try {
            startTime = System.nanoTime();
            int wordCountFileReader = countWordsWithFileReader(fileName);
            endTime = System.nanoTime();
            long fileReaderTime = endTime - startTime;
            System.out.println("FileReader took: " + fileReaderTime / 1000000 + " milliseconds");
            System.out.println("FileReader word count: " + wordCountFileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Measure InputStreamReader
        try {
            startTime = System.nanoTime();
            int wordCountInputStreamReader = countWordsWithInputStreamReader(fileName);
            endTime = System.nanoTime();
            long inputStreamReaderTime = endTime - startTime;
            System.out.println("InputStreamReader took: " + inputStreamReaderTime / 1000000 + " milliseconds");
            System.out.println("InputStreamReader word count: " + wordCountInputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to count words using FileReader
    public static int countWordsWithFileReader(String fileName) throws IOException {
        int wordCount = 0;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        bufferedReader.close();
        return wordCount;
    }

    // Method to count words using InputStreamReader
    public static int countWordsWithInputStreamReader(String fileName) throws IOException {
        int wordCount = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        bufferedReader.close();
        return wordCount;
    }
}
