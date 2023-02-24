package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static final int IMPILICIT_WAIT_TIME_IN_SECOND=20;

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            String driverName = ConfigReader.getProperty("browser").toLowerCase();
            switch(driverName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(IMPILICIT_WAIT_TIME_IN_SECOND, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
