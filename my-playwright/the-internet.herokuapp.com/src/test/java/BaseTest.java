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
    static void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setSlowMo(1000)
                .setHeadless(false));
    }
    @BeforeEach
    void setUpContext(){
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }
    @AfterEach
    void tearDownContext(){
        if(browserContext != null){ browserContext.close(); }
    }
    @AfterAll
    static void tearDown(){
        if(playwright != null){ playwright.close(); }
    }

}
