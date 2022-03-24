import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Validate {

    public static boolean validate(String file) {
        int conditionTrue = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String text = reader.readLine();
                String[] arr = text.split("[а-я],");
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i].startsWith(" ")) {
                        conditionTrue++;
                    } else {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conditionTrue > 0;
    }
}
