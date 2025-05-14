# Test Automation Suite for Vehicle Registration Validation

This is an automation test suite designed to extract vehicle registration numbers from an input file and validate them using the test website detailed above.
It then compares the results generated on the website with those extracted from an output data file.

The suite is built using Java,Selenium webdriver and TestNG used to verify and validate car vehicle
details of the test site: https://car-checking.com/home.

##Prerequisites

- Java installed on target machine

- Browser automation tools: Selenium/WebDriver

- Build tool: Maven

- Testing framework: TestNG

- Chrome web browser installed on machine

## Installation

Clone this repository:

- git clone <repository clone url>


- Open the project in your chosen IDE:

- Ensure all maven dependencies are installed (If not re-sync the pom.xml file located in the root folder):


- Ensure you have a valid WebDriver setup (e.g. ChromeDriver for Selenium):

Ensure the test data files:
car_input - V6.txt
and
car_output - V6.txt
0are in the src > test >resources folder

Ensure the file path to each data file is correct in the RegistrationDataProvider class



to run the test suite

with maven: mvn test

or

run from your IDE

## Future Enhancements

Support for testing private registration plates.

