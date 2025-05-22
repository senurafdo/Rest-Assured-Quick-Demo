

## How to run tests
1. Using IntelliJ IDEA
    * Go to Maven Profiles
    * Select `dev`, `qa`, `uat`, `pre-prod` or `prod` Maven Profile as the environment
    * Select the test classes on the `src/test/java` folder
    * Right-click and click on `Run`


2. Using Command Line
    * To run the smoke test suite against the UAT environment

      `mvn clean test -Puat,smoke-test`

    * To run the regression test suite against the QA environment

      `mvn clean test -Pqa,regression-test`

**Note**: By default, if no Maven profiles are selected, the tests will be executed on the `dev` environment.