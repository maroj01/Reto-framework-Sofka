package co.com.yourlogo.webproject.test.controllers.buycontroller;

import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.test.evidence.reports.Report;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.page.buypage.*;

import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.CINCO;
import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.DOS;

public class BuyProductsController {

    private GeneralActions generalActions;


    public void setGeneralActions(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public void comprarProductos() {
        try {
            CategoryPage categoryPage = new CategoryPage(generalActions.getDriver());
            ProductPage productPage = new ProductPage(generalActions.getDriver());
            SummaryPage summaryPage = new SummaryPage(generalActions.getDriver());
            AddressPage addressPage = new AddressPage(generalActions.getDriver());
            ShippingPage shippingPage = new ShippingPage(generalActions.getDriver());
            PaymentPage paymentPage = new PaymentPage(generalActions.getDriver());

            generalActions.click(categoryPage.getDresses(), DOS.getValue(), true);

            generalActions.scroll(categoryPage.getSummerDresses(),DOS.getValue(), true);
            generalActions.click(categoryPage.getSummerDresses(), DOS.getValue(), true);

            generalActions.scroll(categoryPage.getChiffonDress(),DOS.getValue(), true);
            generalActions.click(categoryPage.getChiffonDress(), true);

            generalActions.click(productPage.getAddToCart(), DOS.getValue(), true);
            generalActions.click(productPage.getProceedCheckoutOne(), DOS.getValue(), true);
            generalActions.click(summaryPage.getProceedCheckoutTwo(), DOS.getValue(), true);
            generalActions.click(addressPage.getProceedCheckoutThree(), DOS.getValue(), true);
            generalActions.click(shippingPage.getTerms(), DOS.getValue(), true);
            generalActions.click(shippingPage.getProceedCheckoutFour(), DOS.getValue(), true);
            generalActions.click(paymentPage.getPayCheck(), DOS.getValue(), true);
            generalActions.click(paymentPage.getProceedCheckoutFive(), DOS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al realizar la compra", e);
        }
    }

    public void comprarProductosError() {
        try {
            CategoryPage categoryPage = new CategoryPage(generalActions.getDriver());
            ProductPage productPage = new ProductPage(generalActions.getDriver());
            SummaryPage summaryPage = new SummaryPage(generalActions.getDriver());
            AddressPage addressPage = new AddressPage(generalActions.getDriver());
            ShippingPage shippingPage = new ShippingPage(generalActions.getDriver());

            generalActions.click(categoryPage.getDresses(), DOS.getValue(), true);

            generalActions.scroll(categoryPage.getSummerDresses(),DOS.getValue(), true);
            generalActions.click(categoryPage.getSummerDresses(), DOS.getValue(), true);

            generalActions.scroll(categoryPage.getChiffonDress(),DOS.getValue(), true);
            generalActions.click(categoryPage.getChiffonDress(), true);

            generalActions.click(productPage.getAddToCart(), CINCO.getValue(), true);
            generalActions.click(productPage.getProceedCheckoutOne(), CINCO.getValue(), true);
            generalActions.click(summaryPage.getProceedCheckoutTwo(), DOS.getValue(), true);
            generalActions.click(addressPage.getProceedCheckoutThree(), DOS.getValue(), true);
            generalActions.scroll(shippingPage.getProceedCheckoutFour(),DOS.getValue(), true);
            generalActions.click(shippingPage.getProceedCheckoutFour(), DOS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al realizar la compra.", e);
        }
    }
}