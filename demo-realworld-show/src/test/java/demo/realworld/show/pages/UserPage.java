package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class UserPage {
    private final Page page;
    private final Locator userProfileLink;
    private final Locator newArticleLink;

    public UserPage(Page page) {
        this.page = page;
        this.userProfileLink = page.locator("app-layout-header").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("norbert_test"));
        this.newArticleLink = page.locator("app-layout-header").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("New Article"));
    }
    public Locator getUserProfileLink() {
        return userProfileLink;
    }
    public Locator getNewArticleLink() { return  newArticleLink; }
}
