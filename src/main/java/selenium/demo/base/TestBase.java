package selenium.demo.base;

import selenium.demo.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    /*
    We must change the path of fileInputStream variable according to the local path of the config.properties file
     */
    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("F:/LearningStuff/PracticalWork" +
                    "/Frameworks/DataDrivenFrameworkSelenium/src/main/resources/config/config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /*
    We must change the path of Systems.setProperty according to the local path of WebDrivers
     */
    public static void initialization() {
        String browserName = properties.getProperty("browserName");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "F:/LearningStuff/WebDrivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize(); //maximize browser
        driver.manage().deleteAllCookies();  //clear cookies
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //waits for a page load
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); //waits for an element
        driver.get(properties.getProperty("url")); //opens the url
    }
}
