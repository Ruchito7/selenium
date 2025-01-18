package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {
	private  Properties prop;
	private String Url;
	public static String SSDestinationPath;


	public BasePage() throws IOException{
		prop = new Properties();
		FileInputStream data = new FileInputStream("C:\\Users\\ruchi\\SSelenium\\Workspace2\\CovidMavenProject\\src\\main\\java\\Resources\\config.properties");
	prop.load(data);

	}

	public static WebDriver GetDriver() {
		return WebDriverInstance.GetDriver();
		

	}

	public String GetUrl() {
		Url= prop.getProperty("url");
		return Url;

	}

	public static String TakeSnapShot(String Name) throws IOException {
		File srcfile = ((TakesScreenshot)GetDriver()).getScreenshotAs(OutputType.FILE);
		String DestFile = "C:\\Users\\ruchi\\SSelenium\\Workspace2\\CovidMavenProject\\target\\Screenshots"+timestamp()+".png";
		SSDestinationPath=DestFile;
		try {
		FileUtils.copyFile(srcfile, new File(DestFile));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return Name;
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public static String GetSSDestinationPath() {
		return SSDestinationPath;
	}
}
