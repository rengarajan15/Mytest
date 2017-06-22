package testcases;

import wrappers.GenericWrapper;

public class CreateLeads {

	public static void main(String[] args) {
		GenericWrapper gw = new GenericWrapper();
		gw.invokeApp("chrome", "http://192.168.1.14/opentaps");
		gw.enterById("username", "DemoSalesManager");
		gw.enterById("password", "crmsfa");
		gw.clickByClassName("decorativeSubmit");
		gw.clickByLink("CRM/SFA");
		gw.clickByLink("Create Lead");
		gw.enterById("createLeadForm_companyName", "CTS");
		gw.enterById("createLeadForm_firstName", "Sankar");
		gw.enterById("createLeadForm_lastName", "P");
		gw.selectVisibileTextById("createLeadForm_dataSourceId", "Employee");
		gw.selectVisibileTextById("createLeadForm_marketingCampaignId", "Demo Marketing Campaign");
		gw.enterById("createLeadForm_primaryPhoneNumber", "9840371567");
		gw.enterById("createLeadForm_primaryEmail", "sankarn86@gmail.com");
		gw.clickByName("submitButton");
		//gw.getTextById1("viewLead_companyName_sp");
		gw.quitBrowser();

	}

}
