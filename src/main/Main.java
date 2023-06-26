package main;

import org.openqa.selenium.*;


import org.openqa.selenium.chrome.ChromeDriver;

import methodTest.LoginTest;
import methodTest.AccountInsertTest;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ドライバ指定
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// 開きたいサイトのURLを取得
		driver.get("http://localhost:8080/pegopa/view/login.jsp");

		AccountInsertTest ait = new AccountInsertTest(driver);
		LoginTest logintest = new LoginTest(driver);

		// 新規会員登録
		Thread.sleep(500);
		ait.Insert();

		// ログイン
		Thread.sleep(500);
		logintest.Login();



		//driver.quit();
	}

}
