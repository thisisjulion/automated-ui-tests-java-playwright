# Considerations for Test Assignment

## **1. Project Structure and Organization**

- The project follows a clean and modular structure, ensuring separation of concerns.
- Tests are categorized into smoke tests, with the potential for further categorization.
- Test steps are separated from test classes for better maintainability and reusability.
- Utilizes **JUnit 5** and **Playwright** for test automation.
- Implemented Allure for reporting.

## **2. Technology Stack**

- **Java 21** is used as the primary programming language.
- **Gradle** is used as the build tool
- **Playwright** is chosen for UI automation due to its speed and reliability.
- **JUnit 5** with tagged execution allows running specific test suites.
- **Allure Reports** for detailed test execution insights.

## **3. GitHub Actions Integration**

- Continuous Integration (CI) is implemented using GitHub Actions.
- Runs UI tests with Allure report.

## **4. Test Strategy**

- **Smoke Tests:** Cover essential workflows such as search functionality, contact form submission, map interaction, 
viewing of a single listing and verification of most important home page elements.
- **Tagging System:** Enables selective test execution via `-DincludeTags=smoke`.
- **Separation of Concerns:** Test logic is kept in test classes, while execution steps are implemented separately.

## **5. Challenges and Solutions**

- A challenge was faced during exploration of the Search page. It looks like the server side rendering approach is used to display the search results, which leaves no good ways to cover the search API itself.
As a result, tests were written on the UI level. However, future improvements will focus on testing the search 
mechanism at the API level for more efficient and reliable validation.
- The map object was hidden inside of JavaScript, so I was not able to interact with it. It looks like the map testing can be only done with deeper knowledge of the FE part. 
As a result a decision was made to test execution of Google Maps API endpoints during user interactions on the Map. 

## **6. Future Improvements**

- The plan is to extend the smoke suite to cover additional critical functionalities. 
- Improve readability of report by extending @Step annotations on test methods.
- Integration tests will be added to validate end-to-end scenarios across both the UI and the API. 
- Parallel execution will be implemented to speed up test runs. 
- Locale dependencies in locators will be removed by adopting more dynamic locator strategies. 
- The browser context will be made configurable to improve test flexibility. 
- Cucumber will be introduced for behavior-driven development (BDD), improving test readability.
- Additionally, a comprehensive approach to map testing will be implemented, 
focusing on verifying that listings are displayed correctly and that all relevant information is visible.
- Optimize CI workflow adding caching for static artifacts in order to improve the execution speed.

This document outlines key considerations and decisions taken during the test automation assignment.