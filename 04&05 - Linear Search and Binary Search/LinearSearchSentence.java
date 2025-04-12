public class LinearSearchSentence {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Hello, how are you today?",
                "The weather is nice today."
        };

        String word = "weather";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);

        word = "apple";
        result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);
    }
}
