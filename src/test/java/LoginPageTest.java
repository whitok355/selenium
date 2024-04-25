import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    private static String BASE_LOGIN = "MainTestUser 10002";
    private static String BASE_PASS = "850ba79167";
    private WebDriver driver;
    private ChromeOptions chromeOptions;
    private WebDriverWait wait;

    @BeforeEach
    public void setUpTest() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }
    @Test
    public void createGroupTest() throws IOException {
        driver.get("https://test-stand.gb.ru/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='text']"))).sendKeys(BASE_LOGIN);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='password']"))).sendKeys(BASE_PASS);
        WebElement loginButton = driver.findElement(By.cssSelector("form#login button"));
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loginButton));


        WebElement usernameLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(BASE_LOGIN)));
        assertEquals(String.format("Hello, %s", BASE_LOGIN), usernameLink.getText().replace("\n", " ").trim());


        WebElement buttonCreate = wait.until(
                webDriver -> webDriver.findElement(By.id("create-btn")));
        buttonCreate.click();



        WebElement fieldTitle = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//input[@type='text']")));
        fieldTitle.sendKeys("TestSelenium");
        WebElement fieldDescription = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//textarea[@class='mdc-text-field__input']")));
        fieldDescription.sendKeys("Home Work 1");
        WebElement buttonSave = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSave.click();

        WebElement headingPost = wait.until(
                webDriver -> webDriver.findElement(By.cssSelector("h1[class='svelte-tv8alb']")));



        Assertions.assertEquals("TestSelenium", headingPost.getText());

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("src/test/resources/screenshotPost.png"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}