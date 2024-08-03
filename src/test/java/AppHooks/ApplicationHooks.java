package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utils.configureReadFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.factory.DriverFactory;


public class ApplicationHooks {
	private configureReadFile configreader;
	private DriverFactory driverfactory;
	private Properties prop;
	private WebDriver driver;
	@Before(order=0)
	public void getproperty() {
		configreader=new configureReadFile();
		prop=configreader.init_prop();
		
	}
	@Before(order=1)
	public void Lunch_browser() {
		String browsername=prop.getProperty("browser");
		driverfactory=new DriverFactory();
		driver=driverfactory.init_driver(browsername);
		
	}
//	@After(order=0)
//	public void Quit_browser() {
//		driver.quit();
//	}
	@After(order=1)
	public void teardown(Scenario scenario) {
		//Take Screen shot
		if(scenario.isFailed()) {
		String screenshotname=scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotname);
		}
	}
}
