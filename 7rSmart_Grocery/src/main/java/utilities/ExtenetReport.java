package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtenetReport implements ITestListener {
	ExtentSparkReporter sparkReporter;// report configure
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String strDate = formatter.format(date);

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");

		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

		reports.setSystemInfo("Project", "7rsmart_Supermarket");
		reports.setSystemInfo("PC Name", "vishn");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Test Done By", "Vishnu Manoj K");
		sparkReporter.config().setDocumentTitle("7rsmart_Supermarket Report");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test failed");
			String failureReason = result.getThrowable().getMessage();
			test.log(Status.FAIL, "Failure Reason: " + failureReason);
			test.fail(result.getThrowable());

		}
	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));
		if (result.getStatus() == ITestResult.SKIP) {
			test.fail("Test skipped");
			String skipReason = result.getThrowable().getMessage();
			test.log(Status.SKIP, "skip Reason: " + skipReason);
			test.fail(result.getThrowable());

		}
	}

	public void onStart(ITestContext context) {
		configureReport();
		File testOutputFolder = new File("target/testoutput");
		if (testOutputFolder.exists()) {
			deleteFolder(testOutputFolder);
		}
	}

	private void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					file.delete();
				}
			}
		}
		folder.delete();
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
