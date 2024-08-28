package basicTestNG;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test
	  public void testcase10() 
	  {
		System.out.println("testcase10"); 
	  }
@Test(priority=1,enabled=true)
public void testcase01() 
{
	System.out.println("testcase01"); 
}

@Test(groups="Welcome to smoke test")
public void testcase02() 
{
	System.out.println("testcase02"); 
}
@Test(priority=2)
public void testcase03() 
{
	System.out.println("testcase03"); 
}
@Test(enabled=false)//not work
public void testcase04() 
{
	System.out.println("testcase04"); 
}
@Test(priority=-1)
public void testcase05() 
{
	System.out.println("testcase05"); 
}
@Test(groups="Welcome to smoke test")
public void testcase06() 
{
	System.out.println("testcase06"); 
}
}
