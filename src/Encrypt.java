import java.io.*;

public class Encrypt {
    private final static char[] arr = Alphabet.sortedAlphabet();
    public final static int arrLength = Alphabet.alphabetLength();

    public static void encrypt(String sourceFile, String destFile, int key) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))
        ) {
            while (reader.ready()) {
                char t = Character.toLowerCase((char) reader.read());
                for (int i = 0; i < arrLength; i++) {
                    if (arr[i] == t) {
                        writer.write(arr[(i + key) % arrLength]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Готово!");
    }
}
