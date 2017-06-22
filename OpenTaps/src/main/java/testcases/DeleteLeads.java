package testcases;

import wrappers.GenericWrapper;

public class DeleteLeads extends Opentaps {

	public static void main(String[] args) {
		/*not required to create object for generic wrappers class since it is extended in opentaps. we can extend opentaps to get
		 * generic wrappers properties*/
		 
		//GenericWrapper obj=new GenericWrapper();
		/*extending opentaps class to use the invoke app properties of generic wrappers with reusability of same date*/
		Opentaps obj=new Opentaps();
		obj.loginopentaps();
		/*syntax with extending generic wrappers class directly*/
		//obj.invokeApp("chrome", "http://192.168.1.29/opentaps/control/main");
		//obj.enterById("username", "DemoSalesManager");
		//obj.enterById("password", "crmsfa");
		//obj.clickByClassName("decorativeSubmit");
		obj.clickByLink("CRM/SFA");
		obj.clickByLink("Leads");
		obj.clickByLink("Find Leads");
		obj.clickByXpath("//span[contains(text(),'Phone')]");
		obj.enterByName("phoneCountryCode", "1");
		obj.enterByName("phoneAreaCode", "91");
		obj.enterByName("phoneNumber", "%9%");
		obj.clickByXpath("//button[contains(text(),'Find Leads')]");
		String str=	obj.getTextByXpath("(//a[@class='linktext'])[4]");
		obj.getTextByXpath("(//a[contains(text(),"+str+")])[1]");
		obj.clickByLink(str);
		obj.clickByClassName("subMenuButtonDangerous");
		obj.clickByLink("Find Leads");
		obj.enterByName("id", str);
		obj.clickByXpath("//button[contains(text(),'Find Leads')]");
		obj.verifyTextByXpath("//div[contains(text(),'No records to display')]","No records to display" );
	}

}
