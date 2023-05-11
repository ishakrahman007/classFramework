package us.piit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SetUp {
    String browserName = "chrome";
    String url = "https://www.saucedemo.com/";

    WebDriver driver;

    public void getCloudDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        //username
        //password

        //os
        cap.setCapability("os", "windows");
        //os version
        cap.setCapability("os_version", "11");
        //os version
        cap.setCapability("browser", "chrome");
        //browser version
        cap.setCapability("browser_version", "111");
        cap.setCapability("resolution","1026x768");
        //url

        driver = new RemoteWebDriver(new URL("http://username:password@...com:80/wd/hub"),cap);// this url will be provided by browserStack
        driver = new RemoteWebDriver(new URL("http://username:password@...com:80/wd/hub"),cap);



    }


    @Before
    public void setUp() {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("url");

    }

    @After
    public void tearDown() {

        driver.close();
        System.out.println("Browser close success");
    }
}
