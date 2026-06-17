import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UploadTest extends BaseTest {
    @Test
    public void uploadTest()
    {
        //Given
        UploadPage uploadPage = new UploadPage(page);
        page.navigate("https://the-internet.herokuapp.com/upload");

        //When
        uploadPage.uploadFile("src/test/resources/file-sample.pdf");

        //Then
        assertThat(uploadPage.getSuccessMessage()).hasText("File Uploaded!");
    }
}
