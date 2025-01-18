package Resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BasePage;
import Base.Extentmanager;

public class Listeners extends BasePage implements ITestListener{
	public Listeners() throws IOException{
		super();
	}

//	 @Override
//	public void onFinish(ITestContext context) {
//    	 try {
//    		 TakeSnapShot(context.getName());
// 	    }catch (Exception e) {
// 	    	e.printStackTrace();
//      }
//  }
	@Override
	  public synchronized void onStart(ITestContext context) {
		   Extentmanager.GetReport();
		   Extentmanager.CreateTest(context.getName(), context.getName());
		  }
	  
	@Override
	  public  synchronized void onTestSuccess(ITestResult result) {
		  Extentmanager.GetTest().pass(result.getThrowable());
		  try {
			  System.out.println("Test Passed: "+ result.getName());
	    		 TakeSnapShot(result.getMethod().getMethodName());
	    		 Extentmanager.AttachImage();
	 	    }catch (Exception e) {
	 	    	e.printStackTrace();
	      }
		  }
	  
	  
	  public synchronized void onFinish(ITestContext context) {
		    Extentmanager.FlushReport();
		  }

}
