package Listener_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retrylistener implements IRetryAnalyzer{

	int count=0;
	int limit=5;	
	@Override
	public boolean retry(ITestResult result) {
		if(count<limit) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
