package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameter;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger; // Log4j
	public Properties p;

	@SuppressWarnings("deprecation")
	@BeforeClass(groups = { "sanity", "regression", "master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws InterruptedException, IOException {

		// Loading confic.properties file
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//			capabilities.setPlatform(Platform.LINUX);
//			capabilities.setBrowserName(Browser.CHROME);
			// but here we are passing os and browser through our master.xml in form of
			// parameter so

			// os
			if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.IOS);
			} else {
				System.out.println("No matching platform found");
				return;
			}

			// browser

			switch (br.toLowerCase()) {
			case "chrome": {
				capabilities.setBrowserName("chrome");
				break;
			}
			case "firefox": {
				capabilities.setBrowserName("firefox");
				break;
			}
			case "edge": {
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			}
			default: {
				System.out.println("No matching browser");
				return;
			}

				// Initialize RemoteWebDriver

			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		} else {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
//			FirefoxOptions options = new FirefoxOptions();
//			driver = new FirefoxDriver(options);
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name....");
				return;

			}
		}

//		driver = new ChromeDriver();

//		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Thread.sleep(3000);

//		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.get(p.getProperty("appurl")); // reading url from properties file
	}

	@AfterClass(groups = { "sanity", "regression", "master" })
	public void teardown() {
		driver.quit();
	}

	public String RandomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

//	public String RandomString() {
//		return(RandomStringUtils.randomAlphabetic(5));
//		
//	}

	public String Randomnumber() {
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}

	public String RandomAlpha() {
		String generatedAlphanumber = RandomStringUtils.randomAlphanumeric(5);
		return (generatedAlphanumber + "@");
	}

	public String captureScreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "/Screenshots/" + tname + "_" + timestamp + ".jpg";
		File targetfile = new File(targetFilePath);

		sourceFile.renameTo(targetfile);
		return targetFilePath;

	}

}
