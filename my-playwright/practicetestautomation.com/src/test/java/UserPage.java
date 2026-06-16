import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserPage {
    private final Page page;

    private final Locator loginInfo;
    private final Locator logoutButton;

    public UserPage(Page page) {
        this.page = page;
        this.loginInfo = page.locator(".post-title");
        this.logoutButton = page.getByText("Log out");
    }
    public Locator getLoginInfo() {
        return loginInfo;
    }
    public void logout() {
        logoutButton.click();
    }
}
