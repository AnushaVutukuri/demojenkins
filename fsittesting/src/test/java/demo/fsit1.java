package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class fsit1 {
	

	WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
	
			String currDir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
	  }

  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	 driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(n);
		
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(s);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(3000);
    	WebElement logout=driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a"));
    	logout.click();
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "linda.anderson", "linda.anderson" },
    };
  }
 

  
  @AfterTest
  public void afterTest() {
  }

}


