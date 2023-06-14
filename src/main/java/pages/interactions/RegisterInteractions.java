package pages.interactions;

import Models.UsersModels;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.mapping.RegisterPage;

public class RegisterInteractions extends RegisterPage {
    private static Logger LOGGER = Logger.getLogger(RegisterInteractions.class);
    public RegisterInteractions(WebDriver driver, int segundos) {
        super(driver,segundos);
        initElement(driver,this);
    }
    public void DiligenciarFormularioRegistro(UsersModels userModel) {
        try {
            DiligenciarCampo(txtNombre, userModel.getName());
            DiligenciarCampo(txtCorreo, userModel.getEmail());
            DiligenciarCampo(txtContrasena, userModel.getPassword());
            DiligenciarCampo(txtConfirmarContrasena, userModel.getConfirmPassword());
         } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de registro");
            }
    }
    public void ClickBtnRegistro() {
        try {

            clickEnElemento(btnRegistro);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de Registro");
        }
    }

   public String BuscarPaginaRegistro(){
        try {
            return ObtenerTextoDeElemento(ValidacionbtnRegistro());
        }catch (Exception e){
            LOGGER.error("error al buscar la pagina de registro" + e.getMessage());
            return null;
        }
   }

   public void LimpiarCampoNombre(){
        try {
            LimpiarCampo(txtNombre);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo nombre");
        }
   }
    public void LimpiarCampoEmail(){
        try {
            LimpiarCampo(txtCorreo);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo correo");
        }
    }
    public void LimpiarCampocontrasena(){
        try {
            LimpiarCampo(txtContrasena);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo contrasena");
        }
    }
    public void LimpiarCampoconfirmacioncontrasena(){
        try {
            LimpiarCampo(txtConfirmarContrasena);
        }catch (Exception e){
            LOGGER.error("error al limpiar el campo confirmar contrasena");
        }
    }

    public String BuscarValidacionCampoNombre(){
        try {
            return ObtenerTextoDeElemento(ValidacionCampoNombre);
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo nombre" + e.getMessage());
            return null;
        }
    }
    public String BuscarValidacionCampoEmail(){
        try {
            return ObtenerTextoDeElemento(ValidacionCampoEmail);
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo correo" + e.getMessage());
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
    public String BuscarValidacionCampoConfirmacionContrasena(){
        try {
            return ObtenerTextoDeElemento(ValidacionCampoConfirmacionContrasena);
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo confirmar contrasena" + e.getMessage());
            return null;
        }
    }
}
