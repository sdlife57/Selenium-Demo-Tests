import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.File;
import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.WebDriverWait;



public class upload {
	

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    @Test
    public void uploadFile() throws Exception {
        String filename = "some_file.txt";
        File file = new File(filename);
        String path = file.getAbsolutePath();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        assertThat(text, is(equalTo(filename)));
        
        System.out.println(driver.getTitle());
    }
}