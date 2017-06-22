package opentaps.lead;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class OpentapsWrappers {
  //@Test
  //public void f() {
  //}
	//@Parameters({"url","username","password"})
	
	@BeforeMethod
	public void beforeMethod(){
  //public void beforeMethod(String url,String user, String pass) {
		
	//System.out.println("url is"+url);
	//System.out.println("username is"+user);
	//System.out.println("password is"+pass);
	  System.out.println("Before method executed");
	  System.out.println("Before common method executed");
  }
    @AfterMethod
  //@AfterMethod(groups={"common"})
  public void afterMethod() {
	  System.out.println("After method executed");
	  //System.out.println("After common method executed");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class Executed");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class executed");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before test executed");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test executed");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite executed");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite executed");
  }

}
