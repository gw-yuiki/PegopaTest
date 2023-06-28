package methodTest;

import org.openqa.selenium.*;



public class UniformInsertTest {

	private WebDriver driver;

	String imgPath = "C:\\Users\\Globalway\\Pictures\\Camera Roll\\IMG_6879.png";

	public UniformInsertTest(WebDriver driver) {
		this.driver = driver;
	}

	public void insert() throws InterruptedException {
		UniformInsertTest uniforminserttest = new UniformInsertTest(driver);
		uniforminserttest.insert202();
		uniforminserttest.insert203();
		uniforminserttest.insert204();
		uniforminserttest.insert101();
		//uniforminserttest.insert102(); pegopa最新バージョンになったらコメントアウト消す
	}

	// 正常系
	// 全ての欄入力
	public void insert101() throws InterruptedException {

		// 商品名入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テスト商品");

		// 画像を挿入
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		// 単価入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("1200");

		// 在庫数入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		driver.findElement(By.linkText("【メニュー】")).click(); //pegopa最新バージョンになったらこの処理はinsert102に移す
	}

	// 商品画像だけ未挿入
	public void insert102() throws InterruptedException {

		driver.findElement(By.linkText("【メニュー】")).click();
		driver.findElement(By.linkText("【商品登録】")).click();

		// 商品名入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テスト商品");

		// 画像未挿入

		// 単価入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("1200");

		// 在庫数入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}

	// 異常系
	// 商品名だけ未挿入または価格だけ未入力の場合
	public void insert202() throws InterruptedException {

		driver.findElement(By.linkText("【商品登録】")).click();

		// 商品名未入力

		// 画像を挿入
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		// 単価入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("1200");

		// 在庫数入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した内容を全てクリア
		img.clear();
		price.clear();
		stock.clear();

		// 商品名入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テスト商品");

		// 画像を挿入
		img.sendKeys(imgPath);

		// 単価未入力

		// 在庫数入力
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// ダイアログのOKボタンを押下
		Thread.sleep(500);
		alert.accept();

		// 入力した内容を全てクリア
		name.clear();
		img.clear();
		stock.clear();
	}

	// 単価の値が整数でない場合または在庫の値が整数でない場合
	public void insert203() throws InterruptedException {

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
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// ダイアログのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
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
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// ダイアログのOKボタンを押下
		Thread.sleep(500);
		alert.accept();

		// 入力した内容を全てクリア
		name.clear();
		img.clear();
		price.clear();
		stock.clear();
	}

	// ファイルの拡張子がJPEG, PNG以外の場合
	public void insert204() throws InterruptedException {

		// 商品名入力
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("テスト商品");

		// エクセルファイルを挿入
		String imgPath = "C:\\usr\\kis_java_pkg_ver4.8\\workspace\\TestCase_bmsdb10j_stepbystep2.xls";
		WebElement img = driver.findElement(By.name("img"));
		img.sendKeys(imgPath);

		// 単価入力
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("1200");

		// 在庫数入力
		WebElement stock = driver.findElement(By.name("stock"));
		stock.sendKeys("6");

		// 登録ボタンを押す
		driver.findElement(By.cssSelector("input[value='登録']")).click();

		// アラートのOKボタンを押下
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();

		// 入力した内容を全てクリア
		name.clear();
		img.clear();
		price.clear();
		stock.clear();
	}
}
