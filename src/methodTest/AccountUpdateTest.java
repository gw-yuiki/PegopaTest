package methodTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountUpdateTest {

	private WebDriver driver;

	public AccountUpdateTest(WebDriver driver) {
		this.driver = driver;
	}

	public void AccountUpdate() throws InterruptedException {
		AccountUpdateTest accountUpdateTest = new AccountUpdateTest(driver);
		accountUpdateTest.accountUpdate102();
		accountUpdateTest.accountUpdate103();
		accountUpdateTest.accountUpdate104();
		accountUpdateTest.accountUpdate105();
		accountUpdateTest.accountUpdate106();
		accountUpdateTest.accountUpdate101();
	}

	// 正常にユーザー情報を変更できるか
	public void accountUpdate101() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("変更後テストユーザー");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='変更完了']")).submit();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// メニューボタンをクリック
		driver.findElement(By.linkText("【ログイン画面に戻る】")).click();

	}

	// 氏名を未入力で変更完了ボタン押下
	public void accountUpdate102() throws InterruptedException {

		// 会員情報変更ボタンクリック
		driver.findElement(By.linkText("【会員情報変更】")).click();

		// 入力されている氏名を削除
		driver.findElement(By.name("name")).clear();

		// 住所を削除
		driver.findElement(By.name("address")).clear();

		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所を削除
		driver.findElement(By.name("address")).clear();

		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
	}

	// 住所を未入力で変更完了ボタン押下
	public void accountUpdate103() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した氏名を削除
		driver.findElement(By.name("name")).clear();
		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
	}

	// パスワードを未入力で変更完了ボタン押下
	public void accountUpdate104() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した氏名を削除
		driver.findElement(By.name("name")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
	}

	// パスワード(確認用)を未入力で変更完了ボタン押下
	public void accountUpdate105() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した氏名を削除
		driver.findElement(By.name("name")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
	}

	// パスワードとパスワード(確認用)が間違っている場合
	public void accountUpdate106() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde123456?");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した氏名を削除
		driver.findElement(By.name("name")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();

	}
}
