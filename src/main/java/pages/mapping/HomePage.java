package pages.mapping;

import common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageActions {
    public HomePage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }

    public static WebElement visualizacionNombreUsuario(){
        return EsperarElemento(By.xpath("//span[contains(text(),'Hola, ')]"));
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Salir')]")
    protected static WebElement btnSalir;
}
