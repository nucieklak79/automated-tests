package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }
    public void goToGlobalFeed() {
        page.locator(".nav-item a").filter(new Locator.FilterOptions().setHasText("Global Feed"));
        page.waitForSelector(".article-preview");
    }
    public void openFirstArticle() {
        page.locator(".article-preview h1").first().click();
    }
}
