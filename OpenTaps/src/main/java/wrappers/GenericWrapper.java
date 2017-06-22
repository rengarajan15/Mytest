package wrappers;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrapper implements Wrappers {

	RemoteWebDriver driver;
	int i=1;


	@Override
	public void invokeApp(String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();			
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		takeSnap();

	}

	@Override
	public void enterById(String idValue, String data) {
		
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text "+idValue+" entered successfully");
		takeSnap();
	}

	@Override
	public void enterByName(String nameValue, String data) {
		
		driver.findElementByName(nameValue).sendKeys(data);
		System.out.println("The name entered successfully");
		takeSnap();

	}

	@Override
	public void enterByXpath(String xpathValue, String data) {

		driver.findElementByXPath(xpathValue).sendKeys(data);
		System.out.println("Xpath"+xpathValue+"entered successfully");
		takeSnap();
	}

	@Override
	public boolean verifyTitle(String title) {

		String pageTitle = driver.getTitle();
		if(pageTitle.equalsIgnoreCase(title)){
			System.out.println("Title Verified");
			return true;
		}
		else 
			{
			System.out.println("Title was unmatched");
			return false;
			}
	}

	@Override
	public void verifyTextById(String id, String text) {
		System.out.println(driver.findElementById(id));
		String pageText = driver.findElementById(id).getText();
		System.out.println(pageText);
		if(pageText.equalsIgnoreCase(text)){
			System.out.println("Text Verified");
			}
		else 
			{
			System.out.println("Text was unmatched");
			}

	}

	@Override
	public void verifyTextByXpath(String xpath, String text) {
		String pageXpath = driver.findElementByXPath(xpath).getText();
		if(pageXpath.equalsIgnoreCase(text)){
			System.out.println("Xpath Verified");
			}
		else 
			{
			System.out.println("Xpath was unmatched");
			}

	}

	@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		
		String textXpath = driver.findElementByXPath(xpath).getText();
		if(textXpath.contains(xpath)){
			System.out.println("Xpath Text Verified");
		}
		else
		{
			System.out.println("Xpath was unmatched");
		}

	}

	@Override
	public void verifyTextContainsById(String id, String text) {

		String textId = driver.findElementById(id).getText();
		if(textId.contains(text)){
			System.out.println("Id Text Verified");
		}
		else
		{
			System.out.println("Id was unmatched");
		}

	}

	@Override
	public void clickById(String id) {
		
		driver.findElementById(id).click();
		System.out.println("The Button "+id+" is clicked");
		takeSnap();
	}

	@Override
	public void clickByClassName(String classVal) {
		
		driver.findElementByClassName(classVal).click();
		System.out.println("The Button "+classVal+" is clicked");
		takeSnap();

	}

	@Override
	public void clickByName(String name) {

		driver.findElementByName(name).click();;
		System.out.println("The name entered succesfully");
		takeSnap();

	}

	@Override
	public void clickByLink(String name) {

		driver.findElementByLinkText(name).click();;
		System.out.println("The Link Text entered successfully");
		takeSnap();

	}

	@Override
	public void clickByXpath(String xpathVal) {
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The Button "+xpathVal+" is clicked");
		takeSnap();

	}

	@Override
	public String getTextById(String idVal) {

		String idText = driver.findElementById(idVal).getText();
		if(idText.isEmpty()){
			System.out.println("Text is empty");
		    return null;
		}
		else
		{
			System.out.println("The Text is " +idText);
			return idText;
		}
	}
	
	@Override
	public void getTextById1(String idVal) {

		String idText1 = driver.findElementById(idVal).getText();
		String[] obj = idText1.split(" ");
		String id = obj[1];
		id = id.replace("(", "").replace(")", "");
		System.out.println(id);
	}
	

	@Override
	public String getTextByXpath(String xpathVal) {
		String xpathText = driver.findElementByXPath(xpathVal).getText();
		if(xpathText.isEmpty()){
			System.out.println("Text is empty");
		    return null;
		}
		else
		{
			System.out.println("The Text is"+xpathText);
			return xpathText;
		}
	}

	@Override
	public void selectVisibileTextById(String id, String value) {

		WebElement visibleId = driver.findElementById(id);
		Select option = new Select(visibleId);
		option.selectByVisibleText(value);
		System.out.println("Visible Text selected");
		takeSnap();

	}

	@Override
	public void selectIndexById(String id, String value) {

		WebElement indexId = driver.findElementById(id);
		Select option = new Select(indexId);
		int value1 = Integer.parseInt(value);
		option.selectByIndex(value1);
		System.out.println("Index By Id selected");
		takeSnap();

	}

	@Override
	public void switchToParentWindow() {

		Set <String> allbrowsers = driver.getWindowHandles();
		Iterator <String> browsers=  allbrowsers.iterator();
		String parentWindow = browsers.next();
		driver.switchTo().window(parentWindow);
		System.out.println("Swiched to parent/default window");
		takeSnap();

	}
	
			
	

	@Override
	public void switchToLastWindow() {

		Set<String> allbrowsers = driver.getWindowHandles();
		//int totalWindow =  Windows.size();
		for (String windows : allbrowsers) {
			if(!windows.equals(allbrowsers))
			driver.switchTo().window(windows);
		}
		/*String lastWindow = Windows.iterator().next();
		driver.switchTo().window(lastWindow);*/
			
		System.out.println("Swiched to last window");
		takeSnap();
		}

	@Override
	public void acceptAlert() {

		driver.switchTo().alert();
		System.out.println("Alert Accepted");

	}

	@Override
	public void quitBrowser() {
		
		driver.quit();
		System.out.println("Browser Quit");

	}

	@Override
	public void takeSnap() {
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}

