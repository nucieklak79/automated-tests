import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LetCodeFrameTest extends BaseTest {
    @Test
    public void letCodeFrameTest()
    {
        //Given
        LetCodeFramePage letCodeFramePage = new LetCodeFramePage(page);
        letCodeFramePage.open();

        //When
        letCodeFramePage.fillPersonalData("Norbert", "Ucieklak");

        //Then
        assertThat(letCodeFramePage.getFirstNameInput()).hasValue("Norbert");
        assertThat(letCodeFramePage.getLastNameInput()).hasValue("Ucieklak");
    }
}
