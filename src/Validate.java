import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Validate {
    public static boolean validate(String file) {
        int countPlus = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String text = reader.readLine();
                String[] arr = text.split(",");
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i].startsWith(" ")) {
                        countPlus++;
                    } else {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countPlus > 0;
    }
}
