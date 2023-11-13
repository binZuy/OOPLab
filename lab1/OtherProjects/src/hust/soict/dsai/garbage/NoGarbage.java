package hust.soict.dsai.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        createGarbage();
    }

    private static void createGarbage() {
        long startTime = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            stringBuilder.append("This is some garbage string ").append(i);
        }
        String noGarbage = stringBuilder.toString();

        System.out.println("Time taken to create string without garbage: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
