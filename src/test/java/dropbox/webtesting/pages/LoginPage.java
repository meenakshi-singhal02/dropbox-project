package dropbox.webtesting.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dropbox.webtesting.elements.Button;
import dropbox.webtesting.elements.Element;
import dropbox.webtesting.elements.Link;
import dropbox.webtesting.elements.TextField;
import dropbox.webtesting.elements.Element.LocatorType;
import dropbox.webtesting.reporting.ReportUtil;
import dropbox.webtesting.utils.DateFunctions;
import dropbox.webtesting.utils.LoadProperties;
import dropbox.webtesting.utils.VerifyFunctions;

public class LoginPage {

	//Elements declaration
		static WebDriver driver;
		private static TextField txtEmailId = new TextField("login_email", LocatorType.NAME);
		private static TextField txtPassword = new TextField("login_password", LocatorType.NAME);
		private static Button btnSignIn = new Button("//button/div[text()='Sign in']", LocatorType.XPATH);
		private static Element eleSignOutImg = new Button("//img[@class='mc-avatar-image']", LocatorType.XPATH);
		private static Button btnSignOut = new Button("//a[text()='Sign out']", LocatorType.XPATH);

	//Object declaration
		public static VerifyFunctions verifyFunctions;
		public static DateFunctions dateFunctions;
		public static LandingPage landingPage;
		public static  Properties propData;
		public static LoadProperties properties;

	static
	{
		try {
			verifyFunctions = new VerifyFunctions();
			 dateFunctions = new DateFunctions();
			 landingPage = new LandingPage(driver);
			 properties = new LoadProperties();
			 propData = properties.loadProperties("Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/**
 * LoginPage
 * @param null
 * @return null
 * @throws Exception 
 */
public LoginPage(WebDriver driver)
{
	try {
		this.driver=driver;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * login
 * @param propData, bVerify
 * @return null
 * @throws Exception 
 */
public void login()
{
try {
	verifyFunctions.verify(txtEmailId.isDisplayed(), true, "Email Id text field displayed");
	txtEmailId.click();
	txtEmailId.clearandType(propData.getProperty("userEmailId"));
	verifyFunctions.verify(txtPassword.isDisplayed(), true, "Password text field displayed");
	txtPassword.click();
	txtPassword.clearandType(propData.getProperty("password"));
	verifyFunctions.syncWait();
	verifyFunctions.verify(btnSignIn.isDisplayed(), true, "Sign In Button displayed");
	btnSignIn.click();
	landingPage.verifyAndClickOnMyFile();
}
catch (Exception e) {
	e.printStackTrace();
	verifyFunctions.verify(false, true, "Failed in login function due this exception:         "+e.getMessage() );

}
}

/**
 * logOut
 * @param null
 * @return null
 * @throws Exception 
 */
public void logOut()
{
try {
	verifyFunctions.verify(eleSignOutImg.isDisplayed(), true, "SigOut is Present on Page" );	
	eleSignOutImg.click();
	btnSignOut.click();	
	verifyFunctions.verify(txtEmailId.isDisplayed(),true, "LogOut Successfully" );
}
catch (Exception e) {
	e.printStackTrace();
	verifyFunctions.verify(false, true, "Failed in logout function due this exception:         "+e.getMessage() );
}
}



}


