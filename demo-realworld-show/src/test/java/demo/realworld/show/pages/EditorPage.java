package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EditorPage {
    private final Page page;
    private final Locator articleTitle;
    private final Locator articleAbout;
    private final Locator articleMainText;
    private final Locator articleTags;
    private final Locator publishButton;

    public EditorPage(Page page) {
        this.page = page;
        this.articleTitle = page.getByPlaceholder("Article Title");
        this.articleAbout = page.locator("[name='description']");
        this.articleMainText = page.getByPlaceholder("Write your article (in markdown)");
        this.articleTags = page.getByPlaceholder("Enter tags");
        this.publishButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish Article"));
    }
    public void publishArticle(String articleTitle, String articleAbout, String articleMainText, String articleTags) {
        this.articleTitle.fill(articleTitle);
        this.articleAbout.fill(articleAbout);
        this.articleMainText.fill(articleMainText);
        this.articleTags.fill(articleTags);
        publishButton.click();
    }
}
