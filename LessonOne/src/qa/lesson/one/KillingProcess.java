package qa.lesson.one;

import java.io.IOException;

public class KillingProcess {

	public  void main(String[] args) {
		boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		try {
		    if (isDebug)
		        Runtime.getRuntime().exec("taskkill  /F /IM geckodriver.exe");
		        Runtime.getRuntime().exec("taskkill  /F /IM conhost.exe");
		        Runtime.getRuntime().exec("taskkill  /F /IM chromedriver.exe");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
