import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class UploadPage {
    private final Page page;
    private final Locator fileInput;
    private final Locator submitButton;
    private final Locator successMessage;

    public UploadPage(Page page) {
        this.page = page;
        this.fileInput = page.locator("#file-upload");
        this.submitButton = page.locator("#file-submit");
        this.successMessage = page.locator("h3");
    }
    void uploadFile(String filePath) {
        fileInput.setInputFiles(Paths.get(filePath));
        submitButton.click();
    }
    public Locator getSuccessMessage() {
        return successMessage;
    }
}
