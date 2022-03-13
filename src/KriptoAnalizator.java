import java.io.*;
import java.util.Scanner;

public class KriptoAnalizator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // String sourceFile = "C:/Users/esmulko/IdeaProjects/Kriptoanalizator/sometext.txt";
        String sourceFile = "C:/Users/esmulko/IdeaProjects/Kriptoanalizator/skazka.txt";
        //String destFile = "C:/Users/esmulko/IdeaProjects/Kriptoanalizator/sometext_excrypt.txt";
        String destFile = "C:/Users/esmulko/IdeaProjects/Kriptoanalizator/skazka2.txt";
        String destFile2 = "C:/Users/esmulko/IdeaProjects/Kriptoanalizator/skazka3.txt";

        System.out.println("В ведите путь к файлу, который необходимо зашифровать или расшифровать");
        String source = destFile;//scanner.nextLine();
        System.out.println("В ведите путь к новому файлу, в который будет записан результат");
        String dest = destFile2;//scanner.nextLine();

        System.out.print("""
                Выберите операцию:
                Шифрование => в ведите 1
                Расшифровка => в ведите 2
                Взлом(brute force) => в ведите 3
                """);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("В ведите ключ:");
                int key = scanner.nextInt();
                Encrypt.encrypt(source, dest, key);
            }
            case 2 -> {
                System.out.println("В ведите ключ:");
                int key2 = scanner.nextInt();
                Decrypt.decryptWithKey(source, dest, key2);
            }
            case 3 -> {
                System.out.println("brute force");
                Decrypt.bruteForce(source, dest);
            }
            default -> {
                System.out.println("default");
            }
        }
    }
}
