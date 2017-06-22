package opentaps.lead;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditContact extends OpentapsWrappers{
  @Test(dataProvider="source")
  public void k(String user,String pass) {
	  System.out.println("username is"+user);
	  System.out.println("passwors is"+pass);
	  //System.out.println("Edit Lead created");
	    
  }
  @DataProvider(name="source")
  public Object[][] data(){
	  Object[][] val=new Object[2][2];
	  val[0][0]="kiran";val[0][1]="mahesh";
	  val[1][0]="anand";val[1][1]="babu";
	  return val;  
  }
}
