# Playwright Test Automation Framework

An automated End-to-End (E2E) testing framework built for the [(RealWorld.show)](https://demo.realworld.show/) demonstration application. This project serves as a comprehensive testing architecture utilizing modern QA tools and best practices.

## Tech Stack
* **Language:** Java 25
* **Test Automation Tool:** Playwright (v1.49+)
* **Test Runner:** JUnit 5
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** Allure Report
* **CI/CD:** GitHub Actions (Ubuntu 22.04 / Headless execution)

## Target Application
The tests are executed against a social blogging site clone available at [demo.realworld.show](https://demo.realworld.show/). The framework currently covers core functionalities, including user authentication and content creation (articles), and is actively being expanded with new test scenarios on a daily basis.

## Project Architecture
The framework is designed for easy maintenance and scalability:
* **Page Object Model:** UI logic is strictly separated from test logic (organized into `pages` and `tests` packages).
* **Test Isolation:** Each test runs in a fresh, clean browser context to prevent flaky results.
* **CI/CD Readiness:** The framework dynamically recognizes Headless mode via environment variables, ensuring smooth remote execution.

## Running the Tests

### Prerequisites
* JDK 25 installed
* Apache Maven installed

### Local Execution (Terminal)
To run the entire test suite locally, execute the following command:
```bash
mvn clean test
```
### Allure Report (Terminal)
To see Allure report locally, execute the following command:
```bash
mvn allure:serve
```
