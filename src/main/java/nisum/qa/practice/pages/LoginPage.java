package nisum.qa.practice.pages;

import nisum.qa.practice.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Defining Page Factory : Object Repository
    @FindBy(name="username")
    WebElement userNameTxtBox;

    @FindBy(name="password")
    WebElement passwordTxtBox;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//font[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@alt,'free crm logo')]")
    WebElement crmLogo;

    //Initializing the Page Objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Methods : Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMLogo(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String userName, String password){
        userNameTxtBox.sendKeys(userName);
        passwordTxtBox.sendKeys(password);
        loginBtn.submit();

        return new HomePage();
    }
}
