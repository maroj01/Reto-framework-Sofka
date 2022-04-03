package co.com.yourlogo.webproject.test.controllers;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.LandingPage;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.DOS;

public class LandingController {
    private GeneralActions generalActions;
    private  LandingPage landingPage;

    public void setGeneralActions(GeneralActions generalActions) {
        this.generalActions = generalActions;
    }

    public void irLoginIn() {
        try {
            landingPage = new LandingPage(generalActions.getDriver());
            generalActions.click(landingPage.getSignIn(), DOS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar ingresar al Login", e);
        }
    }
    public void irContatUs() {
        try {
            landingPage = new LandingPage(generalActions.getDriver());
            generalActions.click(landingPage.getContactUs(), DOS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar ingresar a ContactUs", e);
        }
    }

}
