import java.security.SecureRandom;
import java.util.*;


public class PasswordGenerator {
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}<>";

    public static int getPassLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired length of the password(Password will always be at least 4 characters long): ");
        int length = scanner.nextInt();
        scanner.close();
        return length;
    }

    public static String generatePass(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Add at least one character from each character set
        password.append(getRandomChar(UPPERCASE_CHARACTERS));
        password.append(getRandomChar(LOWERCASE_CHARACTERS));
        password.append(getRandomChar(NUMBERS));
        password.append(getRandomChar(SPECIAL_CHARACTERS));

        // Add remaining characters randomly
        for (int i = 4; i < length; i++) {
            String characterSet = getRandomChar();
            password.append(getRandomChar(characterSet));
        }

        //Shuffle the password to make the characters random
        char[] passwordChars = password.toString().toCharArray();
        for (int i = passwordChars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordChars[index];
            passwordChars[index] = passwordChars[i];
            passwordChars[i] = temp;
        }

        return new String(passwordChars);
    }

    private static char getRandomChar(String characterSet) {
        SecureRandom random = new SecureRandom();
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }

    private static String getRandomChar() {
        SecureRandom random = new SecureRandom();
        int randomIndex = random.nextInt(4);
        switch (randomIndex) {
            case 0:
                return UPPERCASE_CHARACTERS;
            case 1:
                return LOWERCASE_CHARACTERS;
            case 2:
                return NUMBERS;
            case 3:
                return SPECIAL_CHARACTERS;
            default:
                return UPPERCASE_CHARACTERS;
        }
    }
}