package co.com.yourlogo.webproject.test.helpers;


import co.com.yourlogo.webproject.test.model.BuyModel;
import co.com.yourlogo.webproject.test.model.ContactUsModel;
import co.com.yourlogo.webproject.test.model.CustomerModel;
import co.com.sofka.test.evidence.reports.Report;

import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;


public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader(Dictionary.CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + Dictionary.CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static CustomerModel generateCustomer(String language, String country, String emailDomain) {

        Faker faker = Faker.instance(
                new Locale(language, country),
                new Random()
        );

        CustomerModel customerModel = new CustomerModel();
        customerModel.setEmail(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(Dictionary.SPACE_STRING, Dictionary.EMPTY_STRING)
        );

        customerModel.setFirstName(faker.name().firstName());
        customerModel.setLastName(faker.name().lastName());
        customerModel.setPassword(faker.number().digits(8));
        customerModel.setDayBirth(String.valueOf(faker.number().numberBetween(1, 28)));
        customerModel.setMonthBirth(String.valueOf(faker.number().numberBetween(1, 12)));
        customerModel.setYearBirth(String.valueOf(faker.number().numberBetween(1980, 2003)));

        customerModel.setAddress(faker.address().fullAddress());
        customerModel.setCity(faker.address().city());
        customerModel.setPostalCode(faker.address().zipCode());
        customerModel.setMobilePhone(
                String.valueOf(
                                faker
                                        .number()
                                        .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        customerModel.setState(Dictionary.STATE_BY_DEFAULT_FLORIDA);

        return customerModel;
    }

    public static BuyModel generateBuy(){
        BuyModel buyModel =new BuyModel();
        buyModel.setConfirmationBuy(Dictionary.CONFIRMATION_BUY);
        buyModel.setWarningBuy(Dictionary.WARNING_BUY);
        return buyModel;
    }

    public static ContactUsModel crearContacto(String language, String country, String emailDomain) {

        Faker faker = Faker.instance(
                new Locale(language, country),
                new Random()
        );

        ContactUsModel contactUsModel = new ContactUsModel();
        contactUsModel.setEmailAddress(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(Dictionary.SPACE_STRING, Dictionary.EMPTY_STRING)
        );

        contactUsModel.setOrderReference(faker.code().ean8());

        contactUsModel.setContactExitoso(Dictionary.SEND_MESSAGE);
        contactUsModel.setErrorMessage(Dictionary.ERROR);
        contactUsModel.setMessage(Dictionary.MESSAGE);

        return contactUsModel;
    }
}
