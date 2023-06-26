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
		accountUpdateTest.accountUpdate101();
		accountUpdateTest.accountUpdate102();
		accountUpdateTest.accountUpdate103();
		accountUpdateTest.accountUpdate104();
		accountUpdateTest.accountUpdate105();
		accountUpdateTest.accountUpdate106();
		accountUpdateTest.accountUpdate100();
	}

	// 正常にユーザー情報を変更できるか
	public void accountUpdate100() {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pw");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='変更完了']")).submit();

		// メニューボタンをクリック
		driver.findElement(By.linkText("【メニュー画面に戻る】")).click();
	}

	// 氏名を未入力で変更完了ボタン押下
	public void accountUpdate101() throws InterruptedException {

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pw");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
		// メールアドレスを削除
		driver.findElement(By.name("email")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
	}

	// パスワードを未入力で変更完了ボタン押下
	public void accountUpdate102() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pw");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

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
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
		// メールアドレスを削除
		driver.findElement(By.name("email")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
	}

	// パスワード(確認用)を未入力で変更完了ボタン押下
	public void accountUpdate103() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

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
		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// メールアドレスを削除
		driver.findElement(By.name("email")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();
	}

	// 住所を未入力で変更完了ボタン押下
	public void accountUpdate104() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pw");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

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
		// メールアドレスを削除
		driver.findElement(By.name("email")).clear();
	}

	// メールアドレスを未入力で変更完了ボタン押下
	public void accountUpdate105() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pw");

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
		// 入力したパスワードを削除
		driver.findElement(By.name("pw")).clear();
		// パスワード(確認用)を削除
		driver.findElement(By.name("pwCheck")).clear();
		// 住所を削除
		driver.findElement(By.name("address")).clear();

	}

	// パスワードとパスワード(確認用)が間違っている場合
	public void accountUpdate106() throws InterruptedException {

		//氏名を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ichiro");

		//パスワードを入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("pw");

		//パスワード(確認用)を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("pww");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//メールアドレスを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ichiro@japan.co.jp");

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
		// 住所を削除
		driver.findElement(By.name("address")).clear();
		// メールアドレスを削除
		driver.findElement(By.name("email")).clear();

	}

}
