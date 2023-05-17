package us.piit.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CommonAPI {
    String browserName = "chrome";
    String url = "https://www.saucedemo.com/";
    String useCloudEnv = "true";
    WebDriver driver;
@BeforeMethod
    public void getCloudDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        String envName = "browserstack";
        //os
        cap.setCapability("os", "windows");
        //os version
        cap.setCapability("os_version", "11");
        //os version
        cap.setCapability("browser", "chrome");
        //browser version
        cap.setCapability("browser_version", "111");

        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1026x768");
            driver = new RemoteWebDriver(new URL("http://username:password@...com:80/wd/hub"), cap);// this url will be provided by browserStack
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://username:password@...com:80/wd/hub"), cap);
        }


    }

@AfterMethod

    public void setUp() throws MalformedURLException {
        if (browserName.equalsIgnoreCase("true")) {
            getCloudDriver();
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                System.out.println("chrome browser open success");
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            System.out.println("firefox browser open success");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println("edge browser open success");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("url");

    }


    public void tearDown() {

        driver.close();
        System.out.println("Browser close success");
    }

    //--------------------------------------------------------------------------------------------
    //                                      Selenium Methods
    //-----------------------------------------------------------------------------------------------

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public String getElementText(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).getText();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).getText();
        }
    }

    public void click(String locator) {
        try {
            driver.findElement(By.cssSelector("locator")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("locator")).sendKeys();
        }
    }

    public void type(String locator) {
        try {
            driver.findElement(By.cssSelector("locator")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("locator")).sendKeys();
        }
    }

    public void hoverOver(String locator) {
        Actions actions = new Actions(driver);

        try {
            actions.moveToElement(driver.findElement(By.cssSelector("locator"))).build().perform();
        } catch (Exception e) {
            actions.moveToElement(driver.findElement(By.xpath("locator"))).build().perform();
        }
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isVisible(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).isDisplayed();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).isEnabled();
        }
    }

    public boolean isInteractible(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).isDisplayed();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).isEnabled();
        }
    }

    public boolean isChecked(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).isDisplayed();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).isEnabled();
        }
    }


}
