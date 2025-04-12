public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int n = 1000000;
        String str = "hello";
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
    }
}
