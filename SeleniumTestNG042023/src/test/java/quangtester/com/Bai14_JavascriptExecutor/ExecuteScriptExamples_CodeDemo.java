package quangtester.com.Bai14_JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest_OLD;
import quangtester.com.keywords.WebUI;

public class ExecuteScriptExamples_CodeDemo extends BaseTest_OLD {
    /*
        VD1 : Dùng :
            - document.title
            - document.domain
            - alert
    */
    @Test
    public void jsExecutorDemo01() {
        //Khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://anhtester.com/");
        WebUI.sleep(2);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();",button);
        WebUI.sleep(2);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In')");

        WebUI.sleep(2);
    }

    /*
        VD2 : Dùng : sendkey
    */
    @Test
    public void jsExecutorDemo02() {
        driver.get("https://app.hrsale.com/");
        //Khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // sendKeys text on input
        js.executeScript("document.getElementById('iusername').setAttribute('value','frances.burns');");
        js.executeScript("document.getElementById('ipassword').setAttribute('value','frances.burns');");

        js.executeScript("document.getElementsByClassName('btn btn-primary mt-2 ladda-button')[0].click()");

    }

    /*
        VD3 Dùng : Scroll and Click để cuộn xuống tab menu "Disciplinary Cases" trên thanh left menu
    */

    @Test
    public void jsExecutorDemo03() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Gọi lại hàm login ở VD2
        jsExecutorDemo02();

        WebElement test = driver.findElement(By.xpath("//span[normalize-space()='Disciplinary Cases']"));
        //test.click();  => Nếu dùng dòng này đơn thuần sẽ không click được vì bị che 1 element khác là thanh cuộn

        // Scroll to element and click
        js.executeScript("arguments[0].scrollIntoView(true);",test);
        WebUI.sleep(2);
        js.executeScript("arguments[0].click;",test);
        WebUI.sleep(2);
    }

    /*
        VD4 Dùng : Set và Get LocalStorage với Javascript
    */
    @Test
    public void localStorage() {
        String localGetVar = "";

        driver.navigate().to("https://anhtester.com");
        WebUI.sleep(1);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Set giá trị 30 vào biến age
        js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");

        WebUI.sleep(1);

        //Get giá trị biến age
        localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");

        System.out.println("Giá trị vừa được truyền vào biến age là :" + localGetVar);

        WebUI.sleep(1);
    }

}
