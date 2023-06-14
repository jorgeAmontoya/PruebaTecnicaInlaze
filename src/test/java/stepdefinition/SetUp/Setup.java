package stepdefinition.SetUp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static utils.Dictionary.*;
import static utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class Setup {
    /**
     * se crea elemento de tipo WebDriver
     */
    protected WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(Setup.class);
    /**
     * metodo que permite inicializar las propiedades del driver
     */
    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    /**
     * metodo que permite obtener la pagina a probar abrirla y maximizar la ventana
     */
    protected void generalSetUp() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(PAGINA_BETA_TESTING);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    /**
     * Metodo que permite cerrar el Driver
     */
    public void quiteDriver() {
        driver.quit();
    }
    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
