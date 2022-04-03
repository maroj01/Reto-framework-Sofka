package co.com.yourlogo.webproject.test.controllers.openwebpage;

import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.helpers.Dictionary;
import co.com.yourlogo.webproject.test.helpers.Helper;

public class StartBrowserWebController {
    private GeneralActions generalActions;
    private String featue;
    private Browser browser;

    public void setGeneralActions(GeneralActions generalActions) {
        this.generalActions = generalActions;
    }

    public void setFeatue(String featue) {

        this.featue = featue;
    }

    public void setBrowser(Browser browser) {

        this.browser = browser;
    }

    public void abrirTiendaOnline() {
        try {
            generalActions.startWebApp(browser, Helper.getProperty(Dictionary.APP_URL_PROPERTY), featue);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }
}
