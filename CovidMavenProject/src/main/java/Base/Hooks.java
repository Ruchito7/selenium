package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Page_Object.NavBar_PageObj;

public class Hooks extends BasePage{
	public Hooks() throws IOException {
		super();
	}

	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {
		GetDriver().get(GetUrl());
		WebDriverWait wait= new WebDriverWait(GetDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='onetrust-banner-sdk']/div[@role='dialog']//div[@class='ot-sdk-row']")));
		NavBar_PageObj NavBar = new NavBar_PageObj();
		Actions action= new Actions(GetDriver());
		action.moveToElement(NavBar.GetCookieAcceptButton()).click().perform();;
		Thread.sleep(2000);
		
	}	
	
	@AfterMethod
	public void TearDown() {
		WebDriverInstance.CleanUpDriver();
	}
}
