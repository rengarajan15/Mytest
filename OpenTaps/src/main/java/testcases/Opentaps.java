package testcases;

import wrappers.GenericWrapper;

public class Opentaps extends GenericWrapper {

	 
		public void loginopentaps()
		{
		
		invokeApp("chrome", "http://192.168.1.29/opentaps/control/main");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		
		}
		
		}

	


