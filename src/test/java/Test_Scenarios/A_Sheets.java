package Test_Scenarios;

import Objects.AmazonProductListPage;
import Objects.AmazonProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A_Sheets {
    WebDriver driver;

    @BeforeTest
    public void BeforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void AfterTest(){
        // try & catch to avoid adding throw exception on public line
        try {
            // Wait time before closing
            Thread.sleep(4000); // Wait Time
            driver.quit();

        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }
    /*
    @Test
    public void test1(){
        driver.get("https://www.amazon.com/s?k=Sony&crid=25SPED886PKFU&sprefix=son%2Caps%2C284&ref=nb_sb_noss_2");
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Ships Locally")).click();
    }
    */

    /*
    @Test
    public void test2(){
        driver.get("https://www.amazon.com/s?k=Sony&crid=25SPED886PKFU&sprefix=son%2Caps%2C284&ref=nb_sb_noss_2");
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_ShipLocally_click();
    }
    */

    /*
    @Test
    public void test3(){
        driver.get("https://www.amazon.com/s?k=Sony&rh=n%3A172282%2Cp_n_is_country_local%3A17964664011&dc&ds=v1%3A4eEp2nxcM4m%2BGyyM1Ackw68sH0%2BqBTWCIseHVkjde%2Fg&qid=1657560559&rnid=2941120011&ref=sr_nr_n_1");
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_CustomerReviews4_click();
    }
    */

    /*
    @Test(priority = 3) // Test 3
    // Filter customer review, 4 stars and up (Filter not saved on Amazon site
    public void filter_CustomerReview_4 () {
        driver.get("https://www.amazon.com/s?k=Sony&i=electronics&rh=p_n_is_country_local%3A17964664011&dc&crid=1YFFOVO0RXRB9&qid=1657795880&rnid=17964663011&sprefix=sony%2Celectronics%2C742&ref=sr_nr_p_n_is_country_local_1&ds=v1%3ADh8r4uD1V9NRnhkcsVdp5XpJ%2B8VTUT8zIBOpALtab8Y");
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_CustomerReview_SelectStarsByNum(4);

        // Tests
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "10 results for"); // 1. Checking if searched result has been updated after selecting 4 stars
    }
     */
    /*
    @Test
    public void test4(){
        driver.get("https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZHCNPMN/ref=sr_1_1?keywords=Sony&qid=1657562381&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011%2Cp_n_deal_type%3A23566065011&rnid=23566063011&s=electronics&sr=1-1&th=1");
        AmazonProductPage ProductPage = new AmazonProductPage(driver);
        System.out.println(ProductPage.title_GetText_toLowerCase());
    }
    */

    /*
    @Test (priority = 5) // Test 5
    // Selecting product color
    public void test5(){
        driver.get("https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZHCNPMN/ref=sr_1_1?keywords=Sony&qid=1657562381&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011%2Cp_n_deal_type%3A23566065011&rnid=23566063011&s=electronics&sr=1-1&th=1");
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.color_ClickByName("Light Blue");
        System.out.println(ProductPage.color_Selected());
    }
     */
    /*
    @Test
    public void testRefresh() throws InterruptedException {
        driver.get("https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZHCNPMN/ref=sr_1_1?keywords=Sony&qid=1657562381&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011%2Cp_n_deal_type%3A23566065011&rnid=23566063011&s=electronics&sr=1-1&th=1");
        Thread.sleep(5);

        driver.navigate().refresh();

    }
    */
    /*
    @Test (priority = 6) // Test 6
    // Selecting product image
    public void product_imgage_6(){
        driver.get("https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZJ1QLCW/ref=sr_1_1?keywords=Sony&qid=1657619613&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011&rnid=1248877011&s=electronics&sr=1-1&th=1");

        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.imgvid_ClickById(3);
    }
     */
    /*
    @Test (priority = 7) // Test 7
    // Selecting product image
    public void product_AllBuyOptions(){
        driver.get("https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZJ1QLCW/ref=sr_1_1?keywords=Sony&qid=1657619613&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011&rnid=1248877011&s=electronics&sr=1-1&th=1");

        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.purchase_AllBuyOptions();
    }
     */


    /* Dog supplies*/
    /*
    @Test(priority = 1) //Test 1
    // @TODO Filter dog supplies
    public void filter_DogSupplies() {
        driver.get("https://www.amazon.com/s?k=Dog&crid=360VBAZN8LM5W&sprefix=dog+%2Caps%2C240&ref=nb_sb_noss_2");


        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_Department_DogSupplies_click();

        // Tests
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "1-24 of over 50,000 results for"); // 1. Checking total results
        Assert.assertTrue(ProductListPage.filter_AnyDepartment_isDisplayed()); // 1. Checking if Any Department button appears
    }
     */
    /*
    @Test(priority = 2) //Test 2
    // @TODO Filter price up to 25
    public void filter_Price_Upto25() {
        driver.get("https://www.amazon.com/s?k=Dog&i=pets&rh=n%3A2975312011&dc&crid=360VBAZN8LM5W&qid=1658084975&sprefix=dog+%2Caps%2C240&ref=sr_ex_p_36_0&ds=v1%3AWm34fZH1QwZqBd6DtQLigwSqmOKPDB4sv%2B9L63gVjO4");

        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_price_clickByText("Up to $25");

        // Tests
        Assert.assertTrue(ProductListPage.filter_AnyPrice_isDisplayed()); // 1. Checking if Any Price button appears
    }

     */

    @Test(priority = 3) // Test 3
    public void product_SelectCollar() {
        driver.get("https://www.amazon.com/s?k=Dog&i=pets&rh=n%3A2975312011%2Cp_36%3A2661612011&dc&ds=v1%3AixLsl5fPHjM6az1BK86ErGEOOpuKKQxKvO6Bz2xASGk&crid=37KGVBN2UQOYV&qid=1659120946&rnid=2661611011&sprefix=dog%2Caps%2C885&ref=sr_nr_p_36_1");

        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.product_Click_FirstByText("Vest");

        // Tests
        /* Currently selected product is: (may changed)
            Product: DAGANXI Tactical Dog Collar, Adjustable Military Training Nylon Dog Collar with Control Handle and Heavy Metal Buckle for Medium and Large Dogs, with Patches and Airtags Case (L, Black)
            URL: https://www.amazon.com/DAGANXI-Tactical-Adjustable-Military-Training/dp/B0962R78HN/ref=sr_1_6?crid=1N2EPB8KHWI2H&keywords=Dog&qid=1658051244&refinements=p_36%3A2661612011&rnid=2661611011&s=pet-supplies&sprefix=dog%2Caps%2C540&sr=1-6
        */
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object

        // String initial
        String expectedProduct = "DAGANXI Tactical Dog Collar, Adjustable Military Training Nylon Dog Collar with Control Handle and Heavy Metal Buckle for Medium and Large Dogs, with Patches and Airtags Case (L, Black)";
        expectedProduct = expectedProduct.toLowerCase();
        String actualProduct = ProductPage.title_GetText_toLowerCase();

        // String substring
        int substringAt = 20;
        expectedProduct = expectedProduct.substring(0, substringAt);
        actualProduct = actualProduct.substring(0, substringAt);

        Assert.assertEquals(actualProduct, expectedProduct); // 1. Checking if the title of the selected product matches
    }

}
