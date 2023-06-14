package pages.interactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.mapping.HomePage;

public class HomeInteractions extends HomePage {
    private static Logger LOGGER = Logger.getLogger(HomeInteractions.class);
    public HomeInteractions(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }

    public  String getHeaderText(){
        try {
            return ObtenerTextoDeElemento(visualizacionNombreUsuario());
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public void ClickBtnSalir() {
        try {
            clickEnElemento(btnSalir);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de Loguin");
        }
    }
}
