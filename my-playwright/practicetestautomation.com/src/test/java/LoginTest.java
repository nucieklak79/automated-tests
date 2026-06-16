import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    @ParameterizedTest(name = "Test for username: {0} and password: {1}")
    @CsvSource({
        "bad_username, Password123, Your username is invalid!",
        "student, bad_password, Your password is invalid!"
    })
    public void badLoginTest(String username, String password, String expectedError) {
        //Given
        LoginPage loginPage = new LoginPage(page);
        //When
        loginPage.open();
        loginPage.loginAs(username, password);
        //Then
        assertThat(loginPage.getErrorMessage()).hasText(expectedError);
    }

    @Test
    public void studentLoginTest(){
        //Given
        LoginPage loginPage = new LoginPage(page);
        UserPage userPage = new UserPage(page);
        //When
        loginPage.open();
        loginPage.loginAs("student", "Password123");
        //Then
        assertThat(userPage.getLoginInfo()).hasText("Logged In Successfully");
        userPage.logout();
    }

}
