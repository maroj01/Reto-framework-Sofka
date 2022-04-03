package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement orderComplete;

    public WebElement getOrderComplete() {

        return orderComplete;
    }

    public ConfirmationPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
