public class ConcatenateStringsUsingStringBuffer {
    public static String concatenateStrings(String[] strings) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};
        String result = concatenateStrings(strings);
        System.out.println("Concatenated String: " + result);
    }
}
