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
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)
        );
    }
    @AfterAll
    static void closeBrowser() {
        if (playwright != null) {playwright.close();}
    }
    @BeforeEach
    void createContextAndPage() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }
    @AfterEach
    void closeContextAndPage() {
        if (browserContext != null) {browserContext.close();}
    }
}
