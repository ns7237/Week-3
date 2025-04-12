import java.io.*;

public class InputStreamreaderToFile {

    public static void main(String[] args) {
        // Specify the output file where user input will be written
        String fileName = "user_input.txt"; // Output file name

        // Use try-with-resources to automatically close resources
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(fileName, true); // 'true' enables appending to the file
             BufferedWriter fileBufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (true) {
                // Read user input from the console
                input = consoleReader.readLine();

                // If user enters "exit", stop the input loop
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                // Write the input to the file, adding a new line after each input
                fileBufferedWriter.write(input);
                fileBufferedWriter.newLine(); // Add a newline after each entry
            }

            System.out.println("Input has been written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
