package co.com.yourlogo.webproject.test.stepdefinition;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.controllers.*;
import co.com.yourlogo.webproject.test.controllers.buycontroller.BuyCompleteController;
import co.com.yourlogo.webproject.test.controllers.buycontroller.BuyProductsController;
import co.com.yourlogo.webproject.test.controllers.buycontroller.WarningBuyController;
import co.com.yourlogo.webproject.test.controllers.createaccountcontroller.CreateAnAccountWebController;
import co.com.yourlogo.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.yourlogo.webproject.test.data.objects.TestInfo;
import co.com.yourlogo.webproject.test.helpers.Helper;
import co.com.yourlogo.webproject.test.model.BuyModel;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CartStepDefinition extends Setup {
    private GeneralActions generalActions;
    private final BuyModel buyModel = Helper.generateBuy();
    private BuyProductsController buyProductsController;


    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        generalActions = new GeneralActions(testInfo.getFeatureName());
        generalActions.setScenario(testInfo.getScenarioName());
    }


    @Dado("que procedo a realizar el pago de los productos seleccionados")
    @Dado("que estoy logueado en el sitio web de la tienda")
    public void autenticarSitioWebTienda() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setGeneralActions(generalActions);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LandingController landingController = new LandingController();
        landingController.setGeneralActions(generalActions);
        landingController.irLoginIn();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setGeneralActions(generalActions);
        createAnAccountWebController.crearUnaCuenta();

    }

    @Cuando("realizo el proceso de compra")
    public void realizarProcesoCompra() {
        buyProductsController = new BuyProductsController();
        buyProductsController.setGeneralActions(generalActions);
        buyProductsController.comprarProductos();
    }

    @Entonces("se mostrará mensaje de confirmacion")
    public void mostrarMensajeConfirmacion() {
        BuyCompleteController buyCompleteController = new BuyCompleteController();
        buyCompleteController.setGeneralActions(generalActions);
        String confirmacion = buyCompleteController.obtenerConfirmacionCompra();
        Assert
                .Hard
                .thatString(confirmacion)
                .isEqualTo(buyModel.getConfirmationBuy());
    }


    @Cuando("no acepto los terminos y condiciones")
    public void declinarTerminosCondiciones() {
        buyProductsController = new BuyProductsController();
        buyProductsController.setGeneralActions(generalActions);
        buyProductsController.comprarProductosError();
    }

    @Entonces("se mostrará el mensaje de notificación")
    public void mostrarMensajeNotificacion() {
        WarningBuyController warningBuyController = new WarningBuyController();
        warningBuyController.setGeneralActions(generalActions);

        String advertencia = warningBuyController.obtenerBuyError();
        Assert
                .Hard
                .thatString(advertencia)
                .isEqualTo(buyModel.getWarningBuy());
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