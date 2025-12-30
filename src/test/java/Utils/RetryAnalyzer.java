package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result){

        if(retryCount < maxRetryCount){
            retryCount++;

            System.out.println("Retrying failed test : "+ result.getName() +  " | Retry Count = "+ retryCount);

            return true;
        }
            return false;
    }

}
