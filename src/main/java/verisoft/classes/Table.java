package verisoft.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import verisoft.utils.Browser;

/**
 * Represents a table in a web page.
 */
public class Table {
    private static final By table = By.id("customers");

    private final Browser browser;

    /**
     * Constructs a Table object.
     *
     * @param browser The browser instance to use for interacting with the table.
     */
    public Table(Browser browser) {
        this.browser = browser;
    }

    /**
     * Retrieves the web element representing the table.
     *
     * @return The web element representing the table.
     */
    public WebElement getTable() {
        return browser.findElement(table);
    }

    /**
     * Retrieves the text of a cell in the table using XPath.
     *
     * @param table The table web element.
     * @param searchColumn The index of the column to search in.
     * @param searchText The text to search for in the specified column.
     * @param returnColumnText The index of the column from which to return the text.
     * @return The text of the specified cell.
     * @throws Exception If an error occurs during the process.
     */
    public String getTableCellTextByXpath (WebElement table, int searchColumn,
                                           String searchText, int returnColumnText) throws Exception{
        try {
            return table.findElement(By.xpath("//table[@id='customers']/tbody/tr/td[" + searchColumn + "][text()='" + searchText + "']/../td[" + returnColumnText + "]")).getText();
        }
        catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            return "Element not found";
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return "An error occurred";
        }
    }

    /**
     * Verifies if the text in a specified cell matches the expected text.
     *
     * @param table The table web element.
     * @param searchColumn The index of the column to search in.
     * @param searchText The text to search for in the specified column.
     * @param returnColumnText The index of the column from which to return the text.
     * @param expectedText The expected text to compare against.
     * @return True if the actual text matches the expected text, false otherwise.
     * @throws Exception If an error occurs during the process.
     */
    public boolean verifyTableCellText(WebElement table, int searchColumn,
                                       String searchText, int returnColumnText, String expectedText) throws Exception {
        return getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText).equals(expectedText);
    }
}