import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("В ведите путь к файлу, который необходимо зашифровать или расшифровать");
        System.out.print("Путь к файлу: ");
        Path pathToTheFile = Path.of("C:\\Users\\esmulko\\IdeaProjects\\Kriptoanalizator\\sometext.txt");
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
                writer.write(reader.read()+1);
            }
        }








    }
}
