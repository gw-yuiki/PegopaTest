package methodTest;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bean.Uniform;
import dao.UniformDAO;

public class UniformUpdateTest {

	private WebDriver driver;

	UniformDAO uniformDao = new UniformDAO();
	ArrayList<Uniform> list = uniformDao.selectAll();

	int id = list.get(0).getId();
	int ad_id = list.get(1).getId();

	String imgPath = "C:\\Users\\Globalway\\Pictures\\testimg\\gwicon.png";

	public UniformUpdateTest(WebDriver driver) {
		this.driver = driver;
	}

	//商品変更
	public void update() throws InterruptedException {
		UniformUpdateTest uniformUpdateTest = new UniformUpdateTest(driver);
		uniformUpdateTest.update101();
		Thread.sleep(1000);
		uniformUpdateTest.update102();
		Thread.sleep(1000);
		uniformUpdateTest.update103();
		Thread.sleep(1000);
		uniformUpdateTest.update104();
		Thread.sleep(1000);
		uniformUpdateTest.update105();
		Thread.sleep(1000);
		uniformUpdateTest.update100();
		Thread.sleep(1000);
		uniformUpdateTest.update106();
	}

	//正常に商品変更処理が行われるか
	public void update100() throws InterruptedException {

		//種類を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ユニフォーム1");

		//価格を入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("5000");

		// イメージを入力
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		//在庫数を入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("15");

		Thread.sleep(500);
		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();
	}

	// 種類を未入力で変更完了ボタン押下
	public void update101() throws InterruptedException {

		driver.findElement(By.linkText("【商品一覧】")).click();
		driver.findElements(By.className("product")).get(0).click();

		// 入力されている種類を削除
		driver.findElement(By.name("name")).clear();

		// 価格を削除
		driver.findElement(By.name("price")).clear();

		// 在庫数を削除
		driver.findElement(By.name("stock")).clear();

		//価格を入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("5000");

		// イメージを入力
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		//在庫数を入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("15");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// 入力した価格を削除
		price.clear();
		// 入力した在庫数を削除
		stock.clear();
	}

	// 価格を未入力で変更完了ボタン押下
	public void update102() throws InterruptedException {

		//種類を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ユニフォーム1");

		// イメージを入力
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		//在庫数を入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("15");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// 入力した種類を削除
		name.clear();
		// 入力した在庫数を削除
		stock.clear();
	}

	// 在庫数を未入力で変更完了ボタン押下
	public void update103() throws InterruptedException {

		//種類を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ユニフォーム1");

		// イメージを入力
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		//価格を入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("5500");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// 入力した種類を削除
		name.clear();
		// 入力した在庫数を削除
		price.clear();
	}

	//画像の拡張子が間違っている場合
	public void update104() throws InterruptedException {

		//種類を入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ユニフォーム1");

		// イメージを入力
		String imgPath = "C:\\Users\\Globalway\\Pictures\\testimg\\excel.xls";
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		//価格を入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("5500");

		//在庫数を入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("15");

		// 変更完了ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// 入力した種類を削除
		name.clear();
		// 入力した在庫数を削除
		price.clear();
		//入力した在庫数を削除
		stock.clear();
	}

	// 単価の値が整数でない場合または在庫の値が整数でない場合
	public void update105() throws InterruptedException {

		// 商品名入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テスト商品");

		// 画像を挿入
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		// 単価を文字列で入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("abcdef");

		// 在庫数入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// 入力した内容を全てクリア
		name.clear();
		img.clear();
		price.clear();
		stock.clear();

		// 商品名入力
		name.sendKeys("テスト商品");

		// 画像を挿入
		img.sendKeys(imgPath);

		// 単価入力
		price.sendKeys("1200");

		// 在庫数を文字列で入力
		stock.sendKeys("abcdef");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='変更']")).click();

		// ダイアログのOKボタンを押下
		Thread.sleep(1000);
		alert.accept();

		// 入力した内容を全てクリア
		name.clear();
		img.clear();
		price.clear();
		stock.clear();
	}

	// 異常処理
	// 変更ボタン押下する予定の商品情報をMySQL上から削除する
	public void update106() throws InterruptedException {

		// 書籍登録画面まで遷移する
		try {
			driver.findElements(By.className("product")).get(0).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		uniformDao.delete(id);
		driver.get("http://localhost:8080/pegopa/uniformUpdate?cmd=1&id=" + id);
		Thread.sleep(1000);

		// 一覧に戻るをクリック
		driver.findElement(By.linkText("戻る")).click();

	}

}
