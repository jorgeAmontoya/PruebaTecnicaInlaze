package utils;

import Models.UsersModels;
import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUser {
    private static org.apache.log4j.Logger LOGGER = Logger.getLogger(CreateUser.class);
    private static UsersModels userModel = new UsersModels();
    public static UsersModels generateUsuario(){
        Faker faker = new Faker();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(userModel.getName().replace(" ", "") + "@gmail.com");
        String contrasena = faker.internet().password();
        userModel.setPassword(contrasena);
        userModel.setConfirmPassword(contrasena);
        return userModel;
    }
    public static UsersModels generarUsuarioContrasenaIncorrecta(String TipoErrror,String ConfirmacionContrasena){
        try {
            Faker faker = new Faker();
            userModel.setName(faker.name().fullName());
            userModel.setEmail(userModel.getName().replace(" ", "") + "@gmail.com");
            userModel.setPassword(TipoErrror);
            userModel.setConfirmPassword(ConfirmacionContrasena);
            return userModel;
        }catch (Exception e){
            LOGGER.error("error al buscar la validacion de campo confirmar contrasena" + e.getMessage());
            return null;
        }
    }

    public static void EsperarAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
