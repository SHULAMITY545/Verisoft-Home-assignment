package verisoft.classes;

import org.testng.annotations.DataProvider;
import verisoft.utils.CsvHandling;
import verisoft.utils.XmlHandling;

/**
 * This class provides TestNG data providers for various test cases.
 */
public class DataProviders {

    /**
     * Provides test data from a CSV file for the testGetTableCellTextByXpathCsv test case.
     *
     * @return The test data as a 2D array of objects.
     */
    @DataProvider(name = "testGetTableCellTextByXpathCsv")
    public static Object[][] provideTestDataForGetTableCellTextByXpathCsv() {
        return CsvHandling.readCsvData("src/test/java/testData/GetTableCellTextByXpath.csv");
    }

    /**
     * Provides test data from a CSV file for the testVerifyTableCellTextCsv test case.
     *
     * @return The test data as a 2D array of objects.
     */
    @DataProvider(name = "testVerifyTableCellTextCsv")
    public static Object[][] provideTestDataForVerifyTableCellTextCsv() {
        return CsvHandling.readCsvData("src/test/java/testData/VerifyTableCellText.csv");
    }

    /**
     * Provides test data from an XML file for the testGetTableCellTextByXpathXml test case.
     *
     * @return The test data as a 2D array of objects.
     * @throws Exception If there is an error while reading the XML data.
     */
    @DataProvider(name = "testGetTableCellTextByXpathXml")
    public static Object[][] provideTestDataForGetTableCellTextByXpathXml() throws Exception {
        return XmlHandling.readXmlData("src/test/java/testData/GetTableCellTextByXpath.xml", "Get");
    }

    /**
     * Provides test data from an XML file for the testVerifyTableCellTextXml test case.
     *
     * @return The test data as a 2D array of objects.
     * @throws Exception If there is an error while reading the XML data.
     */
    @DataProvider(name = "testVerifyTableCellTextXml")
    public static Object[][] provideTestDataForVerifyTableCellTextXml() throws Exception {
        return XmlHandling.readXmlData("src/test/java/testData/VerifyTableCellText.xml", "Verify");
    }
}
