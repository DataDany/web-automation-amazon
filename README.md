#  Web Automation - Starter Project

## Overview
This is a Cucumber + Selenium Java starter project for a QA automation exercise. The project is designed to test the Amazon website, focusing on the search and add-to-cart features. It includes predefined and working functions, as well as functions with missing parameters or incomplete implementations that need to be completed.

## Features
- **Search Functionality**: Automates product searches on the Amazon website.
- **Add to Cart**: Automates adding products to the cart and verifying the cart contents.

## Pre-requisites
- Java 11+ installed.
- Maven installed.
## How to Run and Build

### Build the Project
1. Ensure you have Java 11+ and Maven installed on your system.
2. Navigate to the project root directory.
3. Build the project using the following Maven command:
   ```bash
   mvn clean install
   ```
## Run the Project
1. Clone the repository and navigate to the project root.
2. Run the following command:
   ```bash
   mvn test
   ```

## Task for Candidate
### Objective:
Complete the implementation of the search functionality and validation of search results in the provided Cucumber + Selenium Java project. Ensure the scenario in **search.feature** runs successfully and validates the expected behavior.  <hr></hr>
Detailed Steps:
1. Implement Search Functionality in **HomePage** :
    -  Complete the **HomePage** class by implementing a method to perform a product search.
    - The method should:
        - Accept a product name as a parameter.
        - Enter the product name into the search input field.
        - Trigger the search (e.g., by simulating pressing the Enter key or clicking the search button).
2. Implement Search Results Validation in **SearchResultsPage** :
    - Complete the **SearchResultsPage** class by implementing the following:
        - **getProductNames** method:
            - Extract and return a list of product names from the search results.
        - Additional methods as needed to retrieve product prices or other relevant details.
3. Update Step Definitions in **SearchSteps**:
    - Implement the **@When** step to perform a search using the **HomePage** class.
    - Implement the **@Then** step to validate the search results:
        - Ensure the results contain product names and prices.
        - Add assertions to verify that the product names and prices are not empty.
4. Create a New Scenario in **AddToCart.feature**:
    - Write a new Gherkin scenario to:
        - Search for a product.
        - Add the product to the cart.
        - Verify that the cart contains the correct product and quantity.
5. Implement Missing Logic for the New Scenario:
    - Add step definitions for the new scenario in a relevant step definition class.
    - Extend the **HomePage** and **SearchResultsPage** classes as needed to support adding a product to the cart and verifying cart contents.
6. Run and Validate Tests:
    - Ensure all scenarios in **search.feature** and **AddToCart.feature** pass successfully.
    - Debug and fix any issues encountered during test execution.<hr></hr>
### Deliverables:
- Fully implemented **HomePage** and **SearchResultsPage** classes.
- Updated **SearchSteps** class with working step definitions.
- A new scenario in **AddToCart.feature** with corresponding step definitions.
- All tests passing successfully when executed with **mvn test**.<hr></hr>
### Notes:
- Follow the Page Object Model (POM) design pattern.
- Use assertions to validate product names and prices in the search results.
- Ensure code is clean, well-documented, and adheres to best practices.
