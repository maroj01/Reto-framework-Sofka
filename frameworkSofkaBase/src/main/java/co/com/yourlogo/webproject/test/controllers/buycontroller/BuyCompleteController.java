package co.com.yourlogo.webproject.test.controllers.buycontroller;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.buypage.ConfirmationPage;

import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.DOS;

public class BuyCompleteController {

    private GeneralActions generalActions;

    public void setGeneralActions(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public String obtenerConfirmacionCompra() {
        String confirmacion = "";
        try {
            ConfirmationPage confirmationPage = new ConfirmationPage(generalActions.getDriver());

            generalActions.scroll(confirmationPage.getOrderComplete(),DOS.getValue(), true);
            confirmacion = generalActions.getText(confirmationPage.getOrderComplete(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al confirmar la compra", e);
        }
        return confirmacion;
    }
}
