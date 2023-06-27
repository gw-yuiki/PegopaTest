package methodTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {

	private WebDriver driver;

	public MenuTest(WebDriver driver) {
		this.driver = driver;
	}

	//ユーザーメニュー
	public void userMenu() throws InterruptedException {
		MenuTest menuTest = new MenuTest(driver);
		menuTest.MenuTest101(); //商品一覧
		menuTest.MenuTest106(); //注文一覧
		menuTest.MenuTest105(); //会員情報変更
	}

	//管理者メニュー
	public void adminMenu() throws InterruptedException {
		MenuTest menuTest = new MenuTest(driver);
		menuTest.MenuTest101(); //商品一覧
		menuTest.MenuTest103(); //受注一覧
		menuTest.MenuTest102(); //商品登録
	}

	//商品一覧画面に遷移(共通)
	public void MenuTest101() throws InterruptedException {
		driver.findElement(By.linkText("【商品一覧】")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("【メニュー】")).click();
		Thread.sleep(1000);
	}

	//商品登録画面に遷移(管理者)
	public void MenuTest102() throws InterruptedException {
		driver.findElement(By.linkText("【商品登録】")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("【メニュー】")).click();
		Thread.sleep(1000);
	}

	//受注一覧画面に遷移(管理者)
	public void MenuTest103() throws InterruptedException {
		driver.findElement(By.linkText("【受注一覧】")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("【メニュー】")).click();
		Thread.sleep(1000);
	}

	//会員情報変更画面に遷移(ユーザー)
	public void MenuTest105() throws InterruptedException {
		driver.findElement(By.linkText("【会員情報変更】")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("【メニュー】")).click();
		Thread.sleep(1000);
	}

	//注文一覧画面に遷移(ユーザー)
	public void MenuTest106() throws InterruptedException {
		driver.findElement(By.linkText("【注文一覧】")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("【メニュー】")).click();
		Thread.sleep(1000);
	}

}
