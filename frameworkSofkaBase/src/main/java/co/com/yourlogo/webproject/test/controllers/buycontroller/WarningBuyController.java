package co.com.yourlogo.webproject.test.controllers.buycontroller;

import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.buypage.ShippingPage;

public class WarningBuyController {

    private GeneralActions generalActions;
    public void setGeneralActions(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public String obtenerBuyError() {
        String advertencia = "";
        try {
            ShippingPage shippingPage = new ShippingPage(generalActions.getDriver());
            advertencia = generalActions.getText(shippingPage.getTermsService(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("No ha aceptado los terminos", e);
        }
        return advertencia;
    }
}
