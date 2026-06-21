package demo.realworld.show.tests;

import demo.realworld.show.base.BaseTest;
import demo.realworld.show.pages.LoginPage;
import demo.realworld.show.pages.MainPage;
import demo.realworld.show.pages.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("testing existing user login")
    public void existingUserLoginTest(){

        //Given
        MainPage mainPage = new MainPage(page);
        LoginPage loginPage = new LoginPage(page);
        UserPage userPage = new UserPage(page);

        //When
        mainPage.openMainPage();
        mainPage.signInClick().click();
        loginPage.userLogin("norbert_test@test.pl", "Pass1234");

        //Then
        assertThat(userPage.getUserProfileLink()).hasText("norbert_test");
    }
}
