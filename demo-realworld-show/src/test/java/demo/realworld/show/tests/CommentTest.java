package demo.realworld.show.tests;

import demo.realworld.show.base.BaseTest;
import demo.realworld.show.pages.ArticlePage;
import demo.realworld.show.pages.HomePage;
import demo.realworld.show.pages.LoginPage;
import demo.realworld.show.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentTest extends BaseTest {
    @Test
    @DisplayName("New comment test")
    void shouldAddCommentToFirstArticleInGlobalFeed() {
        //Given
        MainPage mainPage = new MainPage(page);
        LoginPage loginPage = new LoginPage(page);
        ArticlePage articlePage = new ArticlePage(page);
        HomePage homePage = new HomePage(page);

        //When
        mainPage.openMainPage();
        mainPage.signInClick().click();
        loginPage.userLogin("norbert_test@test.pl", "Pass1234");
        homePage.goToGlobalFeed();
        homePage.openFirstArticle();
        String uniqueComment = "Automated Playwright comment" + System.currentTimeMillis();
        articlePage.addComment(uniqueComment);

        //Then
        assertTrue(
                articlePage.isCommentVisible(uniqueComment),
                "Comment is not visible"
        );
    }
}
