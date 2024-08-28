package basicTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println(n + " "+s);
  }

  @DataProvider
  public Object[][] dp() { // 1 test case , if test data  are many multiple data case
    return new Object[][] {
      { 1, "a" },
      { 2, "b" },
      {3,"c"}
    };  
  }
  @Test(dataProvider = "data", dataProviderClass= BasicAnnotation.class)
  public void l(Integer n, String s) {
	  System.out.println(n + " "+s);
  }
}
