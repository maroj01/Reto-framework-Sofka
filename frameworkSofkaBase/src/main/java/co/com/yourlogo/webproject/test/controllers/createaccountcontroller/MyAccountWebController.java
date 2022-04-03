package co.com.yourlogo.webproject.test.controllers.createaccountcontroller;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.createaccountpage.MyAccountPage;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MyAccountWebController {
    private GeneralActions generalActions;

    public void setGeneralActions(GeneralActions generalActions) {
        this.generalActions = generalActions;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(generalActions.getDriver());

            usuario = generalActions.getText(myAccountPage.getCustomerName(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return usuario;
    }
}
