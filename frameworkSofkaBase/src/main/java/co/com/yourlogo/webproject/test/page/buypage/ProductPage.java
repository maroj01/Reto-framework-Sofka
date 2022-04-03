package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @CacheLookup
    @FindBy(id = "add_to_cart")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    WebElement proceedCheckoutOne;

    public WebElement getAddToCart() {

        return addToCart;
    }

    public WebElement getProceedCheckoutOne() {

        return proceedCheckoutOne;
    }

    public ProductPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
