import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Route;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MockBookTest extends  BaseTest {
    @Test
    public void testIfApiReturnsEmptylist() {
        page.route("**/BookStore/v1/Books", route -> {
            String emptyMockResponse = "{\"books\": []}";
            route.fulfill(new Route.FulfillOptions()
                    .setStatus(200)
                    .setContentType("application/json")
                    .setBody(emptyMockResponse));
        });
        BooksPage booksPage = new BooksPage(page);
        booksPage.open();

        assertThat(booksPage.getNoDataMessage()).isVisible();

    }

    @Test
    public void shouldDisplayCustomMockedBookInTable() {

        page.route("**/BookStore/v1/Books", route -> {

            String customBookJson = """
                {
                  "books": [
                    {
                      "isbn": "1234567890",
                      "title": "Mock in Playwright",
                      "subTitle": "How to",
                      "author": "Norbert Ucieklak",
                      "publish_date": "2026-06-14T00:00:00.000Z",
                      "publisher": "Company Z",
                      "pages": 999,
                      "description": "My course - Playwright.",
                      "website": "https://moj-framework.pl"
                    }
                  ]
                }
                """;

            route.fulfill(new Route.FulfillOptions()
                    .setStatus(200)
                    .setContentType("application/json")
                    .setBody(customBookJson));
        });

        page.navigate("https://demoqa.com/books");

        Locator mockedBookTitle = page.getByText("Mock in Playwright");

        Locator mockedBookAuthor = page.getByText("Norbert Ucieklak");

        assertThat(mockedBookTitle).isVisible();
        assertThat(mockedBookAuthor).isVisible();
    }
}
