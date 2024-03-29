package TestSmoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import ehub.com.constants.AppConstants;
import ehub.com.pagesSmoke.S05mimPage;
import ehub.com.utils.ExcelUtil;

public class S05mimPageTest extends BaseTest{
	
	S05mimPage S05page;
	ExcelUtil excUtil = new ExcelUtil(System.getProperty("user.dir") + AppConstants.pathofExcelDataAsPerEnv);

	@BeforeTest
	public void setupBrowser() {
		setup();
		S05page = new S05mimPage(driver);
	}

	@Test(priority = 1, enabled = true)
	public void login() {
		S05page.login();
	}

	@Test(priority = 2, enabled = true)
	public void searchReportAndOpen() {
		String expectedReport="mim_policy_data";
		String actualCreatedPolicy=S05page.searchReportAndOpen(expectedReport);		
		Assert.assertEquals(actualCreatedPolicy, expectedReport);
	}
	
	@Test(priority = 3, enabled = true)
	public void mimReport() {
		S05page.mimReport();
	}
	
	@Test(priority = 4, enabled = true)
	public void mimResult() {
		S05page.mimResult();
	}

}
