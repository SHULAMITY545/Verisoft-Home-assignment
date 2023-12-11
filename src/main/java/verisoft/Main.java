package verisoft;

import verisoft.classes.Table;
import verisoft.utils.Browser;
import verisoft.utils.XmlConfig;

/**
 * This class demonstrates a simple example of using the Table class and related utilities.
 */
public class Main  {
    /**
     * The main method that executes the example.
     *
     * @param args Command-line arguments (not used in this example).
     * @throws Exception If an exception occurs during execution.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        // Load configuration from XML
        XmlConfig config = new XmlConfig("Configuration.XML");

        // Initialize the browser
        Browser browser = Browser.getInstance(config.get("Browser"));
        browser.navigateTo(config.get("Url"));

        // Perform a search and retrieve cell text using the Table class
        String searchColumn = "1",
               searchText = "Centro comercial Moctezuma",
               returnColumnText = "3";

        Table table = new Table(browser);
        String result = table.getTableCellTextByXpath(table.getTable(),
                Integer.parseInt(searchColumn), searchText, Integer.parseInt(returnColumnText));

        System.out.println(result);     // Expected: Mexico
    }
}
