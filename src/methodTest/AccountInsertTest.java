package methodTest;

import org.openqa.selenium.*;

import dao.AccountDAO;



public class AccountInsertTest {

	private WebDriver driver;

	public AccountInsertTest(WebDriver driver) {
		this.driver = driver;
	}

	// 会員登録機能をテストするメソッドを呼び出す
	public void Insert() throws InterruptedException {

		AccountInsertTest ait = new AccountInsertTest(driver);

		// ユーザーIDを未入力で登録ボタンを押下した際にアラートが出るか
		ait.insert202();
		// パスワードを未入力で登録ボタンを押下した際にアラートが出るか
		ait.insert203();
		// 氏名を未入力で登録ボタンを押下した際にアラートが出るか
		ait.insert204();
		// パスワード確認欄を未入力で登録ボタンを押下した際にアラートが出るか
		ait.insert205();
		// 住所未入力で登録ボタンを押下した際にアラートが出るか
		ait.insert206();

		// 正常に会員を登録できるか
		ait.insert101();
	}

	// 正常に会員を登録できるか
	public void insert101() throws InterruptedException {

		// 既存のユーザーID以外を指定
		boolean uniqueCheck;
		String InputEmail = "";
		int i = 1;
		while (true) {
			// ユーザーIDが重複していないかチェック
			InputEmail = "email" + i + "@gw.co.jp";
			uniqueCheck = AccountDAO.loginCheck(InputEmail);
			if (uniqueCheck == true) {
				break;
			}
			i++;
		}
		// ユーザーID欄を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(InputEmail);

		// 氏名欄を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テストユーザー");

		// パスワード欄を入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// パスワード確認欄を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所欄を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("東京都渋谷区");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// ログイン画面に戻る
		driver.findElement(By.linkText("【ログイン画面に戻る】")).click();
	}

	// ユーザーIDを未入力で登録ボタンを押下した際にアラートが出るか
	public void insert202() throws InterruptedException {

		// 新規会員登録画面に遷移
		driver.findElement(By.linkText("新規会員登録はこちら")).click();

		// ユーザーID未入力

		// 氏名欄を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テストユーザー");

		// パスワード欄を入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// パスワード確認欄を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所欄を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("東京都渋谷区");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した項目を全てクリア
		name.clear();
		pw.clear();
		pwCheck.clear();
		address.clear();
	}

	// パスワードを未入力で登録ボタンを押下した際にアラートが出るか
	public void insert203() throws InterruptedException {

		// 既存のユーザーID以外を指定
		boolean uniqueCheck;
		String InputEmail = "";
		int i = 1;
		while (true) {
			// ユーザーIDが重複していないかチェック
			InputEmail = "email" + i + "@gw.co.jp";
			uniqueCheck = AccountDAO.loginCheck(InputEmail);
			if (uniqueCheck == true) {
				break;
			}
			i++;
		}
		// ユーザーID欄を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(InputEmail);

		// 氏名欄を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テストユーザー");

		// パスワード欄未入力

		// パスワード確認欄を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所欄を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("東京都渋谷区");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();
		alert.accept();

		// 入力した項目を全てクリア
		email.clear();
		name.clear();
		pwCheck.clear();
		address.clear();
	}

	// 氏名を未入力で登録ボタンを押下した際にアラートが出るか
	public void insert204() throws InterruptedException {

		// 既存のユーザーID以外を指定
		boolean uniqueCheck;
		String InputEmail = "";
		int i = 1;
		while (true) {
			// ユーザーIDが重複していないかチェック
			InputEmail = "email" + i + "@gw.co.jp";
			uniqueCheck = AccountDAO.loginCheck(InputEmail);
			if (uniqueCheck == true) {
				break;
			}
			i++;
		}
		// ユーザーID欄を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(InputEmail);

		// 氏名欄未入力

		// パスワード欄を入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// パスワード確認欄を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所欄を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("東京都渋谷区");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した項目を全てクリア
		email.clear();
		pw.clear();
		pwCheck.clear();
		address.clear();
	}

	// パスワード確認欄を未入力で登録ボタンを押下した際にアラートが出るか
	public void insert205() throws InterruptedException {

		// 既存のユーザーID以外を指定
		boolean uniqueCheck;
		String InputEmail = "";
		int i = 1;
		while (true) {
			// ユーザーIDが重複していないかチェック
			InputEmail = "email" + i + "@gw.co.jp";
			uniqueCheck = AccountDAO.loginCheck(InputEmail);
			if (uniqueCheck == true) {
				break;
			}
			i++;
		}
		// ユーザーID欄を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(InputEmail);

		// 氏名欄を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テストユーザー");

		// パスワード欄を入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// パスワード確認欄未入力

		// 住所欄を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("東京都渋谷区");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した項目を全てクリア
		email.clear();
		name.clear();
		pw.clear();
		address.clear();
	}
	// 住所欄を未入力で登録ボタンを押下した際にアラートが出るか
	public void insert206() throws InterruptedException {

		// 既存のユーザーID以外を指定
		boolean uniqueCheck;
		String InputEmail = "";
		int i = 1;
		while (true) {
			// ユーザーIDが重複していないかチェック
			InputEmail = "email" + i + "@gw.co.jp";
			uniqueCheck = AccountDAO.loginCheck(InputEmail);
			if (uniqueCheck == true) {
				break;
			}
			i++;
		}
		// ユーザーID欄を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(InputEmail);

		// 氏名欄を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テストユーザー");

		// パスワード欄を入力
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys("abcde12345?");

		// パスワード確認欄を入力
		WebElement pwCheck = driver.findElement(By.name("pwCheck"));
		pwCheck.sendKeys("abcde12345?");

		// 住所欄を未入力

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した項目を全てクリア
		email.clear();
		name.clear();
		pw.clear();
		pwCheck.clear();
	}
}
