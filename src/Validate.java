import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Validate {
    public static boolean validate(String file) throws IOException {
         try(BufferedReader reader = new BufferedReader(new FileReader(file))){
             System.out.println("In progress");
         }
        return false;
    }
}
