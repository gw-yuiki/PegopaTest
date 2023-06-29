package methodTest;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bean.Account;
import bean.Uniform;
import dao.AccountDAO;
import dao.UniformDAO;

public class OrderBuyTest {

	private WebDriver driver;

	UniformDAO uniformDao = new UniformDAO();
	ArrayList<Uniform> list = uniformDao.selectAll();

    int id = list.get(0).getId();

	public OrderBuyTest(WebDriver driver) {
		this.driver = driver;
	}

	//一覧機能をテストするメソッドを呼び出す
	public void OrderBuy() throws InterruptedException {
		OrderBuyTest orderBuytest = new OrderBuyTest(driver);

		// 正常動作確認
		orderBuytest.list201();
		orderBuytest.list202();
		orderBuytest.list203();
		orderBuytest.list204();

		// DB接続エラーのテストケースがありますが、今回はやりません
	}

	//一覧機能をテストするメソッドを呼び出す
	public void OrderBuyNormal() throws InterruptedException {
		OrderBuyTest orderBuytest = new OrderBuyTest(driver);

		// 正常動作確認
		orderBuytest.list101();
		orderBuytest.list102();

		// DB接続エラーのテストケースがありますが、今回はやりません
	}

	// 会員購入処理が行われるか
	public void list101() throws InterruptedException {

		// No.101 商品一覧画面まで遷移する
		try {
			driver.findElement(By.linkText("【商品一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		// No.102 既に登録されているISBNを入力
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);
		driver.findElement(By.cssSelector("input[value='購入']")).click();

		//注文内容確認画面
		driver.findElement(By.cssSelector("input[value='確認して購入']")).click();

		// 正常処理終了
		//注文完了画面
		driver.findElement(By.linkText("戻る")).click();

	}

	// 非会員購入処理が行われるか
	public void list102() throws InterruptedException {

		// No.101 商品一覧画面まで遷移する
		try {
			driver.findElement(By.linkText("【ログアウト】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		// No.102 既に登録されているISBNを入力
		driver.findElement(By.linkText("会員登録をせずに購入する")).click();
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);

		//非会員のため情報入力
		//氏名を入力
		WebElement name = driver.findElement(By.name("user_name"));
		name.sendKeys("非会員ユーザー");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("沖縄県");

		// 住所を入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("system.project.team15@kanda-it-school-system.com");

		//セレクトボックス
		WebElement quantity = driver.findElement(By.name("quantity"));
		Select select = new Select(quantity);
		select.selectByValue("2");

		// 住所を入力
		WebElement content = driver.findElement(By.name("content"));
		content.sendKeys("よろしくお願いいたします。");

		//購入ボタンクリック
		driver.findElement(By.cssSelector("input[value='購入']")).click();

		//注文内容確認画面
		driver.findElement(By.cssSelector("input[value='確認して購入']")).click();

		// 正常処理終了
		//注文完了画面
		driver.findElement(By.linkText("戻る")).click();
	}

	// 異常処理
	// 氏名未入力で購入確認ボタンを押下
	public void list201() throws InterruptedException {

		// No.101 商品一覧画面まで遷移する
		try {
			driver.findElement(By.linkText("会員登録をせずに購入する")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		int id = list.get(1).getId();
		//商品クリック
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);

		//非会員のため情報入力

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		// メールを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("aichi@mail.com");

		//セレクトボックス
		WebElement quantity = driver.findElement(By.name("quantity"));
		Select select = new Select(quantity);
		select.selectByValue("2");

		// 備考を入力
		WebElement content = driver.findElement(By.name("content"));
		content.sendKeys("よろしくお願いいたします。");

		//購入ボタンクリック
		driver.findElement(By.cssSelector("input[value='購入']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();
	}

	// 住所未入力で購入確認ボタンを押下
	public void list202() throws InterruptedException {

		//商品クリック
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);

		//非会員のため情報入力

		// 氏名を入力
		WebElement name = driver.findElement(By.name("user_name"));
		name.sendKeys("ichiro");

		// メールを入力
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("aichi@mail.com");

		//セレクトボックス
		WebElement quantity = driver.findElement(By.name("quantity"));
		Select select = new Select(quantity);
		select.selectByValue("2");

		// 備考を入力
		WebElement content = driver.findElement(By.name("content"));
		content.sendKeys("よろしくお願いいたします。");

		//購入ボタンクリック
		driver.findElement(By.cssSelector("input[value='購入']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();
	}

	// メール未入力で購入確認ボタンを押下
	public void list203() throws InterruptedException {

		//商品クリック
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);

		//非会員のため情報入力

		// 氏名を入力
		WebElement name = driver.findElement(By.name("user_name"));
		name.sendKeys("ichiro");

		// 住所を入力
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("愛知県");

		//セレクトボックス
		WebElement quantity = driver.findElement(By.name("quantity"));
		Select select = new Select(quantity);
		select.selectByValue("2");

		// 備考を入力
		WebElement content = driver.findElement(By.name("content"));
		content.sendKeys("よろしくお願いいたします。");

		//購入ボタンクリック
		driver.findElement(By.cssSelector("input[value='購入']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		//ログイン画面に戻る(非会員のため遷移先がログイン画面)
		driver.findElement(By.linkText("【メニュー】")).click();
	}

//　購入確認時、押下する予定の商品情報をMySQL上から削除する
	public void list204() throws InterruptedException {
		// 書籍登録画面まで遷移する
		try {
			driver.findElement(By.linkText("会員登録をせずに購入する")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		ArrayList<Account> account_list = AccountDAO.selectAll();

		String name = account_list.get(0).getName();
		String address = account_list.get(0).getAddress();
		String email = account_list.get(0).getEmail();
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);
		uniformDao.delete(id);
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id + "&user_name=" + name + "&address="  + address + "&email=" + email + "%40gw.co.jp&quantity=1&content=");
		driver.findElement(By.linkText("戻る")).click();
	}
}
