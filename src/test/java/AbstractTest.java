import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbstractTest {

    private static WebDriver driver;
    private static ChromeOptions options =new ChromeOptions();
    private static Properties prop = new Properties();
    private static FileInputStream config;
    private static String LOGIN;
    private static String PASSWORD;
    @BeforeAll
    public static void init() throws IOException {
        config = new FileInputStream("src/test/resources/properties.properties");
        prop.load(config);

        options.addArguments("start-maximized");
        options.addArguments("incognito");

        LOGIN = prop.getProperty("login");
        PASSWORD = prop.getProperty("password");

        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String getPropertiesValue(String propertiesName) throws IOException {
        return prop.getProperty(propertiesName);
    }

    public static String getLOGIN() {
        return LOGIN;
    }
    public static String getPASSWORD() {
        return PASSWORD;
    }

}
