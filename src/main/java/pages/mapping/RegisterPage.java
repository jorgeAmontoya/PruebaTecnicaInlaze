package pages.mapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import common.BasePageActions;

public class RegisterPage extends BasePageActions {

    @CacheLookup
    @FindBy(id = "name")
    protected static WebElement txtNombre;

    @CacheLookup
    @FindBy(id = "email")
    protected static WebElement txtCorreo;

    @CacheLookup
    @FindBy(id = "pwd")
    protected static WebElement txtContrasena;

    @CacheLookup
    @FindBy(id = "pwdRepeat")
    protected static WebElement txtConfirmarContrasena;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Registrar')]")
    protected static WebElement btnRegistro;

    @CacheLookup
    @FindBy(xpath = "//Div[contains(text(),'Por Favor Digite Su Nombre!')]")
    protected static WebElement ValidacionCampoNombre;

    @CacheLookup
    @FindBy(xpath = "//Div[contains(text(),'Por Favor Digite Su Email!')]")
    protected static WebElement ValidacionCampoEmail;

    @CacheLookup
    @FindBy(xpath = "//Div[contains(text(),'Por Favor Digite Su Contraseña!')]")
    protected static WebElement ValidacionCampoContrasena;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[4]/div")
    protected static WebElement ValidacionCampoConfirmacionContrasena;

    public static WebElement ValidacionbtnRegistro(){
        return EsperarElemento(By.xpath("//button[contains(text(),'Registrar')]"));
    }

    public RegisterPage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }

}
