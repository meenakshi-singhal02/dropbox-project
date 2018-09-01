package dropbox.webtesting.testcases;

import java.util.Properties;
import org.testng.annotations.Test;
import dropbox.webtesting.pages.LandingPage;
import dropbox.webtesting.pages.LoginPage;
import dropbox.webtesting.setup.BaseTest;
import dropbox.webtesting.utils.LoadProperties;


public class DropBoxTestCases extends BaseTest {
	
	public static  Properties propData;
	public static LoadProperties properties;
	public static LoginPage homepg;
	public static LandingPage landingpg;
	

	/**
	 * verify successfully login 
	 * 
	 * @return null
	 */
	@Test(enabled=true)
	public void verifySuccessfullyLogin()
	{	
		homepg = new LoginPage(driver);
		homepg.login();
	}
	
	/**
	 * verify Successfully Creates Folder And Deleted 
	 * 
	 * @return null
	 */
	@Test(enabled=true)
	public void verifySuccessfullyCreateFolderAndDeleted()
	{		
		homepg = new LoginPage(driver);
		landingpg = new LandingPage(driver);
		homepg.login();
		landingpg.addNewFolder();
		landingpg.deleteFolder();
		homepg.logOut();
	}
	
	/**
	 * verify Successfully Create File Uploaded, Renamed And Deleted
	 * 
	 * @return null
	 */
	@Test(enabled=true)
	public void verifySuccessfullyFileUploadedRenamedAndDeleted()
	{	 
		homepg = new LoginPage(driver);
		landingpg = new LandingPage(driver);
		homepg.login();
		landingpg.uploadFile();
		landingpg.renameFile();
		landingpg.deleteFile();
		homepg.logOut();
	}
	
	/**
	 * verify Successfully logout 
	 * 
	 * @return null
	 */
	@Test(enabled=true)
	public void verifySuccessfullylogout()
	{	
		homepg = new LoginPage(driver);
		homepg.login();
		homepg.logOut();
	}
	
	

}