## Integrating Allure Reports with Gradle and JUnit 5

### Configuration

---

Allure Reports provide detailed and visually appealing test reports. Here's a quick guide on how to integrate them with Gradle and JUnit 5.

Include the Allure Gradle plugin and JUnit 5 adapter:

```groovy

plugins {
    id "io.qameta.allure" version "${allurePluginVersion}"
}

configurations {
    agent {
        canBeResolved = true
        canBeConsumed = true
    }
}

// other stuff

dependencies {
    agent "org.aspectj:aspectjweaver:$aspectJVersion"

    testImplementation enforcedPlatform("io.qameta.allure:allure-bom:${allureVersion}")
}

// other stuff

allure {
    autoconfigure = true
    aspectjweaver = true

    report {
        dependsOnTests.set(false) // needed to depend report generation on test run
    }
}

```

#### AspectJ and Allure: Why It's Needed

AspectJ allows Allure to capture detailed test runtime information. It "weaves" into your tests, intercepting events to track steps, parameters, and attachments beyond basic JUnit 5 data. Without AspectJ, Allure's step-by-step reporting and rich details wouldn't be possible.
Thanks to is we can use annotations like `@Step`, `@Attachment`, `@Parameter`, and other to enrich our test reports.

### Execution

---

First you need to run your JUnit 5 tests the same way as you would run them usually.

```shell
  ./gradlew test
```

Or you can make the reports phase dependent on test to make sure they are executed before the report generation. FOr that you can add the following in your `build.gradle` file.

```groovy
allure {
    report {
        dependsOnTests.set(true) // needed to depend report generation on test run
    }
}
```

In order to generate allure reports we can run the following command:

```shell
  ./gradlew allureReport
```

Or if you want to generate report and serve it (open in the browser):

```shell
  ./gradlew allureServe
```

### Allure GitHub Actions Integration



### Links

---

- [Allure Gradle Plugin](https://github.com/allure-framework/allure-gradle)
- [Allure JUnit 5 Integration](https://allurereport.org/docs/junit5/)
- [Allure GitHub Actions](https://allurereport.org/docs/guides/junit5-github-actions/)
- [Allure GitHub Actions integration](https://allurereport.org/docs/integrations-github/)

