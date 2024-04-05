
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class lumaWebOperationsTest {

    public static ChromeOptions options;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void VisitHomePage() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(" https://magento.softwaretestingboard.com/");
    }

    @Test(priority = 1)
    public void HomePageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("The title of the web page is:  " + pageTitle);
    }

//    @Test
//    public void DemoAccountCreation(){
//        WebElement createAccount = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
//        createAccount.click();
//        //Personal Information credentials
//        WebElement firstName = driver.findElement(By.id("firstname"));
//        firstName.sendKeys("Rose");
//        WebElement lastName = driver.findElement(By.id("lastname"));
//        lastName.sendKeys("Merry");
//        //Sign-In Information
//        WebElement email = driver.findElement(By.id("email_address"));
//        email.sendKeys("rosemerry@gmail.com");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("Rose@768");
//        WebElement password_reenter= driver.findElement(By.id("password-confirmation"));
//        password_reenter.sendKeys("Rose@768");
//        //Create an Account button
//        WebElement create_button  = driver.findElement(By.xpath("//button[@class='action submit primary' and @title='Create an Account']"));
//        create_button.click();
//    }

    @Test(priority = 2)
    public void SignIn() {
        WebElement SignIn = driver.findElement(By.linkText("Sign In"));
        SignIn.click();
        WebElement signin_email = driver.findElement(By.id("email"));
        signin_email.sendKeys("rosemerry@gmail.com");
        WebElement signin_password = driver.findElement(By.id("pass"));
        signin_password.sendKeys("Rose@768");
        WebElement signin_button = driver.findElement(By.id("send2"));
        signin_button.click();

    }

    @Test(priority = 3)
    public void myAccount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropDownClick = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownClick));
        dropDownClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


        //go to my account
        WebElement myaccount = driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/customer/account/']"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(myaccount));
        myaccount.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Shipping Address edit
        WebElement editAddress = driver.findElement(By.xpath("//a[@class='action edit' and @href='https://magento.softwaretestingboard.com/customer/address/edit/id/25997/']/span[text()='Edit Address']"));
        editAddress.click();
        WebElement street1 = driver.findElement(By.id("street_1"));
        street1.clear();
        street1.sendKeys("Lane no. 1");
        WebElement street2 = driver.findElement(By.id("street_2"));
        street2.clear();
        street2.sendKeys("White House");
        WebElement street3 = driver.findElement(By.id("street_3"));
        street3.clear();
        street3.sendKeys("Near State Bank");
        WebElement city = driver.findElement(By.id("city"));
        city.clear();
        city.sendKeys("Noida");
        WebElement country = driver.findElement(By.id("country"));
        Select dropdown = new Select(country);
        String originalValue1 = dropdown.getFirstSelectedOption().getText();
        dropdown.selectByVisibleText("India");
        WebElement state = driver.findElement(By.id("region_id"));
        Select dropDown = new Select(state);
        String originalValue2 = dropdown.getFirstSelectedOption().getText();
        dropDown.selectByValue("566");
        WebElement zipCode = driver.findElement(By.id("zip"));
        zipCode.clear();
        zipCode.sendKeys("64849");
        WebElement phoneNumber = driver.findElement(By.id("telephone"));
        phoneNumber.clear();
        phoneNumber.sendKeys("8735624690");
        WebElement saveAddressButton = driver.findElement(By.xpath("//button[@class='action save primary' and @data-action='save-address' and @title='Save Address']/span[text()='Save Address']"));
        saveAddressButton.click();

//modifications in billing address
        WebElement billingAddress = driver.findElement(By.xpath("//a[contains(@class, 'action edit') and contains(@href, 'customer/address/edit')]/span[text()='Change Billing Address']"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(billingAddress));
        billingAddress.click();
        WebElement billingCity = driver.findElement(By.id("city"));
        billingCity.clear();
        billingCity.sendKeys("Lucknow");
        WebElement billingZip = driver.findElement(By.id("zip"));
        billingZip.clear();
        billingZip.sendKeys("954675");
        WebElement billingAddressSave = driver.findElement(By.xpath("//button[@class='action save primary' and @data-action='save-address' and @title='Save Address']/span[text()='Save Address']"));
        billingAddressSave.click();
    }

    @Test(priority = 4)
    public void visitHome() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement backToHome = driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait8.until(ExpectedConditions.elementToBeClickable(backToHome));
        backToHome.click();
    }

    @Test(priority = 5)
    public void myWishlist() {

        WebElement product1 = driver.findElement(By.xpath("//div[@class='product-item-info']//img[@alt='Radiant Tee']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(product1).build().perform();
        WebElement wishlistButton1 = driver.findElement(By.xpath("//a[contains(@class, 'towishlist')]"));
        wishlistButton1.click();
        driver.navigate().back();

        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[2]/div/a/span/span/img"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(product2));
        Actions actions = new Actions(driver);
        actions.moveToElement(product2).build().perform();
        WebElement wishlistButton2 = driver.findElement(By.cssSelector("div.block-products-list li:nth-child(2) a.action.towishlist"));
        wishlistButton2.click();
        driver.navigate().back();

        WebElement product3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Argus All-Weather Tank' and contains(@class, 'product-image-photo')]\n")));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait1.until(ExpectedConditions.visibilityOf(product3));
        Actions action3 = new Actions(driver);
        action3.moveToElement(product3).build().perform();
        WebElement wishlistButton3 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[3]/div/div/div[@class='product-item-inner']/div/div[@class='actions-secondary']/a[contains(@class, 'action towishlist')]\n"));
        wishlistButton3.click();
        driver.navigate().back();

// remove first added item
        driver.get("https://magento.softwaretestingboard.com/wishlist/");
        WebElement removeFirstItem = driver.findElement(By.xpath("//*[@id='wishlist-sidebar']/li[3]//a[@title='Remove This Item']\n"));
        removeFirstItem.click();

//add last item to cart
        WebElement last_item = driver.findElement(By.xpath("//img[@alt='Argus All-Weather Tank' and contains(@class, 'product-image-photo')]\n"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOf(last_item));
        last_item.click();
        WebElement selectSize = driver.findElement(By.id("option-label-size-143-item-168"));
        selectSize.click();
        WebElement selectColor = driver.findElement(By.id("option-label-color-93-item-52"));
        selectColor.click();
        WebElement addLastItemToCart = driver.findElement(By.id("product-addtocart-button"));
        addLastItemToCart.click();
    }

    @Test(priority = 6)
    public void AddToCompare() {
        WebElement backToHome = driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg"));
        backToHome.click();

//first item addition to comparison list
        WebElement item1 = driver.findElement(By.xpath("//div[@class='product-item-info']//img[@alt='Radiant Tee']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(item1).build().perform();
        WebElement compareButton1 = driver.findElement(By.cssSelector("#maincontent .block-products-list li:first-child a.action.tocompare\n"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        compareButton1.click();
        driver.navigate().back();

//second item addition to comparison list
        WebElement item2 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[2]/div/a/span/span/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(item2).build().perform();
        WebElement compareButton2 = driver.findElement(By.cssSelector("div.block-products-list li:nth-child(2) .product-item-inner .actions-secondary .action.tocompare\n"));
        compareButton2.click();

//Compare List
        WebElement goToCompare = driver.findElement(By.cssSelector("a.action.compare\n"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOf(goToCompare));
        goToCompare.click();

//added most reviewed item to cart
        driver.findElement(By.xpath("//img[@class='product-image-photo' and @alt='Radiant Tee']\n"));
        WebElement addToCart = driver.findElement(By.xpath("//form[@data-role='tocart-form']\n"));
        addToCart.click();
        WebElement selectSize1 = driver.findElement(By.id("option-label-size-143-item-167"));
        selectSize1.click();
        WebElement selectColor1 = driver.findElement(By.id("option-label-color-93-item-56"));
        selectColor1.click();
        WebElement addMostReviewedItem = driver.findElement(By.id("product-addtocart-button"));
        addMostReviewedItem.click();
        driver.navigate().back();

//remove first item from comparison list
        WebElement removeFirstProduct = driver.findElement(By.xpath("//*[@id=\"product-comparison\"]/thead/tr/td[1]/a"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        removeFirstProduct.click();
        WebElement xyz = driver.findElement(By.cssSelector("footer.modal-footer button.action-primary\n"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        xyz.click();

//remove second item from comparison list
        WebElement removeSecondProduct = driver.findElement(By.xpath("//a[@title='Remove Product']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        removeSecondProduct.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("footer.modal-footer button.action-primary\n")).click();
    }

    @Test(priority = 7)
    public void Cart() {
        //printing size of cart
        WebElement cartSizeElement = driver.findElement(By.cssSelector("span.counter-label"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // cartSizeElement.click();
        String cartSize = cartSizeElement.getText();
        System.out.println("Cart Size: " + cartSize);
    }
//Go to view and Edit cart
//        WebElement viewAndEditCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='View and Edit Cart']")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        viewAndEditCart.click();


//update the  quantity of items in cart
//        driver.findElement(By.xpath("//a[@class='action viewcart' and @href='https://magento.softwaretestingboard.com/checkout/cart/']\n")).click();
//        WebElement item1qty = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[3]/div"));
//        item1qty.clear();
//        item1qty.sendKeys("2");
//        WebElement item2Qty = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[3]/div"));
//        item2Qty.clear();
//        item2Qty.sendKeys("2");
//        driver.findElement(By.xpath("//a[@class='action viewcart' and @href='https://magento.softwaretestingboard.com/checkout/cart/']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//print the order total
    //  WebElement orderTotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr.grand.totals span.price")));
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait1.until(ExpectedConditions.elementToBeClickable(orderTotalElement));
//        String orderTotal = orderTotalElement.getText();
//        System.out.println("Order Total: " + orderTotal);

//choose fixed shipping method
//        WebElement estimateShipping = driver.findElement(By.id("block-shipping-heading"));
//        estimateShipping.click();
//        driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']\n")).click();

    // }
//place order
//        WebElement placeOrder = driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout' and contains(@class,'action primary checkout')]\n"));
//        placeOrder.click();
//        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.action.continue.primary")));
//        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1000));
//        wait3.until(ExpectedConditions.elementToBeClickable(nextButton));
//        nextButton.click();
//        WebElement orderCheckout = driver.findElement(By.xpath("//div[@class='primary']//button[@class='action primary checkout']\n"));
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
//        wait2.until(ExpectedConditions.elementToBeClickable(orderCheckout));
//        orderCheckout.click();
//
//printing order number
//        WebElement orderNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Your order number is:')]//a[@class='order-number']\n")));
//        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait4.until(ExpectedConditions.elementToBeClickable(orderNumberElement));
//        String orderNumber = orderNumberElement.getText();
//        System.out.println("your order number is: " + orderNumber);
//    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



















