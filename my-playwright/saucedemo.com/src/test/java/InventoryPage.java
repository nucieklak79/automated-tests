import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {
    private final Page page;
    private final Locator addBackpackButton;
    private final Locator cartIcon;

    public InventoryPage(Page page) {
        this.page = page;
        this.addBackpackButton = page.locator("#add-to-cart-sauce-labs-backpack");
        this.cartIcon = page.locator("[data-test='shopping-cart-link']");
    }
    public void addBackpackToChart() {
        addBackpackButton.click();
    }
    public void gotToChart() {
        cartIcon.click();
    }
}

