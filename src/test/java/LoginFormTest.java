import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


/**
 * Created by root on 17.06.14.
 */
public class LoginFormTest {
    private WebDriver ffdriver;


    @Before
    public void setUp() throws Exception {
        ffdriver = new FirefoxDriver();
        ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginField() throws Exception {
        System.out.println("Check Login Empty");
        ffdriver.get("https://drupal.org/");
        ffdriver.findElement(By.cssSelector("div [id = 'nav-masthead'] li:nth-child(2) a")).click();
        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-password form-item-pass'] input")).sendKeys("1111");
        ffdriver.findElement(By.cssSelector("div [id = 'edit-actions'] input")).submit();

        String actual = ffdriver.findElement(By.cssSelector("div [class='messages error']")).getText();
        String expected = "Username field is required";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testPassField() throws Exception {
        System.out.println("Check Password Empty");
        ffdriver.get("https://drupal.org/");
        ffdriver.findElement(By.cssSelector("div [id = 'nav-masthead'] li:nth-child(2) a")).click();
        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-textfield form-item-name'] input")).sendKeys("1111");
        ffdriver.findElement(By.cssSelector("div [id = 'edit-actions'] input")).submit();

        String actual = ffdriver.findElement(By.cssSelector("div [class='messages error']")).getText();
        String expected = "Password field is required";
        assertTrue(actual.contains(expected));


    }

    @Test
    public void testLogPassField() throws Exception {
        System.out.println("Check Login/Password Empty");
        ffdriver.get("https://drupal.org/");
        ffdriver.findElement(By.cssSelector("div [id = 'nav-masthead'] li:nth-child(2) a")).click();
        ffdriver.findElement(By.cssSelector("div [id = 'edit-actions'] input")).submit();

        String actual = ffdriver.findElement(By.cssSelector("div [class='messages error']")).getText();
        String expected1 = "Username field is required";
        String expected2 = "Password field is required";
        assertTrue(actual.contains(expected1) && actual.contains(expected2));
    }



   @Test
    public void testSuccessLogin() throws Exception {
        ffdriver.get("https://drupal.org/");
        ffdriver.findElement(By.cssSelector("div [id = 'nav-masthead'] li:nth-child(2) a")).click();

        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-textfield form-item-name'] input")).sendKeys("oa.org.ua");
        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-password form-item-pass'] input")).sendKeys("12345Q");
        ffdriver.findElement(By.cssSelector("div [id = 'edit-actions'] input")).submit();
        assertTrue(ffdriver.findElement(By.cssSelector("div [id = 'userinfo'] a:nth-child(1)")).getText(), true);


    }

    @Test
    public void testNotSuccessLogin() throws Exception {
        ffdriver.get("https://drupal.org/");
        ffdriver.findElement(By.cssSelector("div [id = 'nav-masthead'] li:nth-child(2) a")).click();

        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-textfield form-item-name'] input")).sendKeys("oa.org.uaa");
        ffdriver.findElement(By.cssSelector("div [class= 'form-item form-type-password form-item-pass'] input")).sendKeys("12345Qa");
        ffdriver.findElement(By.cssSelector("div [id = 'edit-actions'] input")).submit();

        String actual = ffdriver.findElement(By.cssSelector("div [class='messages error']")).getText();
        String expected = "Sorry, unrecognized username or password";
        assertTrue(actual.contains(expected));



    }


}
