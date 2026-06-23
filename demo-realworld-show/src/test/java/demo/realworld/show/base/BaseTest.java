package demo.realworld.show.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    static void setBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(500));
    }
    @BeforeEach
    void setBrowserContext() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }
    @AfterEach
    void closeContext() {
        if (browserContext != null) { browserContext.close(); }
    }
    @AfterAll
    static void closeBrowser() {
        if (playwright != null) { playwright.close(); }
    }
}
