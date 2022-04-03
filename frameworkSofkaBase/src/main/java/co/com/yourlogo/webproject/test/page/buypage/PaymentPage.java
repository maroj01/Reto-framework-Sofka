package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    @CacheLookup
    @FindBy(xpath = "//a[@class='cheque']")
    WebElement payCheck;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement proceedCheckoutFive;

    public WebElement getPayCheck() {

        return payCheck;
    }

    public WebElement getProceedCheckoutFive() {

        return proceedCheckoutFive;
    }

    public PaymentPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
