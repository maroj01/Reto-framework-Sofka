package co.com.yourlogo.webproject.test.controllers.contactuscontroller;

import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.contactuspage.ContactUsPage;

public class ContactSuccessfullyController {
    private GeneralActions generalActions;

    public void setWebAction(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public String obternerMessageSuccessfully() {
        String message = "";
        try {
            ContactUsPage contactUsPage = new ContactUsPage(generalActions.getDriver());
            message = generalActions.getText(contactUsPage.getContactExitoso(), 15, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al enviar el mensaje", e);
        }
        return message;
    }
}
