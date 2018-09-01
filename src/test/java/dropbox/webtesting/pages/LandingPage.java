package dropbox.webtesting.pages;


import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import dropbox.webtesting.elements.Button;
import dropbox.webtesting.elements.Element;
import dropbox.webtesting.elements.Element.LocatorType;
import dropbox.webtesting.elements.Table;
import dropbox.webtesting.utils.AutoItFunctions;
import dropbox.webtesting.utils.LoadProperties;
import dropbox.webtesting.utils.VerifyFunctions;




public class LandingPage {

	WebDriver driver;
	
	//Element Declaration
		private static Button btnUpload = new Button("//button[@class='mc-popover-trigger']//span[text()='Upload']", LocatorType.XPATH);	
		private static Button btnFileForUpload = new Button("//button[@class='action-upload mc-popover-content-item'][text()='Files']", LocatorType.XPATH);
		private static Button btnMyFiles = new Button("//a[text()='My files']", LocatorType.XPATH);	
		private static Button btnCreateNewFolder = new Button("//div[text()='New folder']", LocatorType.XPATH);
		private static Button btnFiles = new Button("//a[text()='Files']", LocatorType.XPATH);
		private static Button btnOptions = new Button("//button[@class='browse-overflow-menu-trigger mc-popover-trigger']", LocatorType.XPATH);
		private static Button btnDelete = new Button("//button[@role='menuitem'][text()='Delete']", LocatorType.XPATH);
		private static Button btnDeleteYesPopUp = new Button("//button/span[text()='Delete']", LocatorType.XPATH);
		private static Element liUploadTo = new Element("tree-view__item-label", LocatorType.CLASS_NAME);
		private static Button btnUploadTo = new Button("//div[@class='mc-util-modal-actions-buttons']/button[2]", LocatorType.XPATH);	
		private static Button btnRenameFile = new Button("//*[text()='Rename']", LocatorType.XPATH);	
		private static Element txtForEmptyFolder = new Element("//*[text()='This folder is empty']",LocatorType.XPATH);
		
	//Objects declaration
		public static  Properties propData;
		public static LoadProperties properties;
		public static LoginPage homepg;
		public static LandingPage landingpg;
		public static  VerifyFunctions verifyFunctions;
	
	//Generate random number	
		static String generatedString = RandomStringUtils.random(25, true, true);   
	
    static
	{
		try {
			 properties = new LoadProperties();
			 propData = properties.loadProperties("Data");
			 verifyFunctions = new VerifyFunctions();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/**
 * Landing Page
 * @return null
 * @throws Exception 
 */    
public LandingPage(WebDriver driver)
{
	try {
		this.driver=driver;
	} 
		catch (Exception e) {
			e.printStackTrace();
			verifyFunctions.verify(false, true, "Failed in LandingPage function due this exception:         "+e.getMessage() );
		}
}

/**
 * selectFolderOrFile
 * @param strName
 * @return null
 * @throws Exception 
 */ 
public void selectFolderOrFile(String strName)
{
	try {
		verifyFunctions.syncWait();
		btnOptions.click();
	} catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in selectFolderOrFile function due this exception:         "+e.getMessage() );
	}
}

/**
 * addNewFolder
 * @param null
 * @return null
 * @throws Exception 
 */
public void addNewFolder()
{
try {
	btnFiles.isDisplayed();
	btnFiles.click();
	btnMyFiles.click();	
	verifyFunctions.syncWait();
	btnCreateNewFolder.click();	
	Actions action = new Actions(driver);
	action.sendKeys(generatedString).build().perform();
	verifyFunctions.syncWait();
	action.sendKeys(Keys.TAB);
	verifyFunctions.syncWaitExtend();
	verifyFileOrFolderExist(generatedString,true);
	btnMyFiles.click();	
}
catch (Exception e) {
	e.printStackTrace();
	verifyFunctions.verify(false, true, "Failed in selectFolderOrFile function due this exception:         "+e.getMessage() );
}
}

/**
 * uploadFile
 * @param null
 * @return null
 * @throws Exception 
 */
public void uploadFile() 
{
	try {
		System.out.println("In file upload");
		btnUpload.click();
		verifyFunctions.syncWait();
		btnFileForUpload.isEnabled();
		verifyFunctions.verify(btnFileForUpload.isEnabled(), true, "File upload button is enabled");
		btnFileForUpload.click();	
		AutoItFunctions.uploadFile();
/*		if(liUploadTo.isDisplayed())
		{
			liUploadTo.click();
			System.out.println(btnUploadTo.isDisplayed());
			btnUploadTo.click();
			System.out.println(btnUploadTo.isDisplayed());
		}*/
		verifyFunctions.syncWaitExtend();
		verifyFileOrFolderExist(propData.getProperty("fileName"),true);	}
	catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in uploadFile function due this exception:         "+e.getMessage() );
	}

}

/**
 * deleteFile
 * @param null
 * @return null
 * @throws Exception 
 */
public void deleteFile() 
{
	try {
		
		verifyFunctions.syncWait();
		System.out.println("In file upload");
		btnOptions.click();
		btnDelete.click();
		btnDeleteYesPopUp.click();
		verifyFunctions.syncWait();	
		verifyFunctions.verify(txtForEmptyFolder.isDisplayed(), true, "File deleted successfully");
		}
	catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in deleteFile function due this exception:         "+e.getMessage() );
	}

}

/**
 * deleteFolder
 * @param null
 * @return null
 * @throws Exception 
 */
public void deleteFolder() 
{
	try {		
		verifyFunctions.syncWait();
		btnOptions.click();
		btnDelete.click();
		btnDeleteYesPopUp.click();
		verifyFunctions.syncWait();	
		verifyFunctions.verify(txtForEmptyFolder.isDisplayed(), true, "Folder deleted successfully");	
		}
	catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in deleteFolder function due this exception:         "+e.getMessage() );
	}

}
/**
 * verifyAndClickOnMyFile
 * @param null
 * @return null
 * @throws Exception 
 */
public void verifyAndClickOnMyFile()
{
	try
	{
	verifyFunctions.verify(btnFiles.isDisplayed(),true, "Files button present on page" );
	btnFiles.click();
	}
	catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in verifyAndClickOnMyFile function due this exception:         "+e.getMessage() );
	}
	
}

/**
 * verifyFileOrFolderExist
 * @param null
 * @return null
 * @throws Exception 
 */
public void verifyFileOrFolderExist(String strName, boolean bIsExist )
{
	try {		
		if(bIsExist)
			{
			WebElement fileElement =  driver.findElement(By.xpath("//tr[@data-filename='" +strName+"']//input"));
			verifyFunctions.verify(fileElement.isDisplayed(),bIsExist, "File or Folder exist in the list" );
			}
		else
		{
			WebElement fileElement =  driver.findElement(By.xpath("//tr[@data-filename='" +strName+"']//input"));
			verifyFunctions.verify(!(fileElement.isDisplayed()),bIsExist, "File or Folder not exist in the list" );
			}
	} catch (Exception e) {
		e.printStackTrace();
		verifyFunctions.verify(false, true, "Failed in verifyFileOrFolderExist function due this exception:         "+e.getMessage() );

	}
}


public void renameFile()
{
try {
	verifyFunctions.syncWait();
	btnRenameFile.click();	
	Actions action = new Actions(driver);
	action.sendKeys(propData.getProperty("renameFileName")).build().perform();
	verifyFunctions.syncWait();
	//action.sendKeys(Keys.ENTER);
	action.sendKeys(Keys.TAB);	
	verifyFunctions.syncWaitExtend();
	verifyFileOrFolderExist(propData.getProperty("renameFileName")+".txt",true);
	btnMyFiles.click();	
	verifyFunctions.syncWait();
	verifyFunctions.syncWait();
}
catch (Exception e) {
	e.printStackTrace();
	verifyFunctions.verify(false, true, "Failed in renameFile function due this exception:         "+e.getMessage() );

}
}
}