package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement proceedCheckoutThree;

    @CacheLookup
    @FindBy(xpath = "//textarea[@class='form-control']")
    WebElement comment;

    public WebElement getProceedCheckoutThree() {

        return proceedCheckoutThree;
    }

    public WebElement getComment() {
        return comment;
    }

    public AddressPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
