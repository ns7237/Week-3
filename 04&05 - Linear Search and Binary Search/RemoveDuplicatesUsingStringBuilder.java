import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static String removeDuplicates(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!seen.contains(ch)) {
                seen.add(ch);
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }
}
