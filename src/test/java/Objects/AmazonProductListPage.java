package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  * Need to check openU about the correct spell
 *   @check_about_this
 *
 * Amazon Product List Page appereance:
 * serach results, filters, results, sort by
 *
 * • Constructors:
 *         AmazonProductListPage
 *
 *  • By - getting id's of amazon elements:
 *   //Filter
 *        locallyAvailable_shipLocally
 *
 *   • Actions:
 *   //Filter
 *         shipLocally
 */
public class AmazonProductListPage {
    WebDriver driver;

    /** Constructors */

    /**
     * Need to check openU about the correct spell
     *
     * @param driver - Assign driver to object
     */
    public AmazonProductListPage(WebDriver driver){
        this.driver = driver;
    }

    /** By (Locators)*/
    // Filter
    By locallyAvailable_shipLocally = By.linkText("Ships Locally"); // OK

    By department_Electronics = By.linkText("Electronics"); // OK
    By department_AnyDeparment = By.linkText("Any Department"); // OK

    //By customerReviews_4 = By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']"); // DELETE

    // Search Result
    By search_result_Text = By.xpath("//span[@class='a-color-state a-text-bold']"); // OK - Must use xpath
    By search_result_Summary = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"); // OK - Must use xpath


    /** Actoions */

    /**     Setters (changing, clicking, sendkeys, etc):*/

    // Filter
    /**
     * Need to check openU about the correct spell
     *
     * NOTICE: Filter not always appears
     * NOTICE: Looping refresh until filter found
     *
     * On filter section (left side), clicking on Locally Available - Ships Locally
     */
    public void filter_ShipLocally_click(){
        try {

            if (driver.findElement(locallyAvailable_shipLocally).isDisplayed()){ // Due to sometimes filter not displayed
                driver.findElement(locallyAvailable_shipLocally).click();
                Thread.sleep(3000);
            } else {
                driver.navigate().refresh();
                Thread.sleep(3000);
                filter_ShipLocally_click();
            }


        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }
    }

    /** On filter section (left side), clicking on Department - Electronics */
    public void filter_Electronics_click(){
        try {
            driver.findElement(department_Electronics).click();
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }
    }

/* DELETE
    public void filter_CustomerReviews4_click(){
        try {
            driver.findElement(customerReviews_4).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }
    }
*/
    public void filter_CustomerReview_SelectStarsByNum (int stars){
        By customerReviews_Stars = By.cssSelector("i.a-icon.a-icon-star-medium.a-star-medium-"+stars);
        try {
            driver.findElement(customerReviews_Stars).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }
    }

    // Product
    public void product_ClickById(int num){
        By product_id = By.xpath("//div[@data-cel-widget='search_result_"+num+"']");
        // System.out.println(By.xpath("//div[@data-cel-widget='search_result_"+num+"']")); // Testing

        try {
            driver.findElement(product_id).click();
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }

    /**     Getters - Getting info*/

    // Filter

    /** Checking the Locally Available - Ships Locally checkbox
     * @return checkbox status (selected or not) as a String */
    public boolean filter_ShipLocally_isSelected(){
        return driver.findElement(locallyAvailable_shipLocally).isEnabled(); // return: true/false
    }

    public boolean filter_AnyDepartment_isDisplayed(){
        return driver.findElement(department_AnyDeparment).isDisplayed(); // return: true/false
    }


    // Search Results
    /** Getting the searched text
     * @return search text */
    public String searchResults_GetText() {
        String returnText = driver.findElement(search_result_Text).getText();
        // Cutting " from text (example: Sony instead of "Sony")
        returnText = returnText.replaceAll("\"", ""); // if not working - try with []
        /*returnText = returnText.substring(1);
        returnText = returnText.substring(0, returnText.length() - 1);*/
        return returnText;
    }

    /** Return the summary of the searched product,
     * How much appears on the correct screen, and the total result (for example: "1-16 of over 8,000 results for")
     * @return summary of the searched result*/
    public String searchResults_Summary(){
        return driver.findElement(search_result_Summary).getText();
    }




}
