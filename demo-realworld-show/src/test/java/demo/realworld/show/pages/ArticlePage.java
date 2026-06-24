package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ArticlePage {
    private final Page page;
    private final Locator deleteArticleButton;
    public ArticlePage(Page page) {
        this.page = page;
        this.deleteArticleButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Delete Article"));
    }

    public void deleteArticle() {
        deleteArticleButton.first().click();
    }

    public void addComment(String commentText) {
        page.getByPlaceholder("Write a comment...").fill(commentText);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Post Comment")).click();
    }

    public boolean isCommentVisible(String commentText) {
        return page.getByText(commentText).isVisible();
    }
}

