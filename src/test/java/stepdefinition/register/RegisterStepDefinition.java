package stepdefinition.register;

import Models.UsersModels;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pages.interactions.LoginInteractions;
import pages.interactions.RegisterInteractions;
import stepdefinition.SetUp.Setup;

import static utils.CreateUser.*;
import static utils.Dictionary.*;


public class RegisterStepDefinition extends Setup {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private UsersModels userModel;
    RegisterInteractions registerInteractions;
    private String tipocontrasenaincorrectaG;
    private String campoSinDiligenciarG;
    @Given("que el usuario ingresa al formulario de la pagina Beta Testin")
    public void queElUsuarioIngresaAlFormularioDeLaPaginaBetaTestin() {
       try {
           setUpLog4j2();
           generalSetUp();
           userModel = generateUsuario();
           LoginInteractions loginInteractions = new LoginInteractions(driver, 3);
           loginInteractions.ClickLinkPaginaRegistro();
       }catch (Exception e){
           LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
           Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
       }
    }

    @When("se registra correctamente en la pagina")
    public void seRegistraCorrectamenteEnLaPagina() {
        registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.DiligenciarFormularioRegistro(userModel);
        registerInteractions.ClickBtnRegistro();
    }

    @Then("se recibira un mensaje indicando que el usuario fue creado exitosamente")
    public void seRecibiraUnMensajeIndicandoQueElUsuarioFueCreadoExitosamente() {
        EsperarAlert(driver);
        String alert = driver.switchTo().alert().getText();
        Assertions.assertEquals(alert, "El usuario " + userModel.getName() + " fue creado con éxito.");
    }

    @When("diligencia los campos del formulario con la contraseña {string}")
    public void diligenciaLosCamposDelFormularioConLaContrasena(String tipoContrasenaIncorrecta) {
        registerInteractions = new RegisterInteractions(driver,3);
        tipocontrasenaincorrectaG = tipoContrasenaIncorrecta;
        switch (tipoContrasenaIncorrecta) {
            case "minimo_8_caracteres":
                userModel = generarUsuarioContrasenaIncorrecta(CONTRASENA_MENOR_OCHO_CARACTERES,CONTRASENA_MENOR_OCHO_CARACTERES);
                registerInteractions.DiligenciarFormularioRegistro(userModel);
                registerInteractions.ClickBtnRegistro();
            break;
            case "confirmaciondecontrasena":
                userModel = generarUsuarioContrasenaIncorrecta(CONTRASENA_CORRECTA,CONTRASENA_NO_COINCIDE );
                registerInteractions.DiligenciarFormularioRegistro(userModel);
                registerInteractions.ClickBtnRegistro();
            break;
        }
    }

    @Then("recibe un mensaje indicando que la contrasena es incorrecta")
    public void recibeUnMensajeIndicandoQueLaContrasenaDebeContenerAlMenosSeisCaracteres() {
        switch (tipocontrasenaincorrectaG) {
            case "minimo_8_caracteres":
                Assertions.assertTrue(userModel.getPassword().toString().length() > 7);
                break;
            case "confirmaciondecontrasena":
                EsperarAlert(driver);
                String alert = driver.switchTo().alert().getText();
                Assertions.assertEquals(alert, CONTRASENAS_NO_COINCIDEN);
                break;
        }
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @And("no se registrara el usario en la pagina")
    public void noSeRegistraraElUsuarioEnLaPagina() {
        Assertions.assertEquals(registerInteractions.BuscarPaginaRegistro(),REGISTRAR);
    }
    @When("diligencia los campos del formulario sin especificar {string}")
    public void diligenciaLosCamposDelFormularioSinEspecificar(String campoSinDiligenciar) {
        registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.DiligenciarFormularioRegistro(userModel);
        campoSinDiligenciarG = campoSinDiligenciar;
        switch (campoSinDiligenciar) {
            case "nombre":
                registerInteractions.LimpiarCampoNombre();
                break;
            case "Email":
                registerInteractions.LimpiarCampoEmail();
                break;
            case "contrasena":
                registerInteractions.LimpiarCampocontrasena();
                break;
            case "confirmacionDeContrasena":
                registerInteractions.LimpiarCampoconfirmacioncontrasena();
                break;
        }
        registerInteractions.ClickBtnRegistro();
    }

    @Then("recibira un mensaje indicando que campo obligatorio falta por diligenciar")
    public void recibiraUnMensajeIndicandoQueCampoObligatorioFaltaPorDiligenciar() {
        switch (campoSinDiligenciarG) {
            case "nombre":
                registerInteractions.BuscarValidacionCampoNombre();
                Assertions.assertTrue(registerInteractions.BuscarValidacionCampoNombre().contains("Digite Su Nombre!"));
                break;
            case "Email":
                registerInteractions.BuscarValidacionCampoEmail();
                Assertions.assertTrue(registerInteractions.BuscarValidacionCampoEmail().contains("Digite Su Email!"));
                break;
            case "contrasena":
                registerInteractions.BuscarValidacionCampoContrasena();
                Assertions.assertTrue(registerInteractions.BuscarValidacionCampoContrasena().contains("Digite Su Contraseña!"));
                break;
            case "confirmacionDeContrasena":
                registerInteractions.BuscarValidacionCampoConfirmacionContrasena();
                Assertions.assertTrue(registerInteractions.BuscarValidacionCampoConfirmacionContrasena().contains("Digite Su Contraseña!"));
                break;
        }

    }
    @After
    public void finalizar() {
        quiteDriver();
    }
}

