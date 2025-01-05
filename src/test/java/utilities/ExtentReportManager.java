package utilities;

import java.awt.Desktop;
import java.io.File;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info in the report
	public ExtentTest test; // create test case entries in the report and update status of the test methods

	String repname;

	public void onStart(ITestContext context) {

		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt =
		 * new Date(); String currentdatetimestamp = df.format(dt);
		 */

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp

		repname = "Test-report-" + timestamp + ".html";

		System.out.println("Test execution is started");
		sparkReporter = new ExtentSparkReporter("./reports/" + repname); // Specify location for reports
		sparkReporter.config().setDocumentTitle("Automation Report");// Title of report
		sparkReporter.config().setReportName("Functional report"); // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK); // set theme of the report

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Computer Name", "Localhost");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");

		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System ", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("Test passed......");
		test = extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, "Test case passed is :" + result.getName()); // update status

	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		
		test.log(Status.FAIL, "Test case  failed is :" + result.getName());
		test.log(Status.FAIL, "Reason of failure : " + result.getThrowable().getMessage());
		
		try {
			String  imgpath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case  failed is :" + result.getName());
		test.log(Status.SKIP, "Reason of failure : " + result.getThrowable().getMessage());
	}

	@SuppressWarnings("deprecation")
	public void onFinish(ITestContext context) {
		// not implemented
		extent.flush();
		
		// if want to open report automatically after test execution then use this code
	/*	
		String pathOfExtentReport = System.getProperty("user.dir")+ "/reports" + repname;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	    String pathOfExtentReport = System.getProperty("user.dir") + "/reports/" + repname;
	    File extentReport = new File(pathOfExtentReport);

	    try {
	        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	            // Use xdg-open on Linux
	            String command = "xdg-open " + extentReport.getAbsolutePath();
	            Runtime.getRuntime().exec(command);
	        } else {
	            // Use Desktop on other OS
	            Desktop.getDesktop().browse(extentReport.toURI());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	}


