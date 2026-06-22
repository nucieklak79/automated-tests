package demo.realworld.show.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demo.realworld.show.base.BaseTest;
import demo.realworld.show.pages.EditorPage;
import demo.realworld.show.pages.LoginPage;
import demo.realworld.show.pages.MainPage;
import demo.realworld.show.pages.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NewArticleTest extends BaseTest {
    @Test
    @DisplayName("Publishing new article")
    void shouldSuccessfullyCreateAndPublishArticle() {
        //Given
        MainPage mainPage = new MainPage(page);
        LoginPage loginPage = new LoginPage(page);
        UserPage userPage = new UserPage(page);
        EditorPage editorPage = new EditorPage(page);
        String articleTitle = "Test article";
        String articleText = "This is a simple test article about E2E Playwright framework";

        //When
        mainPage.openMainPage();
        mainPage.signInClick().click();
        loginPage.userLogin("norbert_test@test.pl", "Pass1234");
        userPage.getNewArticleLink().click();
        editorPage.publishArticle(articleTitle, "about automated testing", articleText, "#Playwright");

        //Then
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(articleTitle)));
    }
}
