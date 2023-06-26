package methodTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

	private WebDriver driver;

	public LoginTest(WebDriver driver) {
		this.driver = driver;
	}

	public void Login() throws InterruptedException {
		LoginTest logintest = new LoginTest(driver);
		logintest.login202();
		logintest.login203();
		logintest.login101();
	}

	// 正常にログインできるか
	public void login101() throws InterruptedException {

		// ユーザーID欄にemailと入力
		WebElement user = driver.findElement(By.name("name"));
		user.sendKeys("email@gw.co.jp");

		// パスワード欄にpwと入力
		WebElement password = driver.findElement(By.name("pw"));
		password.sendKeys("pw");

		// ログインボタンを押す
		driver.findElement(By.cssSelector("input[value='ログイン']")).click();

		// 処理終了
		driver.findElement(By.linkText("【会員情報変更】")).click();
	}

	// ユーザーID欄を未入力でログインボタン押下
	public void login202() throws InterruptedException {

		// パスワード欄にpwと入力
		WebElement password = driver.findElement(By.name("pw"));
		password.sendKeys("pw");

		// ログインボタンを押す
		driver.findElement(By.cssSelector("input[value='ログイン']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力したpwを削除
		driver.findElement(By.name("pw")).clear();
	}

	// パスワード欄を未入力でログインボタン押下
	public void login203() throws InterruptedException {

		// ユーザーID欄にemailと入力
		WebElement user = driver.findElement(By.name("name"));
		user.sendKeys("email@gw.co.jp");

		// ログインボタンを押す
		driver.findElement(By.cssSelector("input[value='ログイン']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力したemailを削除
		driver.findElement(By.name("name")).clear();
	}

}
