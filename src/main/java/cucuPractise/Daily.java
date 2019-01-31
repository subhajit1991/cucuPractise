package cucuPractise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.eviware.soapui.support.SoapUIException;

import config.Conf;

import input.Read;

import renameFile.Rename;

public class Daily {
	private WebDriver driver=null;
	private List<String> temp=new ArrayList<String>();
	
	Conf Conf;
	
  @Test
  public void f() throws IOException, InterruptedException, XmlException, SoapUIException {
	    Conf= new Conf();
	    System.setProperty("webdriver.chrome.driver", Conf.getDriverPath());
        String baseUrl = Conf.getApplicationUrl();
	    
				driver.get(baseUrl);

	    driver.manage().window().maximize();
	    //WebDriverWait myWaitVar= new WebDriverWait(driver, 10);
	    
	    driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
	    
	    String filePath=Conf.getExcelPath();
	    String fileName=Conf.getExcelName();
	    String sheetName=Conf.getSheetName();
		
		
	    temp = Read.readExcel(filePath, fileName, sheetName);	   
		    
	    driver.findElement(By.id("jazz_app_internal_LoginWidget_0_userId")).sendKeys(temp.get(0));
	    
	    driver.findElement(By.id("jazz_app_internal_LoginWidget_0_password")).sendKeys(temp.get(1));
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    driver.findElement(By.xpath("//a[@id='jazz_ui_MenuPopup_3']")).click();
	    
	    driver.findElement(By.xpath("//span[@id='jazz_ui_menu_MenuItem_2_text'][contains(text(),'Shared Queries')]")).click();
	    
	    driver.findElement(By.xpath("//span[@class='twisty'][@id='com_ibm_team_rtc_foundation_web_ui_gridviewer_TreeTwistie_10']")).click();
	    
	    driver.findElement(By.xpath(".//*[contains(text(),'Individually Shared')]/preceding::span[1]")).click();//*[@id="com_ibm_team_rtc_foundation_web_ui_gridviewer_TreeTwistie_9226"]
	    
	    driver.findElement(By.xpath("//a[@class='label'][contains(text(),'Abhishek')]")).click();
	    
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//img[@class='button-img sprite-image-11' and @alt='Download as Spreadsheet (.csv)']")).click();
	    
	    Thread.sleep(10000);
	    
	    Rename rename = new Rename();
	    rename.abc();
	    
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SUBROY\\Downloads\\Chrome\\chromedriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-notifications");
      capabilities.setCapability("chrome.binary","C:\\Users\\SUBROY\\Downloads\\Chrome\\chromedriver.exe");
      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
      options.merge(capabilities);
      driver = new ChromeDriver(options);
      
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

