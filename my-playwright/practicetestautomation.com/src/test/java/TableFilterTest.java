import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableFilterTest extends BaseTest {
    @Test
    @DisplayName("Testing table filter")
    public void testTableFilter() {
        PracticeTablePage tablePage = new PracticeTablePage(page);
        tablePage.open();
        tablePage.filterByLanguage();
        assertThat(tablePage.getVisibleRows().nth(0)).containsText("Java");

        Locator rows = tablePage.getVisibleRows();
        int visibleRowsCount = rows.count();

        assertTrue(visibleRowsCount > 0, "There are no rows");
        for (int rowIndex = 0; rowIndex < visibleRowsCount; rowIndex++) {
            Locator currentRow = rows.nth(rowIndex);
            assertThat(currentRow).containsText("Java");

        }
        System.out.println("There are " + visibleRowsCount + " rows containing Java");
    }
}
