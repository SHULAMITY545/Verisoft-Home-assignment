package verisoft.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.verisoft.utils.Browser;
import org.verisoft.utils.XmlConfig;
import org.verisoft.classes.DataProviders;
import org.verisoft.classes.Table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This class contains TestNG test cases for the Table class.
 */
public class TableTest {
    protected Browser browser;
    protected XmlConfig config = new XmlConfig("Configuration.XML");

    /**
     * Initializes the browser session before the test class.
     */
    @BeforeClass
    public void startSession() {
        browser = Browser.getInstance(config.get("Browser"));
        browser.navigateTo(config.get("Url"));
    }

    /**
     * Closes the browser session after the test class.
     */
    @AfterClass
    public void closeSession() {
        browser.quitDriver();
    }

    /**
     * Test method for getting cell text by XPath from a table using CSV data.
     *
     * @param searchColumn     The column to search for.
     * @param searchText       The text to search for.
     * @param returnColumnText The column to return text from.
     * @param expectedText     The expected text result.
     * @throws Exception If an exception occurs during the test.
     */
    @Test(dataProviderClass = org.verisoft.classes.DataProviders.class, dataProvider = "testGetTableCellTextByXpathCsv")
    public void testGetTableCellTextByXpathDataCsv(String searchColumn, String searchText, String returnColumnText, String expectedText) throws Exception {
        Table table = new Table(browser);
        String actual = table.getTableCellTextByXpath(table.getTable(),
                Integer.parseInt(searchColumn), searchText, Integer.parseInt(returnColumnText));

        assertTrue(actual.equalsIgnoreCase(expectedText), expectedText + " is different from " + actual + ". ");
    }

    /**
     * Test method for verifying cell text in a table using CSV data.
     *
     * @param searchColumn     The column to search for.
     * @param searchText       The text to search for.
     * @param returnColumnText The column to return text from.
     * @param expectedText     The expected text result.
     * @param expectedResult  The expected verification result.
     * @throws Exception If an exception occurs during the test.
     */
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testVerifyTableCellTextCsv")
    public void testVerifyTableCellTextDataCsv(String searchColumn, String searchText, String returnColumnText, String expectedText, String expectedResult) throws Exception {
        Table table = new Table(browser);
        boolean actual = table.verifyTableCellText(table.getTable(),
                Integer.parseInt(searchColumn), searchText, Integer.parseInt(returnColumnText), expectedText);

        assertEquals(actual, Boolean.valueOf(expectedResult));
    }

    /**
     * Test method for getting cell text by XPath from a table using XML data.
     *
     * @param searchColumn     The column to search for.
     * @param searchText       The text to search for.
     * @param returnColumnText The column to return text from.
     * @param expectedText     The expected text result.
     * @throws Exception If an exception occurs during the test.
     */
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testGetTableCellTextByXpathXml")
    public void testGetTableCellTextByXpathDataXml(String searchColumn, String searchText, String returnColumnText, String expectedText) throws Exception {
        Table table = new Table(browser);
        String actual = table.getTableCellTextByXpath(table.getTable(),
                Integer.parseInt(searchColumn), searchText, Integer.parseInt(returnColumnText));

        assertTrue(actual.equalsIgnoreCase(expectedText), expectedText + " is different from " + actual + ". ");
    }

    /**
     * Test method for verifying cell text in a table using XML data.
     *
     * @param searchColumn     The column to search for.
     * @param searchText       The text to search for.
     * @param returnColumnText The column to return text from.
     * @param expectedText     The expected text result.
     * @param expectedResult  The expected verification result.
     * @throws Exception If an exception occurs during the test.
     */
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testVerifyTableCellTextXml")
    public void testVerifyTableCellTextDataXml(String searchColumn, String searchText, String returnColumnText, String expectedText, String expectedResult) throws Exception {
        Table table = new Table(browser);
        boolean actual = table.verifyTableCellText(table.getTable(),
                Integer.parseInt(searchColumn), searchText, Integer.parseInt(returnColumnText), expectedText);

        assertEquals(actual, Boolean.valueOf(expectedResult));
    }
}
