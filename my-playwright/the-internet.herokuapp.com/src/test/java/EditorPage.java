import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EditorPage {
    private final Page page;
    private final Locator editorBodyArea;

    public EditorPage(Page page) {
        this.page = page;
        this.editorBodyArea = page.frameLocator("#mce_0_ifr").locator("body");
    }
    public void open() {
        page.navigate("https://the-internet.herokuapp.com/iframe");
    }
    public void clearAndTypeInFrame(String newText) {
        editorBodyArea.clear();
        editorBodyArea.fill(newText);
    }
    public Locator getEditorBodyArea() {
        return editorBodyArea;
    }
}
