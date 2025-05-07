package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	public static String getLoadedData(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(1));
        driver.findElement(By.id("load-button")).click();

        try{
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.id("content"))));
        return button.getText();
        }catch(Exception e){
            return null;
        }
}
}
