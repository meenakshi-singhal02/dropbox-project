package dropbox.webtesting.utils;

import dropbox.webtesting.setup.BaseTest;

public class AutoItFunctions {

	
	public static void uploadFile()
	{
		try
		{
			String sDriverName = BaseTest.driverName;
			switch(sDriverName)
			 {
				case "FIREFOX": 
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoItScript\\UploadFileFirefox.exe");
				break;
				case "CHROME": 
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoItScript\\UploadFileChrome.exe");
				break;
				case "IE": 
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoItScript\\UploadFileIE.exe");
				break;
				default: 
					System.out.println("Pass valid browser");
					break;		
			 }
		}
		catch(Exception e)
		{
			
		}
	}
}
