package demo.realworld.show.tests;

import com.microsoft.playwright.APIRequestContext;
import demo.realworld.show.api.AuthApi;
import demo.realworld.show.base.BaseTest;
import demo.realworld.show.pages.UserPage;
import demo.realworld.show.utils.ConfigReader;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ApiLoginTest extends BaseTest {
    @Test
    public void shouldBeLoggedIn() {
        //Given
        UserPage userPage = new UserPage(page);
        String email = ConfigReader.getProperty("user.email");
        String password = ConfigReader.getProperty("user.password");
        String jwtToken = AuthApi.getJwtToken(playwright, email, password);

        //When
        page.navigate("https://demo.realworld.show/");
        page.evaluate("window.localStorage.setItem('jwtToken', '" + jwtToken + "');");
        page.reload();

        //Then
        assertThat(userPage.getUserProfileLink()).hasText("norbert_test");
    }
}
