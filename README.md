-- Verisoft-Home Assignment

This project contains test automation code that demonstrates usage of Selenium WebDriver for automated testing of web pages. The main purpose is to showcase basic implementation of automated tests using Java and TestNG.

-- Project Structure

The project is structured as follows:

- **src/main/java/org/verisoft/:** Contains classes for handling browser interactions and utility functions.
- **src/main/java/org/verisoft/utils/:** Contains utility classes for handling CSV and XML data.
- **src/test/java/org/verisoft/classes/:** Contains test classes that use the `Table` class to perform automated tests.

-- Pre-requisites

- Java JDK (version 8 or higher)
- Maven (for executing tests and managing dependencies)
- EdgeDriver browser (for running tests using Edge WebDriver)

-- Installation and Execution

* Clone the repository from GitHub/Bitbucket:

    ```bash
    git clone https://github.com/SHULAMITY545/Verisoft-Home-assignment
    ```

** Navigate to the project root directory:

    ```bash
    cd verisoft
    ```

*** Execute the tests using Maven:

    ```bash
    mvn test
    ```

This command will execute the automated tests specified in the test classes using the TestNG framework.

## Notes

* This project uses Selenium EdgeDriver to automate interactions with web pages.
** Tests are executed using TestNG framework.
*** The project is designed to read data from CSV and XML files for test data input.
****To ensure smooth execution, please ensure the EdgeDriver WebDriver is compatible with your Edge browser version.
