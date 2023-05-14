package quangtester.com.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class WebUI {
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 15 : TestExplicitWait
    public static void waitForElementVisible(WebDriver driver,By by, int seconds_of_timeout) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeout));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(WebDriver driver,By by,int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(WebDriver driver,By by, int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Áp dụng cho Bài 15 : TestFluentWait
    public static void waitForElementVisible_FluentWait (WebDriver driver,By by,int seconds_of_timeouts, int seconds_of_millis ) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts),Duration.ofMillis(seconds_of_millis));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 16 :
    public static Boolean checkElementExist_UseBy(WebDriver driver, By by) {
        List<WebElement> listElement = driver.findElements(by);

        if(listElement.size() > 0) {
            System.out.println("Element" + by + " existing .");
            return true;
        }else{
            System.out.println("Element" + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist_UseXpath(WebDriver driver,String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if(listElement.size() > 0) {
            System.out.println("Element" + xpath + " existing .");
            return true;
        }else{
            System.out.println("Element" + xpath + " NOT exist.");
            return false;
        }
    }

     /**
         * Wait for Page loaded (Chờ đợi trang tải xong) (Javascript tải xong)
     */
     public static void waitForPageLoaded(WebDriver driver) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
         JavascriptExecutor js = (JavascriptExecutor) driver;

         //Wait for Javascript to load
         ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
             @Override
             public Boolean apply(WebDriver driver) {
                 return js.executeScript("return document.readyState").toString().equals("complete");
             }
         };

         //Check JS is Ready
         boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

         //Wait Javascript until it is Ready!
         if (!jsReady) {
             System.out.println("Javascript is NOT Ready.");
             //Wait for Javascript to load
             try {
                 wait.until(jsLoad);
             } catch (Throwable error) {
                 error.printStackTrace();
                 Assert.fail("FAILED. Timeout waiting for page load.");
             }
         }
     }
}
