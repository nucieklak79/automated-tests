import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;
import java.util.Arrays;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    static void setBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch( new BrowserType.LaunchOptions()
                .setSlowMo(1000)
                .setHeadless(false)
        );
    }
    @BeforeEach
    void setBrowserContext() {
        browserContext = browser.newContext();
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = browserContext.newPage();
    }
    @AfterEach
    void closeContext() {
        if (browserContext != null) {
            browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("traces/trace.zip")));
            browserContext.close();}
    }
    @AfterAll
    static void closeBrowser() {
        if (playwright != null) {playwright.close();}
    }
}
