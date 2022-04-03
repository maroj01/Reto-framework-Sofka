package co.com.yourlogo.webproject.test.stepdefinition;

import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.controllers.contactuscontroller.ContactSuccessfullyController;
import co.com.yourlogo.webproject.test.controllers.contactuscontroller.ContactUsPageController;
import co.com.yourlogo.webproject.test.controllers.LandingController;
import co.com.yourlogo.webproject.test.controllers.contactuscontroller.WarningContactUsController;
import co.com.yourlogo.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.yourlogo.webproject.test.data.objects.TestInfo;
import co.com.yourlogo.webproject.test.model.ContactUsModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ContactUsStepDefinition extends Setup {
    private GeneralActions generalActions;
    private ContactUsModel contactUsModel;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        generalActions = new GeneralActions(testInfo.getFeatureName());
        generalActions.setScenario(testInfo.getScenarioName());
    }

    @Dado("que requiero solicitar atencion de servicio al cliente")
    @Dado("que deseo obtener informacion de un producto comprado")
    public void obtenerInformacionProductoComprado() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setGeneralActions(generalActions);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("me contacto ingresando toda la informacion solicitada")
    public void registrarInformacionSolicitada() {
        LandingController landingController = new LandingController();
        landingController.setGeneralActions(generalActions);
        landingController.irContatUs();

        ContactUsPageController contactUsPageController=new ContactUsPageController();
        contactUsPageController.setGeneralActions(generalActions);
        contactUsPageController.crearContacto();
        contactUsModel = contactUsPageController.getContacto();
    }

    @Entonces("se mostrará mensaje de confirmación de envío")
    public void mostrarMensajeConfirmacionEnvio() {
        ContactSuccessfullyController contactSuccessfully = new ContactSuccessfullyController();
        contactSuccessfully.setWebAction(generalActions);
        String mensajeOk = contactSuccessfully.obternerMessageSuccessfully();
        Assert
                .Hard
                .thatString(mensajeOk)
                .isEqualTo(contactUsModel.getContactExitoso());
    }

    @Cuando("hago la solicitud sin escribir mensaje")
    public void solicitarSinMensaje() {

        LandingController landingController = new LandingController();
        landingController.setGeneralActions(generalActions);
        landingController.irContatUs();

        ContactUsPageController contactUsPageController=new ContactUsPageController();
        contactUsPageController.setGeneralActions(generalActions);
        contactUsPageController.enviarMensaje();
        contactUsModel = contactUsPageController.getContacto();

    }

    @Entonces("se mostrará el mensaje de advertencia")
    public void mostrarMensajeAdvertencia() {
        WarningContactUsController warningContactUsController = new WarningContactUsController();
        warningContactUsController.setGeneralActions(generalActions);
        String mensajeError = warningContactUsController.errorContacto();

        Assert
                .Hard
                .thatString(mensajeError)
                .isEqualTo(contactUsModel.getErrorMessage());
    }

    @After
    public void cerrarDriver() {
        if (generalActions != null && generalActions.getDriver() != null)
            generalActions.closeBrowser();
        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}

