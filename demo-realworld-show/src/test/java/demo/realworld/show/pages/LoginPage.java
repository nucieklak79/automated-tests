package demo.realworld.show.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator signInButton;

    public LoginPage(Page page) {
        this.page = page;
        this.emailInput = page.getByPlaceholder("Email");
        this.passwordInput = page.getByPlaceholder("Password");
        this.signInButton = page.locator("button[type='submit']");
    }
    public void userLogin(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        signInButton.click();
    }
    public String getErrorMessage() {
        return page.locator(".error-messages > li").textContent();
    }
}
