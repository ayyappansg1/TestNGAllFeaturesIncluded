package listener;

import org.testng.ITestListener;

import stepdefinitions.Hooks;

public class Listener implements ITestListener{
	
	public void onTestFailure() {
	Hooks.test.fail("Test Failed  Bro");	
	}

}
