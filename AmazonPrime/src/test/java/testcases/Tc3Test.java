package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(demo.Listenerclass.class)
public class Tc3Test {

	@Test
	public void m3()
	{
		Reporter.log("Running Tc3");
	}
}
