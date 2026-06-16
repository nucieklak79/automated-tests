import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator submitButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#username");
        this.passwordInput = page.locator("#password");
        this.submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        this.errorMessage = page.locator("#error");
    }
    public void open() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");
    }
    public void loginAs(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        submitButton.click();
    }
    public Locator getErrorMessage() {
        return errorMessage;
    }
}

