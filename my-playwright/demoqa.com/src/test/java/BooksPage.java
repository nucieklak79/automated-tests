import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BooksPage {
    private final Page page;
    private final Locator noDataMessage;

    public BooksPage(Page page) {
        this.page = page;
        this.noDataMessage = page.getByText("Page 1 of 0");
    }
    public void open() {
        page.navigate("https://demoqa.com/books");
    }
    public Locator getNoDataMessage() {
        return noDataMessage;
    }
}
