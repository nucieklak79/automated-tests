import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MultipleTabsTest extends BaseTest {

    @Test
    public void shouldHandleNewTabProperly() {
        //Given
        page.navigate("https://demoqa.com/browser-windows");
        Page newTab = browserContext.waitForPage(() -> {
            page.locator("#tabButton").click();
        });
        //When
        newTab.waitForLoadState();
        Locator headingOnNewTab = newTab.locator("#sampleHeading");
        //Then
        assertThat(headingOnNewTab).hasText("This is a sample page");
        assertThat(page.locator(".text-center")).hasText("Browser Windows");
    }
}