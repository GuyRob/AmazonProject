package Objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Need to check openU about the correct spell
 * @check_about_this
 *
 *
 *  Amazon navigation (top) - appearance:
 *  (Top)
 *  Line 1: amazon logo, deliver to, searchbar, country, account & lists, returns & orders, cart logo
 *  Line 2: (Texts) "All", "Today's Deals", "Buy Again", "Customer Service", "Gift Cards", "Registry", "Browsing Hstory", "Sell", "Local Delivery in Country"
 *
 *  (Buttom)
 *  line 1: back to top
 *  Line 2: get to know us, make money with us, amazon payment products, let us help you
 *  Line 3: amazon logo, language, currency, united states
 *  Line 4: footer
 *
 *
 * • Constructors:
 *      AmazonPage
 *
 * • By - getting id's of amazon elements:
 *  //Search
 *      searchbox
 *      search_btn
 *      search_result
 *
 *  //Filter
 *      locallyAvailable_shipLocally
 *
 *  • Actions:
 *  // Search
 *      search
 *      searchResult
 *
 */
public class AmazonNavigation {
    WebDriver driver;

    /** Constructor */

    /**
     * Need to check openU about the correct spell
     *
     * @param driver - Assign driver to object
     */
    public AmazonNavigation(WebDriver driver){
        this.driver = driver;
    }

    /** By */
    // Search
    By searchbox = By.id("twotabsearchtextbox");
    By search_btn = By.id("nav-search-submit-button");



    /**
     * Need to check openU about the correct spell
     *
     * Actions:
     * */
    // Search


    /** Searching product on search bar according to the input text
     * @param product - input text */
    public void search(String product){
        try {
            driver.findElement(searchbox).sendKeys(product);
            driver.findElement(search_btn).click();
            Thread.sleep(3000);
        }   catch (Exception e){
                System.out.println("Exceptions Caught" + e.getMessage());
            }
    }






    }


