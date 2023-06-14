package stepdefinition.logout;

import Models.UsersModels;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pages.interactions.HomeInteractions;
import pages.interactions.LoginInteractions;
import pages.interactions.RegisterInteractions;
import stepdefinition.SetUp.Setup;

import static utils.CreateUser.EsperarAlert;
import static utils.CreateUser.generateUsuario;
import static utils.Dictionary.INGRESAR;

public class LogoutStepDefinition extends Setup {

    LoginInteractions loginInteractions;
    RegisterInteractions registerInteractions;
    @Given("que el usuario se encuentra en el home de la pagina beta Testin")
    public void queElUsuarioSeEncuentraEnElHomeDeLaPaginaBetaTestin() {
        setUpLog4j2();
        generalSetUp();
         UsersModels userModel = generateUsuario();

        loginInteractions = new LoginInteractions(driver, 3);
        loginInteractions.ClickLinkPaginaRegistro();

        registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.DiligenciarFormularioRegistro(userModel);
        registerInteractions.ClickBtnRegistro();
        EsperarAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        loginInteractions.DiligenciarFormularioLogin(userModel.getEmail(),userModel.getPassword());
        loginInteractions.ClickBtnLoguin();
    }

    @When("el usuario cierra sesion")
    public void cierraSesion() {
        HomeInteractions homeInteractions = new HomeInteractions(driver,3);
        homeInteractions.ClickBtnSalir();
    }

    @Then("sera redireccionado a la pagina del Login")
    public void seraRedireccionadoALaPaginaDelLogin() {
        Assertions.assertEquals(loginInteractions.BuscarPaginaLogin(),INGRESAR);
    }
    @After
    public void finalizar() {
        quiteDriver();
    }
}
