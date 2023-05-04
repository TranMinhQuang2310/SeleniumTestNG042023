package quangtester.com.Bai10_AnnotationTestNG;

import org.testng.annotations.*;

public class PriorityAnnotationTestNG {
    //Đề bài : Ví dụ Run theo thứ tự chạy của Before và After

    //Suite
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    //Test
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    //Class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    //Group 1 :
    @BeforeGroups(groups = {"testOne"})
    public void beforeGroupOne() {
        System.out.println("Before Group testOne");
    }
    @AfterGroups(groups = { "testOne" })
    public void afterGroupOne() {
        System.out.println("After Group testOne");
    }

    //Group 2 :
    @BeforeGroups(groups = { "testTwo" })
    public void beforeGroupTwo() {
        System.out.println("Before Group testTwo");
    }
    @AfterGroups(groups = { "testTwo" })
    public void afterGroupTwo() {
        System.out.println("After Group testTwo");
    }

    //Method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    //@Test
    @Test(groups = { "testOne" })
    public void testOneMethod() {
        System.out.println("Test method One");
    }
    @Test(groups = { "testTwo" })
    public void testTwoMethod() {
        System.out.println("Test method Two");
    }


}
