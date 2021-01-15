package password_validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

//   - Have more than 8 characters
//	 - Contains a capital letter
//	 - Contains a lowercase
//	 - Contains a number
//	 - Contains an underscore

    String passworValid = "1bcD_7jlp";
    String passwordNotValidLessCharacters = "1bcD_7jl";
    String passwordNotValidWithoutCapitalLetter = "1bcd_7jlp";
    String passwordNotValidWithoutLowerCase = "1BCD_7JLP";
    String passwordNotValidWithoutNumber = "bbcD_ojlp";
    String passwordNotValidWithoutUnderscore = "1bcD97jlp";


    @Test
    public void isValidPassword() {

        assertThat(PasswordValidator.validatePassword(passworValid)).isTrue();

    }

    @Test
    public void haveLessThan8Characters() {

        assertThat(PasswordValidator.validatePassword(passwordNotValidLessCharacters)).isFalse();

    }

    @Test
    public void notHaveCapitalLetter() {

        assertThat(PasswordValidator.validatePassword(passwordNotValidWithoutCapitalLetter)).isFalse();

    }

    @Test
    public void notHaveLowerCase() {

        assertThat(PasswordValidator.validatePassword(passwordNotValidWithoutLowerCase)).isFalse();

    }

    @Test
    public void notHaveNumber() {

        assertThat(PasswordValidator.validatePassword(passwordNotValidWithoutNumber)).isFalse();

    }

    @Test
    public void notHaveUnderscore() {

        assertThat(PasswordValidator.validatePassword(passwordNotValidWithoutUnderscore)).isFalse();

    }


}
