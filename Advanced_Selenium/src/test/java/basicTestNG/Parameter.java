package basicTestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Parameter {
  @Test
  @Parameters({"p1","p2"})
  public void testcase01(int a,String s) {
	  System.out.println(a);
	  System.out.println(s);
	  
  }
}
