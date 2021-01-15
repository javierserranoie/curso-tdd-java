package password_validation;

public class PasswordValidator {

    public static final String HAS_A_NUMBER = ".*\\d.*";

    static boolean validatePassword(String password) {
        if (password.length() < 9) {
            return false;
        }
        if (hasNoCapitalLetter(password)) {
            return false;
        }
        if (hasNoLowerCase(password)) {
            return false;
        }
        if (!password.matches(HAS_A_NUMBER)) {
            return false;
        }
        return password.contains("_");
    }

    private static boolean hasNoLowerCase(String password) {
        return password.equals(password.toUpperCase());
    }

    private static boolean hasNoCapitalLetter(String password) {
        return password.equals(password.toLowerCase());
    }
}
