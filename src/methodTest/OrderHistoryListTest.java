package methodTest;

import org.openqa.selenium.*;

public class OrderHistoryListTest {

	private WebDriver driver;

	public OrderHistoryListTest(WebDriver driver) {
		this.driver = driver;
	}

	public void list() throws InterruptedException{
		OrderHistoryListTest orderhistorylisttest = new OrderHistoryListTest(driver);
		orderhistorylisttest.list101();
	}

	// 商品詳細ボタンをクリック後詳細画面に遷移するか
	public void list101() throws InterruptedException {

		// 受注一覧画面に遷移
		Thread.sleep(500);
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
}
