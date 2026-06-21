package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage {
    private final Page page;
    private final Locator signIn;

    public MainPage(Page page) {
        this.page = page;
        this.signIn = page.locator("a[routerlink='/login']");
    }
    public void openMainPage() {
        page.navigate("https://demo.realworld.show");
    }
    public Locator signInClick() {
        return signIn;
    }
}
