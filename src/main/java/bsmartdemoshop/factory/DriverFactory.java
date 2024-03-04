package bsmartdemoshop.factory;

import bsmartdemoshop.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
    public static WebDriver initializeDriver() throws IOException {
        WebDriver driver;
        Properties prop = new Properties();
      //  FileReader fileReader = new FileReader("src/main/resources/GlobalData.properties");
      //  BufferedReader bufferedReader = new BufferedReader(fileReader);
       // prop.load(bufferedReader);
        prop= PropertyUtils.propertyLoader("src/main/resources/GlobalData.properties");
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
        switch(browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs= new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled",false);

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--incognito");
                options.addArguments("--remote-allow-origins=*");
                options.setExperimentalOption("prefs",prefs);
              //  driver= new RemoteWebDriver(new URL("http://localhost:4444"),options);
                driver=new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                FirefoxOptions firefoxOptions= new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
               // driver= new RemoteWebDriver(new URL("http://localhost:4444"),firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions= new EdgeOptions();
                edgeOptions.addArguments("start-maximized");
                driver=new EdgeDriver();
               // driver= new RemoteWebDriver(new URL("http://192.168.1.4:4444"),edgeOptions);
                break;
            default:
                throw new RuntimeException("invalid browser name, please give a valid browser name"+browserName);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverFactory.driverLocal.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        return driverLocal.get();
    }

}
