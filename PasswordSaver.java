import java.io.*;
import java.util.*;

public class PasswordSaver {
    private static final String FILE_NAME = "passwords.txt";

    public static void savePasswordToFile(String password) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(password);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the password: " + e.getMessage());
        }
    }

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
