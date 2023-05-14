package quangtester.com.Bai14_JavascriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest_OLD;
import quangtester.com.keywords.WebUI;

import java.io.File;
import java.io.IOException;


public class ExecuteScriptExamples extends BaseTest_OLD {
    @Test
    public void testScript01() {
        driver.get("https://app.hrsale.com/");
        WebUI.sleep(5);

          /*
              VD1 - TH1 : Click vào button 'Super Admin' => Dùng selenium
          */
//        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();

         /*
               VD1 - TH2 : Click vào button 'Super Admin' => Dùng javascript
         */

        //Click object với JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;// Khai báo và khởi tạo giá trị cho đối tượng
//        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")));

//        -------------------------------------------------------------------------------------
         /*
              VD2 - TH1 : Điền giá trị vào ô input CÓ dùng sendkey() => Dùng selenium
         */
//         js.executeScript("arguments[0].setAttribute('value','frances.burns');",driver.findElement(By.xpath
//                 ("//input[@id='iusername']")));
//         js.executeScript("arguments[0].setAttribute('value','frances.burns');",driver.findElement(By.xpath
//                 ("//input[@id='ipassword']")));
//         driver.findElement(By.xpath("//button[@type='submit']")).click();

         /*
              VD2 - TH3 : Điền giá trị vào ô input CÓ dùng sendkey() nhưng để giá trị nhập ra bên ngoài => Dùng selenium
         */

         js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement
                 (By.xpath("//input[@id='iusername']")),"frances.burns");
         js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement
                 (By.xpath("//input[@id='ipassword']")),"frances.burns");
         driver.findElement(By.xpath("//button[@type='submit']")).click();


         /*
              VD2 - TH2 : Điền giá trị vào ô input mà KHÔNG dùng sendkey() => Dùng javascript
         */
//        js.executeScript("document.getElementById('email').setAttribute('value','frances.burns');");
//        js.executeScript("document.getElementById('password').setAttribute('value','frances.burns');");


//        -------------------------------------------------------------------------------------

         /*
              VD3 : Thực hiện Cuộn chuột => Dùng selenium
              (*Lưu ý : ở hàm script, true có nghĩa là cuộn xuống mé trên ,false nghĩa là cuộn xuống mé dưới)
         */
        WebElement tickets = driver.findElement(By.xpath("//div[@class='col-sm-6 card-body br']//span[normalize-space()='Tickets']"));
        WebUI.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(false);", tickets);

        WebUI.sleep(3);
    }

    @Test
    public void testScript02() {
        driver.get("https://app.hrsale.com/");

        //Khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
              VD1 : Để tạo Alert
         */
//        js.executeScript("alert('Welcome To Anh Tester - Automation Testing');");


         /*
              VD2 : Highlight câu : "Welcome back, Please login into an accoun"
         */
        WebElement hightlight = driver.findElement(By.xpath("//p[normalize-space()='Welcome back, Please login into an account']"));
        js.executeScript("arguments[0].style.border='3px solid red'",hightlight);

         /*
              VD3 : Yêu cầu
                B1 : Chụp màn hình + có hightlight
                B2 : Tự động tạo ra 1 folder tên là Screenshots
                B3 : Lưu hình chụp màn hình vào folder
         */

        // Tạo tham chiếu của TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
        //Kiểm tra folder có tồn tại không ? Nếu không thì tạo mới folder
        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        // result.getName() => lấy tên của test case xong gán cho tên File chụp màn hình
        try {
            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Screenshot taken");

        WebUI.sleep(3);
    }


        @Test
        public void testScript03() {
            driver.get("https://app.hrsale.com/");

            //Khai báo và khởi tạo giá trị đối tượng
            JavascriptExecutor js = (JavascriptExecutor) driver;

             /*
                  VD1 : Yêu cầu in đoạn text "Welcome to HRSALE" bằng innerText -> dùng innerText
             */
            String innertext = js.executeScript("return arguments[0].innerText", driver.findElement
                    (By.xpath("//h4[@class='mb-3 f-w-600']"))).toString();
            System.out.println("Đoạn text được in ra là :" +innertext);

             /*
                  VD2 : Kiểm tra đoạn text "Welcome to HRSALE" có được edit hay không - dùng isContentEditable
             */
            Boolean isEdit = (Boolean) js.executeScript("return arguments[0].isContentEditable",driver.findElement
                    (By.xpath("//h4[@class='mb-3 f-w-600']")));
            System.out.println("Kiểm tra đoạn text :" + isEdit);

            WebUI.sleep(3);

        }
}
