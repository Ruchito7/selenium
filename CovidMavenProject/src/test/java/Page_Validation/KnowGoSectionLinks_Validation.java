package Page_Validation;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Extentmanager;
import Base.Hooks;
import Page_Object.KnowGoSection_PageObj;
import Page_Object.NavBar_PageObj;
@Listeners(Resources.Listeners.class)
public class KnowGoSectionLinks_Validation extends Hooks{

	public KnowGoSectionLinks_Validation() throws IOException {
		super();
		
	}
	
	@Test
	public void SectionLinksValidation() throws IOException, InterruptedException {
		Extentmanager.log("Know & go section lionks validation...");
		String OriginalWindow=GetDriver().getWindowHandle();
		KnowGoSection_PageObj SecLinks = new KnowGoSection_PageObj();
		((JavascriptExecutor)GetDriver()).executeScript("arguments[0].scrollIntoView(true)",SecLinks.GetKnowGoSecInView());
		Extentmanager.Pass("Know & go section came in the view...");
		Thread.sleep(2000);
		SecLinks.GetWhatsUrRiskButton().click();
		Extentmanager.Pass("clicked on the your risk button");
		Thread.sleep(2000);
		NavBar_PageObj NavBar = new NavBar_PageObj();
		JavascriptExecutor js = (JavascriptExecutor)GetDriver();
		boolean KnowSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetKnowSection());
		
		try {
		Assert.assertTrue(KnowSecInView);
		Extentmanager.Pass("Know section came into view");
		//Assert.assertTrue(NavBar.GetKnowSection().isDisplayed(),"Didnt jumped to Know Section");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here...");
			
		}
		Thread.sleep(2000);
		
		
		((JavascriptExecutor)GetDriver()).executeScript("arguments[0].scrollIntoView(true)",SecLinks.GetKnowGoSecInView());
		Extentmanager.Pass("came back to know & go section");
		Thread.sleep(2000);
		SecLinks.GetTakeActionButton().click();
		Extentmanager.Pass("clicked on the take action button");
		Thread.sleep(2000);
		boolean GoSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetGoSection());
		
		try {
		Assert.assertTrue(GoSecInView);
		//Assert.assertTrue(NavBar.GetGoSection().isDisplayed(),"Didnt jumped to Know Section");
		Extentmanager.Pass("go section came into view");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here...");
			
		}
		Thread.sleep(2000);
		
		((JavascriptExecutor)GetDriver()).executeScript("arguments[0].scrollIntoView(true)",SecLinks.GetKnowInView());
		Extentmanager.Pass("Know Link section came into view");
		Thread.sleep(2000);
		SecLinks.GetVisitCDCLink().click();
		Extentmanager.Pass("Clicked on visit CDC link");
		Thread.sleep(2000);
		SecLinks.GetVisitCDCEPContinue().click();
		Extentmanager.Pass("external popup came and Clicked on continue button");
		Thread.sleep(2000);
		Object[] Windows1= GetDriver().getWindowHandles().toArray();
		GetDriver().switchTo().window((String) Windows1[1]);
		try {
		Assert.assertEquals(SecLinks.GetVisitCDCUrl(),GetDriver().getCurrentUrl());
		GetDriver().close();
		GetDriver().switchTo().window(OriginalWindow);
		Thread.sleep(2000);
		Extentmanager.Pass("external site came correctly");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct url");
			Extentmanager.Fail("didnt navigated to correct url test failed here...");
			
		}
		
		((JavascriptExecutor)GetDriver()).executeScript("arguments[0].scrollIntoView(true)",SecLinks.GetVisitCDCLink());
		Extentmanager.Pass("Know Link section came into view again...");
		SecLinks.GetKnowUrRiskButton().click();
		Extentmanager.Pass("Clicked Know your risk button");
		Thread.sleep(2000);
		SecLinks.GetKnowUrRiskEPContinue().click();
		Extentmanager.Pass("external popup came and Clicked on continue button");
		Object[] Windows2= GetDriver().getWindowHandles().toArray();
		GetDriver().switchTo().window((String) Windows2[1]);
		Thread.sleep(2000);
		try {
		Assert.assertEquals(GetDriver().getCurrentUrl(), SecLinks.GetKnowUrRiskUrl());
		GetDriver().close();
		GetDriver().switchTo().window(OriginalWindow);
		Thread.sleep(2000);
		Extentmanager.Pass("external site came correctly");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct url");
			Extentmanager.Fail("didnt navigated to correct url test failed here...");
			
		}
		
		
	}
	

	
}
