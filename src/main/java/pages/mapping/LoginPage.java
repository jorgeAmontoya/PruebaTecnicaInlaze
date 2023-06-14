package pages.mapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import common.BasePageActions;

public class LoginPage extends BasePageActions {
    /**
     * localizadores de la pagina login
     */
    @CacheLookup
    @FindBy(xpath = "//*[@class='enlace' and contains(text(),'aquí')]")
    protected static WebElement linkPaginaRegistro;

    @CacheLookup
    @FindBy(id = "ingresoUsuario")
    protected static WebElement txtUsuarioLogin;

    @CacheLookup
    @FindBy(id = "ingresoContrasena")
    protected static WebElement txtContrasenaLogin;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Ingresar')]")
    protected static WebElement btnLogin;

    @CacheLookup
    @FindBy(xpath = "//Div[contains(text(),'Por Favor Digite Su Usuario!')]")
    protected static WebElement ValidacionCampoUsuario;

    @CacheLookup
    @FindBy(xpath = "//Div[contains(text(),'Por Favor Digite Su Contraseña!')]")
    protected static WebElement ValidacionCampoContrasena;
    public static WebElement ValidacionbtnIngresar(){
        return EsperarElemento(By.xpath("//button[contains(text(),'Ingresar')]"));
    }
    public LoginPage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }
}
