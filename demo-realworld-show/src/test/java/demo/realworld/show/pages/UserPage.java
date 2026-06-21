package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class UserPage {
    private final Page page;
    private final Locator userProfileLink;

    public UserPage(Page page) {
        this.page = page;
        this.userProfileLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("norbert_test"));
    }
    public Locator getUserProfileLink() {
        return userProfileLink;
    }
}
