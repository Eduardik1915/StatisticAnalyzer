import java.io.IOException;

public class Decrypt {

    public static void decryptWithKey(String source, String dest, int key) throws IOException {
        Encrypt.encrypt(source, dest, Alphabet.alphabetLength() - key);
    }

    public static void bruteForce(String source, String dest) throws IOException {
        for (int i = 0; i < Alphabet.alphabetLength(); i++){
            Encrypt.encrypt(source, dest, i);
            if (Validate.validate(dest)){
                System.out.println("Текст взломан!");
                break;
            }
        }
    }
}
