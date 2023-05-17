package us.piit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class LoginTest extends CommonAPI {

    Logger log = LogManager.getLogger(LoginTest.class.getName());


    @Test
    public void validCred() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        log.info("Username entered in the username field success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        log.info("Password entered in the password field success");
        driver.findElement(By.id("login-button")).click();
        log.info("Clicked on the login button is success");
        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("User logged in success");
    }
    @Test
    public void invalidUsername() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.id("user-name")).sendKeys("invalid_username");
        log.info("Username entered in the username field success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        log.info("Password entered in the password field success");
        driver.findElement(By.id("login-button")).click();
        log.info("Click on the login button is success");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }
    @Test
    public void missingUsername() throws InterruptedException {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(2000);
        driver.findElement(By.id("")).sendKeys("secret_sauce");
        log.info("Username entered in the username field success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        log.info("Password entered in the password field success");
        driver.findElement(By.id("login-button")).click();
        log.info("Click on the login button is success");
        String expectedError = "Epic sadface: Username is required";
        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");


    }

    @Test
    public void missingPassword() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.id("user-name")).sendKeys("invalid_username");
        log.info("Username entered in the username field success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        log.info("Password entered in the password field success");
        driver.findElement(By.id("login-button")).click();
        log.info("Click on the login button is success");
         String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");


    }

}
