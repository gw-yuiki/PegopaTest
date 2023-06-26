package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import methodTest.AccountUpdateTest;
import methodTest.LoginTest;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ドライバ指定
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// 開きたいサイトのURLを取得
		driver.get("http://localhost:8080/pegopa/view/login.jsp");

		LoginTest logintest = new LoginTest(driver);

		// ログイン
		Thread.sleep(500);
		logintest.Login();

		AccountUpdateTest accountUpdateTest = new AccountUpdateTest(driver);

		//ユーザー情報変更
		Thread.sleep(500);
		accountUpdateTest.AccountUpdate();

		//driver.quit();
	}

}
