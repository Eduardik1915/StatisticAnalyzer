public class Decrypt {
    public final static int arrLength = Alphabet.alphabetLength();

    public static void decryptWithKey(String source, String dest, int key) {
        int decryptKey = key % arrLength;
        Encrypt.encrypt(source, dest, Alphabet.alphabetLength() - decryptKey);
    }
}
