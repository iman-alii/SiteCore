

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



@Test
public class Google {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("http:\\google.com");
	
	}

	public void testc1() throws AWTException {
		
		driver.switchTo().frame(0); 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"introAgreeButton\"]/span/span"))); //wait for the I agree button to appear
		
		driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click(); // click on the I agree button
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Ämsterdam"); //enter Amsterdam in the search field 
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	@AfterMethod 
	public void AfterMethod () throws IOException, AWTException, InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='qrShPb kno-ecr-pt PZPZlf mfMhoc']/span[1]")));
		driver.manage().window().maximize();
		CaptureScreen(); 
		driver.close();

	
	}

	private void CaptureScreen() throws IOException, AWTException {
		 Robot robot = new Robot();

	
		    Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    
		    BufferedImage bufferedImage = robot.createScreenCapture(area);
		 
		    File file = new File("Amsterdam.png");
		    
		    ImageIO.write(bufferedImage, "png", file);
		  
	}
}

