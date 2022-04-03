package co.com.yourlogo.webproject.test.controllers.createaccountcontroller;

import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.model.CustomerModel;
import co.com.yourlogo.webproject.test.page.createaccountpage.CreateAnAccountPage;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.yourlogo.webproject.test.helpers.Dictionary;
import co.com.yourlogo.webproject.test.helpers.Helper;

import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.*;


public class CreateAnAccountWebController {
    private GeneralActions generalActions;
    private CustomerModel customerModel;

    public CustomerModel getCustomer() {

        return customerModel;
    }

    public void setGeneralActions(GeneralActions generalActions) {

        this.generalActions = generalActions;
    }

    public void crearUnaCuenta() {
        try {
            customerModel = Helper.generateCustomer(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(generalActions.getDriver());

            generalActions.sendText(createAnAccountPage.getEmailAddress(), customerModel.getEmail(), DOS.getValue(), true);
            generalActions.click(createAnAccountPage.getCreateAnAccount(), DOS.getValue(), true);
            generalActions.click(createAnAccountPage.getMr(),CINCO.getValue(), true);
            generalActions.sendText(createAnAccountPage.getFirstName(), customerModel.getFirstName(), true);
            generalActions.sendText(createAnAccountPage.getLastName(), customerModel.getLastName(), true);
            generalActions.sendText(createAnAccountPage.getPassword(), customerModel.getPassword(), true);
            generalActions.selectByPartialText(createAnAccountPage.getDay(), customerModel.getDayBirth(), true);
            generalActions.selectByValue(createAnAccountPage.getMonth(), customerModel.getMonthBirth(), true);
            generalActions.selectByPartialText(createAnAccountPage.getYear(), customerModel.getYearBirth(), true);
            generalActions.sendText(createAnAccountPage.getAddress1(), customerModel.getAddress(), true);
            generalActions.sendText(createAnAccountPage.getCity(), customerModel.getCity(), true);
            generalActions.selectByText(createAnAccountPage.getState(), customerModel.getState(), true);
            generalActions.sendText(createAnAccountPage.getPostCode(), customerModel.getPostalCode(), true);
            generalActions.sendText(createAnAccountPage.getPhoneMobile(), customerModel.getMobilePhone(), true);
            generalActions.click(createAnAccountPage.getRegister(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta", e);
        }
    }
}
