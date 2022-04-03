package co.com.yourlogo.webproject.test.model;

public class ContactUsModel {

    private String emailAddress;
    private String orderReference;
    private String message;
    private String contactExitoso;
    private String errorMessage;

    public String getContactExitoso() {
        return contactExitoso;
    }

    public void setContactExitoso(String contactExitoso) {
        this.contactExitoso = contactExitoso;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    public String getOrderReference() {

        return orderReference;
    }

    public void setOrderReference(String orderReference) {

        this.orderReference = orderReference;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
