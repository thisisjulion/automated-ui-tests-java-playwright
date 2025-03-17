# Automated Tests for Funda.nl

This project is a **UI test automation framework** for the [Funda.nl](https://www.funda.nl/) website. It is built using **Java 21**, **Gradle**, **JUnit 5**, and **Playwright**, with **Allure Reports** for test reporting.

Example of the test execution report can be found here - [Test Report](https://thisisjulion.github.io/automated-tests-funda/).

My considerations regarding test assignment is described here - [Considerations.md](considerations.md)

## 📌 Project Overview

This framework enables automated UI testing for Funda.nl, providing:

- **Cross-browser testing** with Playwright.
- **Structured test automation framework** using JUnit 5.
- **Allure Reports** for detailed test execution insights.
- **Configurable test execution** via properties and environment variables.
- **Parallel execution support** for faster test runs.
- **CI/CD Integration** with GitHub Actions for automated test execution.

### 👤 Project Structure

```
automated-tests-funda/
│
├── .github/              # GitHub Actions workflows
│   └── workflows/        # Contains the CI/CD pipeline configuration for GitHub Actions
│       └── test.yml      # Defines the test workflow (CI/CD pipeline for testing)
│
│── src/
│   ├── main/java/        # Page objects, page components, and utilities
│   ├── test/java/        # Test cases, test steps and runners
│
├── gradle/               # Gradle wrapper and configuration files
│   └── wrapper/                # Gradle wrapper files
│
├── .gitignore            # Git ignore file
├── allure.md             # Read me file about allure reporting with useful links
├── considerations.md     # Read me file describing how technologies and tests were selected
├── build.gradle          # Gradle build configuration
├── gradle.properties     # Gradle properties file
├── settings.gradle       # Gradle settings file
└── README.md             # Read me file about project
```

---

## 🛠 Installation Guide

### ✅ Prerequisites

- **Java 21** (Ensure `JAVA_HOME` is set correctly)
- **Gradle Wrapper** (Included, no need for manual installation)
- **Google Chrome or Microsoft Edge** (For Playwright)

### 📅 Clone the Repository

```sh
git clone https://github.com/thisisjulion/automated-tests-funda.git
cd automated-tests-funda
```

### 🔧 Install Dependencies

```sh
./gradlew clean build
```

---

## ⚙️ Configuration

The project supports configuration through **gradle properties** or **environment variables**.

| Configuration Key              | Description                                       | Default Value |
|--------------------------------|---------------------------------------------------|---------------|
| `PLAYWRIGHT_BROWSER`           | Browser engine to use (chromium, firefox, webkit) | `chromium`    |
| `TARGET_ENVIRONMENT`           | Target environment (dev, staging, prod)           | `prod`        |
| `USER_BYPASS_CHECK_TOKEN`      | Token to bypass check robot check                 | -             |
| `PLAYWRIGHT_HEADLESS`          | Run browser in headless mode                      | `true`        |

---

## 🚀 Usage Instructions

### ✅ Running Tests

To execute all tests using default configuration:

```sh
USER_BYPASS_CHECK_TOKEN="***" ./gradlew test 
```

To run specific test class using default configuration:

```sh
USER_BYPASS_CHECK_TOKEN="***" ./gradlew test --tests "com.yourpackage.TestClassName"
```

To run specific tests based on tag providing all specific configuration values:
```sh
PLAYWRIGHT_BROWSER="chromium" TARGET_ENVIRONMENT="prod" USER_BYPASS_CHECK_TOKEN="***" PLR_HEADLESS="true" ./gradlew test -DincludeTags=smoke
```

### 📊 Generating Allure Reports

1. Run tests to generate Allure results:
   ```sh
   ./gradlew test
   ```
2. Serve the Allure report:
   ```sh
   ./gradlew allureServe
   ```

This will open a local server with the report.

---

## 💠 Continuous Integration (CI)

This project includes a **GitHub Actions** workflow for automated test execution.

- The workflow is located in `.github/workflows/ci.yml`
- To trigger it manually, go to **GitHub Actions > Run Workflow**.

The CI workflow includes the following steps:
1) Checkout Repository: Checks out the repository.
2) Set up JDK: Sets up Java 21 using Temurin distribution.
3) Run Tests: Executes the tests using Gradle.
4) Upload Allure Results: Uploads the Allure test results as an artifact.
5) Build and Publish Allure Report: Downloads the Allure results, builds the report, and publishes it to GitHub Pages.

TEST REPORT LINK - [Test Report](https://thisisjulion.github.io/automated-tests-funda/)
---

## 🔗 Links

- **Funda.nl**: [https://www.funda.nl](https://www.funda.nl)
- **Playwright Docs**: [https://playwright.dev](https://playwright.dev/)
- **Allure Reports**: [https://docs.qameta.io/allure](https://docs.qameta.io/allure)
- **GitHub Repository**: [automated-tests-funda](https://github.com/thisisjulion/automated-tests-funda)

---

🎯 *Feel free to contribute, suggest improvements, or raise issues!* 🚀
