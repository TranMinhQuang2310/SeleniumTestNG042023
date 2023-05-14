package quangtester.com.Bai12_ActionsClassRobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest_OLD;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestRobotClassOLD extends BaseTest_OLD {
    //VD1 : Dùng KeyPress và KeyRelease
    @Test
    public void inputText() throws InterruptedException, AWTException {
        driver.get("https://anhtester.com/");
        sleep(2);

        //Bắt xpath ô search : Tìm kiếm khóa học
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = new Robot();
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);

        sleep(1);
        //Nhấn phím ENTER
        robot.keyPress(KeyEvent.VK_ENTER);

        //Nhả phím ENTER ra
        robot.keyPress(KeyEvent.VK_ENTER);

        sleep(2);
    }

    //VD2 : Dùng mouseMove, mousePress , mouseRelease => Nhấn vô nút "Sign Up"
    @Test
    public void mousePress() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = new Robot();
        //Di chuyển trỏ chuột đến vị trí x,y => vị trí nút "Sign Up"
        robot.mouseMove(1400, 200);
        //Dalay giống sleep
        robot.delay(1000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thả chuột trái ra (Để ý khi thả ra thì nút Sign Up mới được nhấn)
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.delay(2000);
        sleep(2);
    }

    //VD3 (Cách 1) : Chụp màn hình thông qua Robot class => Run xong sẽ có hình dưới cùng trong thanh menu bên trái
    @Test
    public void createScreenCapture() throws InterruptedException, AWTException, IOException {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = new Robot();

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("TestImageRobot.png");
        ImageIO.write(image, "png", file);

        sleep(1);
    }

    //VD3 (Cách 2) : Chụp màn hình thông qua Robot class => Run xong sẽ có hình dưới cùng trong thanh menu bên trái
    public void screenshot(String imageName) throws  InterruptedException, AWTException, IOException {
        Robot robot = new Robot();

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File(imageName + ".png");
        ImageIO.write(image, "png", file);
    }

    @Test
    public void createScreenCapture_Cach2() throws InterruptedException, AWTException, IOException {
        driver.get("https://anhtester.com/");
        sleep(1);

        screenshot("testscreenshot_cach2");
        sleep(1);
    }

}
