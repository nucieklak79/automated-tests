import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginCheckoutTest extends BaseTest {
    @ParameterizedTest(name = "Test for username: {0} and password: {1}")
    @CsvSource({
            "zly_user, secret_sauce, Epic sadface: Username and password do not match any user in this service",
            "standard_user, zle_haslo, Epic sadface: Username and password do not match any user in this service",
            "locked_out_user, secret_sauce, 'Epic sadface: Sorry, this user has been locked out.'"
    })
    public void badUsernameAndPasswordTest(String username, String password, String errorMessage) {
        //Given
        LoginPage loginPage = new LoginPage(page);
        //When
        loginPage.openPage();
        loginPage.loginAs(username, password);
        //Then
        assertThat(loginPage.getErrorMessage()).hasText(errorMessage);
    }
    @Test
    @DisplayName("Testing correct username and password")
    public void correctUsernameAndPasswordTest() {
        //Given
        LoginPage loginPage = new LoginPage(page);
        InventoryPage inventoryPage = new InventoryPage(page);
        CartPage cartPage = new CartPage(page);
        //When
        loginPage.openPage();
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addBackpackToChart();
        inventoryPage.gotToChart();
        //Then
        assertThat(cartPage.getItemName()).hasText("Sauce Labs Backpack");
    }
}
