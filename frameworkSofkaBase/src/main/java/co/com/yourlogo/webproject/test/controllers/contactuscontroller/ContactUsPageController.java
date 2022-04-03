package co.com.yourlogo.webproject.test.controllers.contactuscontroller;

import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.yourlogo.webproject.test.actions.GeneralActions;
import co.com.yourlogo.webproject.test.helpers.Dictionary;
import co.com.yourlogo.webproject.test.helpers.Helper;
import co.com.yourlogo.webproject.test.model.ContactUsModel;
import co.com.yourlogo.webproject.test.page.contactuspage.ContactUsPage;

import java.nio.file.Paths;

import static co.com.yourlogo.webproject.test.utils.EnumTimeOut.DOS;


public class ContactUsPageController {
    private GeneralActions generalActions;
    private ContactUsModel contactUsModel;
    private static final String CHOOSE_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\IN188261.pdf";

    public ContactUsModel getContacto() {
        return contactUsModel;
    }

    public void setGeneralActions(GeneralActions generalActions) {
        this.generalActions = generalActions;
    }

    public void crearContacto() {
        try {
            contactUsModel = Helper.crearContacto(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);
            ContactUsPage contactUsPage = new ContactUsPage(generalActions.getDriver());

            generalActions.selectByText(contactUsPage.getSubjectHeading(), "Customer service", DOS.getValue(), true);
            generalActions.click(contactUsPage.getCustomer(), DOS.getValue(), true);
            generalActions.sendText(contactUsPage.getEmailAddress(), contactUsModel.getEmailAddress(), DOS.getValue(), true);
            generalActions.sendText(contactUsPage.getIdOrder(), contactUsModel.getOrderReference(), DOS.getValue(), true);
            generalActions.uploadFile(contactUsPage.getFileUp(), Paths.get(CHOOSE_FILE), true);
            generalActions.sendText(contactUsPage.getMessage(), contactUsModel.getMessage(), true);

            generalActions.scroll(contactUsPage.getSend(),DOS.getValue(), true);
            generalActions.click(contactUsPage.getSend(), DOS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al crear el contacto", e);
        }
    }

    public void enviarMensaje() {
        try {
            contactUsModel = Helper.crearContacto(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);
            ContactUsPage contactUsPage = new ContactUsPage(generalActions.getDriver());

            generalActions.selectByText(contactUsPage.getSubjectHeading(), "Customer service", DOS.getValue(), true);
            generalActions.click(contactUsPage.getCustomer(), DOS.getValue(), true);
            generalActions.sendText(contactUsPage.getEmailAddress(), contactUsModel.getEmailAddress(), DOS.getValue(), true);
            generalActions.sendText(contactUsPage.getIdOrder(), contactUsModel.getOrderReference(), DOS.getValue(), true);
            generalActions.uploadFile(contactUsPage.getFileUp(), Paths.get(CHOOSE_FILE), true);

            generalActions.scroll(contactUsPage.getSend(),DOS.getValue(), true);
            generalActions.click(contactUsPage.getSend(), DOS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al realizar la solicitud.", e);
        }
    }
}
