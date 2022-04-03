package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    @CacheLookup
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedCheckoutTwo;

    public WebElement getProceedCheckoutTwo() {

        return proceedCheckoutTwo;
    }

    public SummaryPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }
}
