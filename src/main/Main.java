package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import methodTest.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ドライバ指定
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// 開きたいサイトのURLを取得
		driver.get("http://localhost:8080/pegopa/view/login.jsp");

		UniformInsertTest uniforminserttest = new UniformInsertTest(driver);
		uniforminserttest.insert();

//		LoginTest logintest = new LoginTest(driver);
//		AccountInsertTest accountInsertTest = new AccountInsertTest(driver);
//		AccountUpdateTest accountUpdateTest = new AccountUpdateTest(driver);

		// 新規会員登録
//		Thread.sleep(500);
//		accountInsertTest.Insert();
//
//		// ログイン
//		Thread.sleep(500);
//		logintest.Login();
//
//		//ユーザー情報変更
//		Thread.sleep(500);
//		accountUpdateTest.AccountUpdate();

		//driver.quit();
	}

}
