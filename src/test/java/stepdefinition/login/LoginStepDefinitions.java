package stepdefinition.login;

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
import static utils.Dictionary.USUARIO_CONTRASENA_INCORRECTA;
import static utils.Dictionary.USUARIO_NO_EXISTE;

public class LoginStepDefinitions extends Setup {
    private UsersModels userModel;
    RegisterInteractions registerInteractions;
    LoginInteractions loginInteractions;
    String campoSinDiligenciarG;
    String equivocacionG;
    @Given("que el usuario se encuentra registrado en la pagina Beta Testin")
    public void queElUsuarioSeEncuentraRegistradoEnLaPaginaBetaTestin() {
        setUpLog4j2();
        generalSetUp();
        userModel = generateUsuario();

        loginInteractions = new LoginInteractions(driver, 3);
        loginInteractions.ClickLinkPaginaRegistro();

        registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.DiligenciarFormularioRegistro(userModel);
        registerInteractions.ClickBtnRegistro();
        EsperarAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @When("inicia sesion de manera correcta")
    public void iniciaSesionDeManeraCorrecta() {

        loginInteractions.DiligenciarFormularioLogin(userModel.getEmail(),userModel.getPassword());
        loginInteractions.ClickBtnLoguin();

    }

    @Then("se visualizara en la pagina el nombre del usuario")
    public void seVisualizaraEnLaPaginaElNombreDelUsuario() {
        HomeInteractions homeInteractions = new HomeInteractions(driver,3);
        homeInteractions.getHeaderText();
        Assertions.assertEquals(homeInteractions.getHeaderText(),"Hola, " + userModel.getName() );
    }

    @When("diligencia los campos del formulario de loguin sin especificar {string}")
    public void diligenciaLosCamposDelFormularioDeLoguinSinEspecificar(String campoSinDiligenciar) {
        loginInteractions.DiligenciarFormularioLogin(userModel.getEmail(),userModel.getPassword());
        campoSinDiligenciarG = campoSinDiligenciar;
        switch (campoSinDiligenciar) {
            case "usuario":
                loginInteractions.LimpiarCampoUsuario();
                break;
            case "contrasena":
                loginInteractions.LimpiarCampoContrasena();
                break;
            case "usuarioYContrasena":
                loginInteractions.LimpiarCampoUsuarioYContrasena();
                break;
        }
        loginInteractions.ClickBtnLoguin();
    }

    @Then("recibo un mensaje indicando el campo obligatorio que esta sin diligenciar")
    public void reciboUnMensajeIndicandoElCampoObligatorioQueEstaSinDiligenciar() {
        switch (campoSinDiligenciarG) {
            case "usuario":
                loginInteractions.BuscarValidacionCampoUsuario();
                Assertions.assertTrue(loginInteractions.BuscarValidacionCampoUsuario().contains("Digite Su Usuario!"));
                break;
            case "contrasena":
                loginInteractions.BuscarValidacionCampoContrasena();
                Assertions.assertTrue(loginInteractions.BuscarValidacionCampoContrasena().contains("Digite Su Contraseña!"));
                break;
            case "usuarioYContrasena":
                Assertions.assertTrue(loginInteractions.BuscarValidacionCampoUsuario().contains("Digite Su Usuario!"));
                Assertions.assertTrue(loginInteractions.BuscarValidacionCampoContrasena().contains("Digite Su Contraseña!"));
                break;
        }
    }

    @When("diligencia los campos del formulario de loguin de forma incorrecta {string}")
    public void diligenciaLosCamposDelFormularioDeLoguinDeFormaIncorrecta(String equivocacion) {
        loginInteractions.DiligenciarFormularioLogin(userModel.getEmail(),userModel.getPassword());
        equivocacionG = equivocacion;
        switch (equivocacion) {
            case "usuario":
                loginInteractions.DiligenciarCampoUsuarioDelLogin(userModel.getEmail());
                break;
            case "contrasena":
                loginInteractions.DiligenciarCampoContrasenaDelLogin(userModel.getPassword());
                break;
        }
        loginInteractions.ClickBtnLoguin();
    }
    @Then("recibo un mensaje indicando que esta iniciando sesion de manera incorrecta")
    public void reciboUnMensajeIndicandoElCampoEstaIniciandoSesionDeManeraIncorrecta() {
        switch (equivocacionG) {
            case "usuario":
                EsperarAlert(driver);
                String alert = driver.switchTo().alert().getText();
                Assertions.assertEquals(alert, USUARIO_NO_EXISTE);

                break;
            case "contrasena":
        EsperarAlert(driver);
        String alerta = driver.switchTo().alert().getText();
        Assertions.assertEquals(alerta, USUARIO_CONTRASENA_INCORRECTA);
                break;
        }
    }
    @After
    public void finalizar() {
        quiteDriver();
    }
}
