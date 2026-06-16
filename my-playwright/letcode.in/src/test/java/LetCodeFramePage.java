import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LetCodeFramePage {
    private final Page page;

    private final Locator firstNameInput;
    private final Locator lastNameInput;

    public LetCodeFramePage(Page page) {
        this.page = page;
        FrameLocator mainFrame = page.frameLocator("#firstFr");
        this.firstNameInput = mainFrame.locator("input[name='fname']");
        this.lastNameInput = mainFrame.locator("input[name='lname']");
    }
    public void open() {
        page.navigate("https://letcode.in/frame");
    }
    public void fillPersonalData(String firstName, String lastName) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
    }
    public Locator getFirstNameInput() {
        return firstNameInput;
    }
    public Locator getLastNameInput() {
        return lastNameInput;
    }
}