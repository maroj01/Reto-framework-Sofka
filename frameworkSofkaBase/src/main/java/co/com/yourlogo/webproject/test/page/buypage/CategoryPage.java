package co.com.yourlogo.webproject.test.page.buypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    @CacheLookup
    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    WebElement dresses;

    @CacheLookup
    @FindBy(xpath = "//h5//a[contains(text(),'Summer Dresses')]")
    WebElement summerDresses;

    @CacheLookup
    @FindBy(xpath = "//h5[@itemprop='name']//a[contains(text(),'Printed Chiffon Dress')]")
    WebElement chiffonDress;

    public WebElement getDresses() {

        return dresses;
    }

    public WebElement getSummerDresses() {

        return summerDresses;
    }

    public WebElement getChiffonDress() {

        return chiffonDress;
    }

    public CategoryPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
