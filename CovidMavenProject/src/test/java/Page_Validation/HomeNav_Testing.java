package Page_Validation;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Extentmanager;
import Base.Hooks;
import Page_Object.NavBar_PageObj;

  @Listeners(Resources.Listeners.class)
public class HomeNav_Testing extends Hooks{

	public HomeNav_Testing() throws IOException {
		super();

	}



	@Test
	public void NavValidation() throws IOException, InterruptedException {
		Extentmanager.log("Nav bar links validation started...");
		NavBar_PageObj NavBar = new NavBar_PageObj();
		NavBar.GetKnow_Link().click();
		Extentmanager.Pass("Know link clicked...");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)GetDriver();
		boolean KnowSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetKnowSection());
		try {
		Assert.assertTrue(KnowSecInView);
		//Assert.assertTrue(NavBar.GetKnowSection().isDisplayed(),"Didnt jumped to Know Section");
		Extentmanager.Pass("navigated to know section correctly");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here");
		}
		
		((JavascriptExecutor)GetDriver()).executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);
		Extentmanager.Pass("came to top bar to click another link...");

		NavBar.GetGo_Link().click();
		Extentmanager.Pass("clicked on the go link...");
		Thread.sleep(2000);
		boolean GoSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetGoSection());
		
		try {
		Assert.assertTrue(GoSecInView,"Didnt jumped to go Section");
		Extentmanager.Pass("navigated to know section correctly");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here");
		}
		//Assert.assertTrue(NavBar.GetGoSection().isDisplayed(),"Didnt jumped to Know Section");
		((JavascriptExecutor)GetDriver()).executeScript("window.scrollTo(0,0);");
		Extentmanager.Pass("came to top bar to click another link...");
		Thread.sleep(2000);
		

		NavBar.GetTelehealth_Link().click();
		Extentmanager.Pass("clicked on the Telehealth link...");
		Thread.sleep(2000);
		boolean TelehealthSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetTeleHealthSection());
		try {
		Assert.assertTrue(TelehealthSecInView,"Didnt jumped to go Section");
		Extentmanager.Pass("navigated to know section correctly");
		//Assert.assertTrue(NavBar.GetTeleHealthSection().isDisplayed(),"Didnt jumped to Know Section");
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here");
		}
		
		
		((JavascriptExecutor)GetDriver()).executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);
		Extentmanager.Pass("came to top bar to click another link...");

		NavBar.GetResources_Link().click();
		Extentmanager.Pass("clicked on the Telehealth link...");
		Thread.sleep(2000);
		boolean ResourceSecInView= (boolean) js.executeScript("const elem = arguments[0];" +
	            "const rect = elem.getBoundingClientRect();" +
	            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
	            NavBar.GetResourceSection());
		try {
		Assert.assertTrue( ResourceSecInView,"Didnt jumped to go Section");
		//Assert.assertTrue(NavBar.GetResourceSection().isDisplayed(),"Didnt jumped to Know Section");
		
		}catch(AssertionError e) {
			Assert.fail("didnt navigated to correct section");
			Extentmanager.Fail("didnt navigated to correct section test failed here");
		}
		
		((JavascriptExecutor)GetDriver()).executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);
		
		Extentmanager.Pass("came to top bar test complete...");

	}






}
