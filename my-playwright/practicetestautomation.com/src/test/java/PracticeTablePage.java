import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PracticeTablePage {
    private final Page page;
    private final Locator javaLanguage;
    private final Locator visibleRows;
    public PracticeTablePage(Page page) {
        this.page = page;
        this.javaLanguage = page.locator("[value='Java']");
        this.visibleRows = page.locator("tbody tr:visible");
    }
    public void open() {
        page.navigate("https://practicetestautomation.com/practice-test-table/");
    }
    public void filterByLanguage() {
        javaLanguage.setChecked(true);
    }
    public Locator getVisibleRows() {
        return visibleRows;
    }

}
