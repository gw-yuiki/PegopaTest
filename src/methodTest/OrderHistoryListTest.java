package methodTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryListTest {

	private WebDriver driver;

	public OrderHistoryListTest(WebDriver driver) {
		this.driver = driver;
	}

	public void adminList() throws InterruptedException {
		OrderHistoryListTest orderhistorylisttest = new OrderHistoryListTest(driver);
		orderhistorylisttest.list101();
	}

	public void userList() throws InterruptedException {
		OrderHistoryListTest orderhistorylisttest = new OrderHistoryListTest(driver);
		orderhistorylisttest.list101();
	}

	// 商品詳細ボタンをクリック後詳細画面に遷移するか(管理者)
	public void list101() throws InterruptedException {

		// 受注一覧画面に遷移
		Thread.sleep(500);
		driver.findElement(By.linkText("【メニュー】")).click();
		driver.findElement(By.linkText("【受注一覧】")).click();

		// 詳細画面に遷移
		Thread.sleep(500);
		driver.findElement(By.linkText("詳細")).click();

		// 受注一覧画面に戻る
		Thread.sleep(500);
		driver.findElement(By.linkText("【受注一覧】")).click();

		// メニューに戻る
		Thread.sleep(500);
		driver.findElement(By.linkText("【メニュー】")).click();
	}

	// 商品詳細ボタンをクリック後詳細画面に遷移するか(ユーザー)
	public void list102() throws InterruptedException {

		// 受注一覧画面に遷移
		Thread.sleep(500);
		driver.findElement(By.linkText("【注文一覧】")).click();

		// メニューに戻る
		Thread.sleep(500);
		driver.findElement(By.linkText("【メニュー】")).click();
	}

}
