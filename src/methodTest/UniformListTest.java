package methodTest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import bean.Uniform;
import dao.UniformDAO;

public class UniformListTest {

	private WebDriver driver;

	UniformDAO uniformDao = new UniformDAO();
	ArrayList<Uniform> list = uniformDao.selectAll();

    int id = list.get(0).getId();
    int ad_id = list.get(1).getId();

	public UniformListTest(WebDriver driver) {
		this.driver = driver;
	}

	//一覧機能をテストするメソッドを呼び出す
	public void UniformList() throws InterruptedException {
		UniformListTest listtest = new UniformListTest(driver);

		// 正常動作確認
		listtest.list201();
		listtest.list101();

		// DB接続エラーのテストケースがありますが、今回はやりません
	}

	//一覧機能をテストするメソッドを呼び出す
	public void adminUniformList() throws InterruptedException {
		UniformListTest listtest = new UniformListTest(driver);

		// 正常動作確認
		listtest.list202();
		listtest.list102();

		// DB接続エラーのテストケースがありますが、今回はやりません
	}

	// 購入者(一般ユーザー)正常に一覧表示処理が行われるか
	public void list101() throws InterruptedException {

		// No.101 商品一覧画面まで遷移する
		try {
			driver.findElement(By.linkText("【商品一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		// No.102 既に登録されているISBNを入力
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);
		driver.findElement(By.linkText("【商品一覧】")).click();

		// 正常処理終了
		// No.103 メニュー画面に戻る
		driver.findElement(By.linkText("【メニュー】")).click();
	}

	// 管理者で正常に一覧表示処理が行われるか
	public void list102() throws InterruptedException {

		// No.101 商品一覧画面まで遷移する
		try {
			driver.findElement(By.linkText("【商品一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		// No.102 既に登録されているISBNを入力
		driver.get("http://localhost:8080/pegopa/uniformUpdate?cmd=1&id=" + ad_id);
		driver.findElement(By.linkText("【商品一覧】")).click();

		// 正常処理終了
		// No.103 メニュー画面に戻る
		driver.findElement(By.linkText("【メニュー】")).click();
	}

	// 異常処理
	// 商品リンク押下する予定の商品情報をMySQL上から削除する
	public void list201() throws InterruptedException {

		// 書籍登録画面まで遷移する
		try {
			driver.findElement(By.linkText("【商品一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		uniformDao.delete(id);
		driver.get("http://localhost:8080/pegopa/orderBuy?cmd=1&id=" + id);

		// 一覧に戻るをクリック
		driver.findElement(By.linkText("戻る")).click();


	}

	// 商品リンク押下する予定の商品情報をMySQL上から削除する
	public void list202() throws InterruptedException {

		// 書籍登録画面まで遷移する
		try {
			driver.findElement(By.linkText("【商品一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【ログアウト】")).click();
		}

		uniformDao.delete(ad_id);
		driver.get("http://localhost:8080/pegopa/uniformUpdate?cmd=1&id=" + ad_id);

		// 一覧に戻るをクリック
		driver.findElement(By.linkText("戻る")).click();

		// メニューに戻るをクリック
		driver.findElement(By.linkText("【メニュー】")).click();

	}
}
