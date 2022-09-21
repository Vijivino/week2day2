package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	//Launch the browser	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
	//Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
	//Click Login,crm/sfa link,Leads link, Find leads	
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find")).click();
    //Enter first name	
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("first");
	//Click Find leads buttonand on first resulting lead	
		driver.findElement(By.xpath(("(//button[@type='button'])[6]"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
	//Verify title of the page	
		String title = driver.getTitle();
		System.out.println(title);
	//Click Edit	
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	//Change the company name	
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");
	//Click Update	
		driver.findElement(By.name("submitButton")).click();
	//Confirm the changed name appears
		if (driver.findElement(By.id("viewLead_companyName_sp")).equals("TestLeaf"));
		System.out.println("The companyName is changed Succesfully");
	//Close the browser (Do not log out)	
		driver.close();
		
		
			}

}
