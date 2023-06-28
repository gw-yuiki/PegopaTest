package methodTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrderHistoryUpdateTest {

	private WebDriver driver;

	public OrderHistoryUpdateTest(WebDriver driver) {
		this.driver = driver;
	}

	public void update() throws InterruptedException{
		OrderHistoryUpdateTest orderhistoryupdatetest = new OrderHistoryUpdateTest(driver);
		orderhistoryupdatetest.update101();
		orderhistoryupdatetest.update102();
	}

	// 受注詳細画面に遷移する
	public void update101() throws InterruptedException {

		// 受注一覧画面に遷移
		Thread.sleep(500);
		driver.findElement(By.linkText("【受注一覧】")).click();

		// 詳細画面に遷移
		Thread.sleep(500);
		driver.findElement(By.linkText("詳細")).click();
	}

	// 入金状況、発送状況をセレクトボックスで変更できるか
	public void update102() throws InterruptedException {

		// 入金状況のセレクトボックスの値を変更
		WebElement selectDeposit = driver.findElement(By.name("deposit"));
		Select deposit = new Select(selectDeposit);

		// 入金状況を「入金済」に変更
		Thread.sleep(500);
		deposit.selectByValue("入金済");
		Thread.sleep(500);

		// 更新ボタンを押す
		driver.findElement(By.cssSelector("input[value='更新']")).click();

		// メールボックスを開く
		driver.get("https://webmail.xserver.ne.jp/");
		WebElement email = driver.findElement(By.name("_user"));
		email.sendKeys("system.project.team15@kanda-it-school-system.com");
		WebElement pass = driver.findElement(By.name("_pass"));
		pass.sendKeys("i1jkv4dR4Z8m0bA");
		driver.findElement(By.cssSelector("input[value='ログイン']")).click();
		Thread.sleep(3000);

		// 商品詳細画面に遷移
		driver.get("http://localhost:8080/pegopa/orderHistory");
		driver.findElement(By.linkText("詳細")).click();

		// 発送状況のセレクトボックスの値を変更
		WebElement selectShipping = driver.findElement(By.name("shipping"));
		Select shipping = new Select(selectShipping);

		// 発送状況を「発送済」に変更
		Thread.sleep(500);
		shipping.selectByValue("発送済");
		Thread.sleep(500);

		// 更新ボタンを押す
		driver.findElement(By.cssSelector("input[value='更新']")).click();

		// メールボックスを開く
		driver.get("https://webmail.xserver.ne.jp/");
		Thread.sleep(3000);

		// 商品詳細画面に遷移
		driver.get("http://localhost:8080/pegopa/orderHistory");

		driver.findElement(By.linkText("【メニュー】")).click();
	}
}
