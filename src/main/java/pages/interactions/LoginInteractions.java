package pages.interactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.mapping.LoginPage;

public class LoginInteractions extends LoginPage {
    private static Logger LOGGER = Logger.getLogger(LoginInteractions.class);
    public LoginInteractions(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }
    public void ClickLinkPaginaRegistro() {
        try {
            clickEnElemento(linkPaginaRegistro);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el Link de registro");
        }
    }
    public void ClickBtnLoguin() {
        try {
            clickEnElemento(btnLogin);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de Loguin");
        }
    }
    public void LimpiarCampoUsuario(){
        try {
            LimpiarCampo(txtUsuarioLogin);
        } catch (Exception e){
            LOGGER.error("error al limpiar el campo usuario");
        }
    }
    public void LimpiarCampoContrasena() {
        try {
            LimpiarCampo(txtContrasenaLogin);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo contrasena");
        }

    }

        public void LimpiarCampoUsuarioYContrasena(){
        try {
            LimpiarCampo(txtUsuarioLogin);
            LimpiarCampo(txtContrasenaLogin);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo usuario y contrasena" + e.getMessage());
        }
    }

    public String BuscarValidacionCampoUsuario(){
        try {
            return ObtenerTextoDeElemento(ValidacionCampoUsuario);
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo usuario" + e.getMessage());
            return null;
        }

    }
    public String BuscarValidacionCampoContrasena(){
        try {
            return ObtenerTextoDeElemento(ValidacionCampoContrasena);
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo contrasena" + e.getMessage());
            return null;
        }
    }


    public void DiligenciarFormularioLogin(String email, String password) {
        try {
            DiligenciarCampo(txtUsuarioLogin, email);
            DiligenciarCampo(txtContrasenaLogin, password);
        } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de usuario y contrasena");
        }
    }

    public void DiligenciarCampoUsuarioDelLogin(String email) {
        try {
            DiligenciarCampo(txtUsuarioLogin,email+"FFF");
        } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de usuario");
        }
    }
    public void DiligenciarCampoContrasenaDelLogin(String password) {
        try {
            DiligenciarCampo(txtContrasenaLogin,password+"FFF");
        } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de contrasena");
        }
    }

    public String BuscarPaginaLogin(){
        try {
            return ObtenerTextoDeElemento(ValidacionbtnIngresar());
        }catch (Exception e){
            LOGGER.error("error al buscar la pagina de login" + e.getMessage());
            return null;
        }
    }
}
