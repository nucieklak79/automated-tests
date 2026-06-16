import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IframeTest extends BaseTest {
    @Test
    public void testIframeTest(){
        //Given
        EditorPage editorPage = new EditorPage(page);
        editorPage.open();
        String expectedText = "Mission Success - new text has arrived";

        //When
        editorPage.clearAndTypeInFrame(expectedText);

        //Then
        assertThat(editorPage.getEditorBodyArea()).hasText(expectedText);
    }
}
