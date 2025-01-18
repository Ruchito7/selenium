package Page_Object;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class KnowGoSection_PageObj extends BasePage{
	public KnowGoSection_PageObj() throws IOException {
		super();
	}

	
	By WhatsUrRiskButton = By.cssSelector("a[title='What\\27s Your Risk?']");
	By TakeActionButton  = By.cssSelector("a[title='Take Action']");
	By VisitCDCLink = By.cssSelector("a[title='Visit the CDC website']");
	By KnowUrRiskButton = By.cssSelector("a[title='Know Your Risk']");
	By VisitCDCEPContinue= By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/www\\.cdc\\.gov\\/covid\\/risk-factors\\/index\\.html > .core-overlay-wrapper a[title='Continue']");
	By VisitCDCEPCancel = By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/www\\.cdc\\.gov\\/covid\\/risk-factors\\/index\\.html > .core-overlay-wrapper .button.secondary");
	By VisitCDCEPClose = By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/www\\.cdc\\.gov\\/covid\\/risk-factors\\/index\\.html > .core-overlay-wrapper button[title='Close popup']");
	By KnowUrRiskEPContinue= By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/ada\\.com\\/covid\\/antiviral-treatment-criteria-questionnaire\\/ > .core-overlay-wrapper a[title='Continue']");
	By KnowUrRiskEPCancel = By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/ada\\.com\\/covid\\/antiviral-treatment-criteria-questionnaire\\/ > .core-overlay-wrapper .button.secondary");
	By KnowUrRiskEPClose  = By.cssSelector("dialog#overlay-external-link--https\\:\\/\\/ada\\.com\\/covid\\/antiviral-treatment-criteria-questionnaire\\/ > .core-overlay-wrapper button[title='Close popup']");
	String VisitCDCUrl= "https://www.cdc.gov/covid/risk-factors/index.html";
	String KnowUrRiskUrl= "https://ada.com/covid/antiviral-treatment-criteria-questionnaire/";
	
	public WebElement GetWhatsUrRiskButton() {
		return GetDriver().findElement(WhatsUrRiskButton);
		
	}
	
	public WebElement GetTakeActionButton() {
		return GetDriver().findElement(TakeActionButton);
		
	}
	
	public WebElement GetVisitCDCLink() {
		return GetDriver().findElement(VisitCDCLink);
		
	}
	
	public WebElement GetKnowUrRiskButton() {
		return GetDriver().findElement(KnowUrRiskButton);
		
	}
	
	public WebElement GetVisitCDCEPContinue() {
		return GetDriver().findElement(VisitCDCEPContinue);
		
	}
	
	public WebElement GetVisitCDCEPCancel() {
		return GetDriver().findElement(VisitCDCEPCancel);
		
	}
	
	public WebElement GetVisitCDCEPClose() {
		return GetDriver().findElement(VisitCDCEPClose);
		
	}
	
	public WebElement GetKnowUrRiskEPContinue() {
		return GetDriver().findElement(KnowUrRiskEPContinue);
		
	}
	
	public WebElement GetKnowUrRiskEPCancel() {
		return GetDriver().findElement(KnowUrRiskEPCancel);
		
	}
	
	public WebElement GetKnowUrRiskEPClose() {
		return GetDriver().findElement(KnowUrRiskEPClose);
		
	}
	
	public String GetVisitCDCUrl() {
		return VisitCDCUrl;
		 
		
		
	}
	
	public String GetKnowUrRiskUrl() {
		 return KnowUrRiskUrl;
		 
		
	}
	
	public WebElement GetKnowGoSecInView() {
		 return GetDriver().findElement(By.cssSelector(".block.columns.columns-3-cols.kpg img"));
		
	}
	
	public WebElement GetKnowInView() {
		 return GetDriver().findElement(By.cssSelector(".columns-container.cta-container.purple.section.section-intro-container > .default-content-wrapper > p:nth-of-type(2)"));
		
	}
}
