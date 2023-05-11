package us.piit;

import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutTest extends SetUp{
    Logger log = LogManager.getLogger(LogoutTest.class.getName());
    @Test
    public void logout() throws InterruptedException {

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

        driver.findElement(By.id("react-burger-menu-btn")).click();
        log.info("Click on hamburger manu success");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("logout_sidebar_link"))).click().build().perform();
        log.info("Click on logout link success");

        WebElement loginPageHeader = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        boolean loginPageHeaderIsDisplayed = loginPageHeader.isDisplayed();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("Login page header is displayed");
        String expectedPageHeaderText = "Swag Labs";
        String actualPageHeaderText = loginPageHeader.getText();
        Assert.assertEquals(expectedPageHeaderText,actualPageHeaderText);
        log.info("Login page header text validation success");






    }
}
