import java.util.*;

public class Main {
    public static void main(String[] args) {

        int passwordLength = PasswordGenerator.getPassLength();
        String password = PasswordGenerator.generatePass(passwordLength);
        System.out.println("Generated Password: " + password);

        PasswordSaver.savePasswordToFile(password);
        List<String> savedPasswords = PasswordLoader.loadPasswordsFromFile();
        System.out.println("Saved Passwords: " + savedPasswords);
    }
}
