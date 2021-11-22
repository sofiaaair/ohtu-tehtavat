package ohtu;

import java.io.File;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();
        Random r = new Random();

        driver.get("http://localhost:4567");
        
        sleep(2);
        System.out.println(driver.getPageSource());
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("Pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1234");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        sleep(2);
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
        sleep(2);
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(2);
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("kayttaja"+ r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("password2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password2");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(2);
        System.out.println(driver.getPageSource());
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
