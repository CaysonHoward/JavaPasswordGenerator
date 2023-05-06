import java.io.*;
import java.util.*;


public class PasswordLoader {
    private static final String FILE_NAME = "passwords.txt";

    public static List<String> loadPasswordsFromFile() {
        List<String> passwords = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String password = scanner.nextLine();
                passwords.add(password);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The password file does not exist.");
        }

        return passwords;
    }
}
