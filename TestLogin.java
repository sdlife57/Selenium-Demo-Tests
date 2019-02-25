import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestLogin {
	
	private WebDriver driver;

	@Before
	public void setUp() {
	
		
		System.setProperty("webdriver.chromeDriver","/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		
		}
		
		@After
	    public void tearDown() {
	        driver.quit();
	    }
		
		public Boolean isDisplayed(By locator) {
		    try {
		      return driver.findElement(locator).isDisplayed();
		    } catch (org.openqa.selenium.NoSuchElementException exception) {
		      return false;
		    }
		  }
		
		@Test
		public void searchGoogle() {
		
		driver.navigate().to("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("mysql excel 2013");
        driver.findElement(By.name("q")).click();
        assertEquals(driver.getPageSource().contains("results"), true);
        
        System.out.println(driver.getTitle());
        }
		
		@Test
        public void withValidCredentials() {
    	
    	driver.navigate().to("http://the-internet.herokuapp.com/login");
    	driver.findElement(By.id("username")).sendKeys("tomsmith");
    	driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    	driver.findElement(By.cssSelector("#login button")).click();
    	WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash.success")));
        Assert.assertEquals(true, isDisplayed(By.cssSelector("#flash.success")));
    	
    	System.out.println(driver.getTitle());    
       }
		
		@Test
		public void phptravels() {
			
			
		driver.navigate().to("https://www.phptravels.net/login");
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.name("remember")).click();
		driver.findElement(By.cssSelector("#loginfrm button")).click();
    	WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bookings")));
        Assert.assertEquals(true, isDisplayed(By.cssSelector("#bookings")));
    	
    	System.out.println(driver.getTitle());    
		
		}
		
	
		
		

}
