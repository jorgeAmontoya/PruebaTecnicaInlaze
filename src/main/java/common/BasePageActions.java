package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Dictionary.WEBDRIVER_NULL_MESSAGE;


public class BasePageActions {
    private static final Logger LOGGER = Logger.getLogger(BasePageActions.class);
    protected static WebDriver driver;
    public BasePageActions(WebDriver driver, Integer waitingTime) {
        try {
            if (driver == null)
                LOGGER.error(WEBDRIVER_NULL_MESSAGE);
            this.driver = driver;
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(waitingTime))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }
    protected void initElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }
    public void clickEnElemento(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }
    public void DiligenciarCampo(WebElement element, String value){
        try {
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }
    protected String ObtenerTextoDeElemento(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return "";
        }
    }
    public static WebElement EsperarElemento(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void LimpiarCampo(WebElement element){
        try {
            element.clear();
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
