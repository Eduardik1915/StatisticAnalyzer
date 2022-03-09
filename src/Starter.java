import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("В ведите путь к файлу, который необходимо зашифровать или расшифровать");
        System.out.print("Путь к файлу: ");
        Path pathToTheFile = Path.of("C:/Users/esmulko/IdeaProjects/Kriptoanalizator/sometext.txt");
       // Path pathToTheFile = Path.of(scanner.nextLine());
        System.out.println("enter key");
        int key = scanner.nextInt();

   /*     System.out.println("Зашифровать файл => В ведите 1\nРасшифровать файл => В ведите 2\nВыйты из программы => В ведите 3");
        System.out.println("");
        if (scanner.nextInt() == 1) {
            System.out.println("В ведите ключ: от -25 до 25");
            int key = scanner.nextInt();
        } else if (scanner.nextInt() == 2){
            System.out.println("Тут пока пусто");
        }*/

        //file creating
        String parentPath = String.valueOf(pathToTheFile.getParent());
        String fileName = String.valueOf(pathToTheFile.getFileName());
        Path newPath = Path.of(parentPath + "\\new_" + fileName);
        if (Files.exists(newPath)) {
            Files.delete(newPath);
        }
        Files.createFile(newPath);


        try(
                BufferedReader reader = new BufferedReader(new FileReader(pathToTheFile.toFile()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(newPath.toFile()))
        ) {
            while (reader.ready()){
                writer.write(reader.read()+key);
            }
        }








    }
}
