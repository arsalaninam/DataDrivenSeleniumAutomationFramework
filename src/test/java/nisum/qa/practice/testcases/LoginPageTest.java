package nisum.qa.practice.testcases;

import nisum.qa.practice.base.TestBase;
import nisum.qa.practice.pages.HomePage;
import nisum.qa.practice.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
    }

    @Test(priority = 2)
    public void CRMLogoImageTest() {
        boolean flag = loginPage.validateCRMLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
