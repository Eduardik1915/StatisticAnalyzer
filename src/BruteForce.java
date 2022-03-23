public class BruteForce {

    public static void bruteForce(String source, String dest) {
        for (int i = 0; i < Alphabet.alphabetLength(); i++){
            Decrypt.decryptWithKey(source, dest, 33);
            if (Validate.validate(dest)){
                System.out.println("Текст взломан ключём " + i);
                break;
            }
        }
    }
}
