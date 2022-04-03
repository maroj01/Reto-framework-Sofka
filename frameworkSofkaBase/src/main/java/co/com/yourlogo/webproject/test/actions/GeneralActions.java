package co.com.yourlogo.webproject.test.actions;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.logs.Log;
import co.com.sofka.test.exceptions.WebActionsException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.sofka.test.actions.ActionMessages.*;

public class GeneralActions extends WebAction {

    public GeneralActions(String projectFolderName) {
        super(projectFolderName);
    }

    public void scroll(WebElement element, int timeout, boolean isScreenShot) throws WebActionsException {
        final String ACTION = "scroll";

        String webElementInfo = validateAndGetInfo(element);
        String params = String.format(PARAM, TEXT_WE_LOCATION, webElementInfo)
                .concat(COMMA)
                .concat(String.format(PARAM, TEXT_TIMEOUT, timeout));

        validateInstance(driver, TEXT_DRIVER);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        validateScreenShot(isScreenShot, element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        String msg = String.format(SUCCESS_MSG_PARAMS,
                ACTION,
                params,
                getEvidenceText(isScreenShot));
        Log.LOGGER.log(Log.CustomLevels.COMPLETED, msg);
    }
}
