package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

    @CacheLookup
    @FindBy(id = "uniform-cgv")
    WebElement terms;

    @CacheLookup
    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement termsService;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedCheckoutFour;

    public WebElement getTerms() {

        return terms;
    }

    public WebElement getTermsService() {

        return termsService;
    }

    public WebElement getProceedCheckoutFour() {

        return proceedCheckoutFour;
    }

    public ShippingPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
