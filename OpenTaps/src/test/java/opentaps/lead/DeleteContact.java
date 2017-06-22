package opentaps.lead;

import org.testng.annotations.Test;

public class DeleteContact extends OpentapsWrappers{
  @Test(groups={"Regression"},dependsOnGroups={"Sanity"})
  public void g() throws InterruptedException {
	  System.out.println("Delete lead executed");
	  Thread.sleep(5000);
  }
}
