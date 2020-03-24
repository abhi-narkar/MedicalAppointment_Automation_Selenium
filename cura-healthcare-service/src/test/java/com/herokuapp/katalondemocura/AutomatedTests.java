package com.herokuapp.katalondemocura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomatedTests {

	@Test
	public void loginTest() {
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// sleep for 3 seconds
		sleep(3000);

		// open test page
		String url = "https://katalon-demo-cura.herokuapp.com/";
		driver.get(url);

		// maximize window
		driver.manage().window().maximize();

		// click on make appointment
		WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
		makeAppointmentButton.click();

		sleep(2000);

		// enter username
		WebElement username = driver.findElement(By.id("txt-username"));
		username.sendKeys("John Doe");

		// enter password
		WebElement password = driver.findElement(By.id("txt-password"));
		password.sendKeys("ThisIsNotAPassword");

		sleep(2000);

		// click login button
		WebElement logInButton = driver.findElement(By.id("btn-login"));
		logInButton.click();

		// Select Hong Kong option
		Select facilityInput = new Select(driver.findElement(By.id("combo_facility")));
		facilityInput.selectByValue("Hongkong CURA Healthcare Center");
		sleep(2000);

		// Check for Readmission
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		sleep(2000);

		// Health care program
		driver.findElement(By.id("radio_program_medicaid")).click();
		sleep(2000);

		// Select Visit date
		driver.findElement(By.id("txt_visit_date")).click();

		// Select The Date
		// Found xpath using Ranorex selocity
		driver.findElement(
				By.xpath("//body/div/div[@class='datepicker-days']/table[@class='table-condensed']/tbody/tr[5]/td[6]"))
				.click();
		sleep(3000);

		// Add comment
		driver.findElement(By.id("txt_comment")).sendKeys("Comment");
		sleep(3000);

		// Book Appointment
		driver.findElement(By.id("btn-book-appointment")).click();
		sleep(3000);

		// close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-genereated catch block
			e.printStackTrace();
		}
	}
}
