import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileCheck {
    static Scanner scanner = new Scanner(System.in);

    public static String inputPathCheck() {
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
        String filePath;
        while (true) {
            Path path = Path.of(String.valueOf(scanner.nextLine()));
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