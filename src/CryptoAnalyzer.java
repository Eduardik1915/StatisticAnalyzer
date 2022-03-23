import java.io.IOException;
import java.util.Scanner;

public class CryptoAnalyzer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String source;
        String dest;
        String dictionary;
        int key;

        System.out.print("""
                Выберите операцию:
                1. Шифрование
                2. Расшифровка
                3. Взлом(brute force)
                4. Анализ
                5. Выход
                """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("В ведите путь к файлу для шифрования:");
                source = FileCheck.inputPathCheck();
                System.out.println("В ведите путь для зашифрованого файла:");
                dest = FileCheck.outputPathCheck();
                System.out.println("В ведите ключ:");
                key = scanner.nextInt();
                Encrypt.encrypt(source, dest, key);
            }
            case 2 -> {
                System.out.println("В ведите путь к файлу для дешифрования:");
                source = FileCheck.inputPathCheck();
                System.out.println("В ведите путь для расшифрованого файла:");
                dest = FileCheck.outputPathCheck();
                System.out.println("В ведите ключ:");
                key = scanner.nextInt();
                Decrypt.decryptWithKey(source, dest, key);
            }
            case 3 -> {
                System.out.println("В ведите путь к файлу для дешифрования:");
                source = FileCheck.inputPathCheck();
                System.out.println("В ведите путь для расшифрованого файла:");
                dest = FileCheck.outputPathCheck();
                BruteForce.bruteForce(source, dest);
            }
            case 4 -> {
                System.out.println("Analyze");
                System.out.println("В ведите путь к файлу для дешифрования:");
                source = FileCheck.inputPathCheck();
                System.out.println("В ведите путь к файлу для анализа статистики:");
                dictionary = FileCheck.inputPathCheck();
                System.out.println("В ведите путь для расшифрованого файла:");
                dest = FileCheck.outputPathCheck();
                StatisticAnalyze.analyze(source, dest, dictionary);
            }
            case 5 -> System.out.println("Программа закрылась!");
            default -> System.out.println("Вы в выбрали неверную команду.");
        }
    }
}
