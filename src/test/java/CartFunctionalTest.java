import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

import java.util.concurrent.TimeUnit;


public class CartFunctionalTest extends TestRunner {
    @Test
    public void addProductToShoppingCart() {
        //arrange
        HomePage homePage = loadAplication();
        delayExecution(1000);
        //actual
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();

        delayExecution(10000);

        ProductMessagePage productMessagePage = new ProductMessagePage(driver);
        productMessagePage.closeAlertMessage();

        delayExecution(10000);
        productMessagePage.clickShoppingCart();
        ShoppingCartPage soppingCartPage = new ShoppingCartPage(driver);
        //assert
        Assert.assertTrue(soppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }


}