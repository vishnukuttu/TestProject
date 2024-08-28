package basicTestNG;
//Selenium not have report generation, Annotations can be used here, Different methods can be run

import org.testng.annotations.DataProvider;
//Unit framework-
import org.testng.annotations.Test;
//Run according to alphabetical order
public class BasicAnnotation {
	@DataProvider
	  public Object[][] data() { // 1 test case , if test data  are many multiple data case
	    return new Object[][] {
	      { 1, "a" },
	      { 2, "b" },
	      {3,"c"}
	    };
	   
	  }
	
	@Test
	  public void testcase10() 
	  {
		System.out.println("testcase10"); 
	  }
  @Test
  public void testcase01() 
  {
	System.out.println("testcase01"); 
  }
  
  @Test
  public void testcase02() 
  {
	System.out.println("testcase02"); 
  }
  @Test
  public void testcase03() 
  {
	System.out.println("testcase03"); 
  }
  @Test
  public void testcase04() 
  {
	System.out.println("testcase04"); 
  }
  @Test
  public void testcase05() 
  {
	System.out.println("testcase05"); 
  }
  @Test
  public void testcase06() 
  {
	System.out.println("testcase06"); 
  }
  
}
