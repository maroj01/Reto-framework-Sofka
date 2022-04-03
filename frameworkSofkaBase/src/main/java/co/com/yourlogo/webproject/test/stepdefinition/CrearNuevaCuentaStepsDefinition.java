package co.com.yourlogo.webproject.test.stepdefinition;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.controllers.createaccountcontroller.CreateAnAccountWebController;
import co.com.yourlogo.webproject.test.controllers.LandingController;
import co.com.yourlogo.webproject.test.controllers.createaccountcontroller.MyAccountWebController;
import co.com.yourlogo.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.yourlogo.webproject.test.data.objects.TestInfo;
import co.com.yourlogo.webproject.test.model.CustomerModel;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.yourlogo.webproject.test.helpers.Dictionary;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CrearNuevaCuentaStepsDefinition extends Setup{

    private GeneralActions generalActions;
    private CustomerModel customerModel;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        generalActions = new GeneralActions(testInfo.getFeatureName());
        generalActions.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la página de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setGeneralActions(generalActions);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente registra sus datos para una cuenta en línea de forma exitosa")
    public void elClienteRegistraSusDatosParaUnaCuentaEnLineaDeFormaExitosa() {
        LandingController landingController = new LandingController();
        landingController.setGeneralActions(generalActions);
        landingController.irLoginIn();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setGeneralActions(generalActions);
        createAnAccountWebController.crearUnaCuenta();
        customerModel = createAnAccountWebController.getCustomer();
    }

    @Entonces("como resultado el usuario quedará logueado dentro de su respectiva sesión per se.")
    public void comoResultadoElUsuarioQuedaraLogueadoDentroDeSuRespectivaSesionPerSe() {
        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setGeneralActions(generalActions);
        String userName = myAccountWebController.obtenerNombreDeNuevoUsuario();

        Assert
                .Hard
                .thatString(userName)
                .isEqualTo(customerModel.getFirstName() + Dictionary.SPACE_STRING + customerModel.getLastName());
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
