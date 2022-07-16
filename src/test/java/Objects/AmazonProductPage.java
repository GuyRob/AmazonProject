package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  Need to check openU about the correct spell
 *  @check_about_this
 *
 *  Amazon Product Page appereance:
 *  ad link (suggested product)
 *  Photos & Video - options
 *  Photos & Video - Big picture
 *  Description
 *  Ref (Visit store/Brand/Etc..)
 *  Rating details, rating list link, answered questions
 *  Amazon's Choice (not always appears)
 *  Select options (Color/Size/Etc..)
 *  Important details (Brand, Model, Speaker Type)
 *  About this item
 *  Frequently bought together (not always appears)
 *  Products related to this item / Free shipping by Amazon: Customers purchased also purchased (not always appears)
 *  More product info
 *  Seller description (not always appears)
 */
public class AmazonProductPage {
    WebDriver driver;

    /** Constructors */

    /**
     * Need to check openU about the correct spell
     *
     * @param driver - Assign driver to object
     */
    public AmazonProductPage(WebDriver driver){
        this.driver = driver;
    }

    /** By (Locators)*/
    // Product
    By title = By.xpath("//span[@id='productTitle']"); // OK

    By color_Selected = By.xpath("//span[@class='selection']"); // OK

    // Purchase
    By purchase_SeeAllBuyOptions = By.xpath("//a[@title='See All Buying Options']"); // OK

    By purchase_SeeAllBuyOptions_Open = By.xpath("//body[@style='overflow: scroll;']"); // In progress

    /** Actoions */

    /**     Setters (changing, clicking, sendkeys, etc):*/
    // Product

    /**
     * Clicking on color by input name (color name)
     * @param input color name
     */
    public void color_ClickByName(String input){
        By color_str = By.xpath("//img[@alt='"+input+"']");

        try {
            driver.findElement(color_str).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }

    public void imgvid_ClickById(int num){
        By imgvid_id = By.xpath("//li[@data-csa-c-posy='"+num+"']");

        try {
            driver.findElement(imgvid_id).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }

    // Purchase
    public void purchase_AllBuyOptions(){

        try {
            driver.findElement(purchase_SeeAllBuyOptions).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }


    /**     Getters - Getting info*/
    // Product
    /**
     * NOTICE: May need to delete options text on tests (options for example: Color/Size/Etc...)
     *
     * @return Title text
     */
    public String title_GetText_toLowerCase(){
            return driver.findElement(title).getText().toLowerCase();
    }

    public String color_Selected(){
        return driver.findElement(color_Selected).getText();
    }


} // End of class


