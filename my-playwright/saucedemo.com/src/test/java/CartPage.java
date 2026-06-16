import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;
    private final Locator inventoryItemName;

    public CartPage(Page page) {
        this.page = page;
        this.inventoryItemName = page.locator("[data-test='inventory-item-name']");
    }
    public Locator getItemName() {
        return inventoryItemName;
    }
}
