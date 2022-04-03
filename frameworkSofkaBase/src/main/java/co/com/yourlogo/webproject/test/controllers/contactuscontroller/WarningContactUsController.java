package co.com.yourlogo.webproject.test.controllers.contactuscontroller;

import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.contactuspage.ContactUsPage;

public class WarningContactUsController {
    private GeneralActions generalActions;

    public void setGeneralActions(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public String errorContacto() {
        String error = "";
        try {
            ContactUsPage contactUsPage = new ContactUsPage(generalActions.getDriver());
            error = generalActions.getText(contactUsPage.getErrorMessage(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al enviar el mensaje", e);
        }
        return error;
    }
}
