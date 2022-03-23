import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileCheck {

    public static String inputPathCheck() {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        Path path;
        while (true) {
            path = Path.of(scanner.nextLine());
            if (Files.isRegularFile(path)) {
                filePath = String.valueOf(path);
                break;
            } else {
                System.out.println("Неверный путь! В ведите ещё раз.");
            }
        }
        return filePath;
    }

    public static String outputPathCheck() {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        Path path;
        while (true) {
            path = Path.of(scanner.nextLine());
            Path parent = path.getParent();
            if (Files.isDirectory(parent)) {
                filePath = String.valueOf(path);
                break;
            } else {
                System.out.println("Неверный путь! В ведите ещё раз.");
            }
        }
        return filePath;
    }
}