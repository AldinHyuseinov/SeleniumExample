import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryCatalogTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:3000");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav.navbar")));
    }

    @AfterEach
    public void closeDriver() {
       webDriver.quit();
    }

    @Test
    public void verifyAllBooksLinkIsVisible() {
        WebElement allBooksLink = webDriver.findElement(By.cssSelector("a[href='/catalog']"));
        boolean isLinkVisible = allBooksLink.isDisplayed();

        assertTrue(isLinkVisible);
    }

    @Test
    public void verifyLoginLinkIsVisible() {
        WebElement loginButton = webDriver.findElement(By.cssSelector("a[href='/login']"));
        boolean isLinkVisible = loginButton.isDisplayed();

        assertTrue(isLinkVisible);
    }

    @Test
    public void verifyRegisterLinkIsVisible() {
        WebElement registerButton = webDriver.findElement(By.cssSelector("a[href='/register']"));
        boolean isLinkVisible = registerButton.isDisplayed();

        assertTrue(isLinkVisible);
    }
}
