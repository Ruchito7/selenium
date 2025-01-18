package Base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentmanager extends BasePage{
	
	public static ExtentReports extentReport;
	public static String extentReportPrefix;
	public static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<>();
	
	
	public Extentmanager() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ExtentReports GetReport() {
		if (extentReport==null) {
			SetupExtentReport("maven project");
		}
		return extentReport;
		
	}
	
	public static ExtentReports SetupExtentReport(String Testname) {
		extentReport= new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/"+ ExtentReportprefix_name(Testname)+".html");
		extentReport.attachReporter(spark);
		extentReport.setSystemInfo("Tester", "My Name");
		spark.config().setReportName("Regression Test");
		spark.config().setDocumentTitle("test Results");
		spark.config().setTheme(Theme.DARK);
		return extentReport;
		
	}
	
	public static String ExtentReportprefix_name(String Testname) {
		String date= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		extentReportPrefix= Testname+" "+ date;
		return extentReportPrefix;
		
	}
	
	public static void FlushReport() {
		extentReport.flush();
	}
	
	public synchronized static ExtentTest GetTest() {
		return extenttest.get();
	}
	
	
	public synchronized static ExtentTest CreateTest(String name, String description) {
		ExtentTest Test= extentReport.createTest(name,description);
		extenttest.set(Test);
		return GetTest();
	}
	
	
	public synchronized static void log(String massage) {
		GetTest().info(massage);
	}
	
	public synchronized static void Pass(String massage) {
		GetTest().pass(massage);
	}
	
	public synchronized static void Fail(String massage) {
		GetTest().fail(massage);
	}
	
	public synchronized static void AttachImage() {
		GetTest().addScreenCaptureFromPath(GetSSDestinationPath());
	}
}
