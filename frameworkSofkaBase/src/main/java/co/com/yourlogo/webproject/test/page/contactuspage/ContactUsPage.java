package co.com.yourlogo.webproject.test.page.contactuspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {


    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @CacheLookup
    @FindBy(xpath = "//option[contains(text(),'Customer service')]")
    WebElement customer;

    @CacheLookup
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement idOrder;

    @CacheLookup
    @FindBy(id = "fileUpload")
    WebElement fileUp;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/fieldset[1]/div[2]/button[1]/span[1]")
    WebElement send;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Your message has been successfully sent to our tea')]")
    WebElement contactExitoso;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'The message cannot be blank.')]")
    WebElement errorMessage;


    public WebElement getSubjectHeading() {

        return subjectHeading;
    }

    public WebElement getCustomer() {
        return customer;
    }

    public WebElement getEmailAddress() {

        return emailAddress;
    }

    public WebElement getIdOrder() {

        return idOrder;
    }

    public WebElement getFileUp() {

        return fileUp;
    }

    public WebElement getMessage() {

        return message;
    }

    public WebElement getSend() {

        return send;
    }

    public WebElement getContactExitoso() {

        return contactExitoso;
    }

    public WebElement getErrorMessage() {

        return errorMessage;
    }

    public ContactUsPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);
    }

}
