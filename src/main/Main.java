package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import methodTest.AccountUpdateTest;
import methodTest.LoginTest;
import methodTest.AccountInsertTest;
import methodTest.UniformListTest;
import methodTest.UniformInsertTest;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ドライバ指定
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// 開きたいサイトのURLを取得
		driver.get("http://localhost:8080/pegopa/view/login.jsp");

		LoginTest logintest = new LoginTest(driver);
		AccountInsertTest accountInsertTest = new AccountInsertTest(driver);
		AccountUpdateTest accountUpdateTest = new AccountUpdateTest(driver);
		UniformListTest uniformListTest = new UniformListTest(driver);
		UniformInsertTest uniforminserttest = new UniformInsertTest(driver);
		uniforminserttest.insert();

		// 新規会員登録
//		Thread.sleep(500);
//		accountInsertTest.Insert();


		// ログイン
		Thread.sleep(500);
		logintest.Login();

		//ユーザー情報変更
		Thread.sleep(500);
		accountUpdateTest.AccountUpdate();

		// 商品一覧
		Thread.sleep(500);
		uniformListTest.UniformList();

		// 管理者ログイン
		Thread.sleep(500);
		logintest.adminLogin();

		driver.quit();
	}
}
