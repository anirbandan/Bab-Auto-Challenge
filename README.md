## Automation Challenge

#### Selection of tool:
In this solution I have built an automation framework using Selenium (for web automation), Appium (for mobile automation) with Java, have used maven as build tool.

There is many well-known advantages of Selenium + Appium, but I have decided to use it as it serves the need of this project, and I am most comfortable with these tools as well.
Other advantages are:
- its an open source
- huge community support is available on the internet
- implementation is quite easy
- similar structure can be maintained for selenium & appium
- cross browser/platform/operating system support

For drawbacks, I would like to mention:
As I have used Java to build the framework, I had to write more lines of code, I could have easily used Robot Framework to implement the similar project with much less coding.

Also, sometimes if android test execution is failing the appium server is not getting stopped, although I implemented teardown method in after method annotation, still facing the issue to stop it sometimes in case of failure, as I did not get time to look into it thoroughly, I have used the below commands to kill the appium server for port 4723 manually:

`sudo lsof -i :4723`

`sudo kill -9 PID`

#### Assumptions:
I have assumed the system has all the requirements to execute the testcases

- All webdrivers are downloaded and added to the PATH
- Appium is correctly installed
- Android sdk is correctly installed
- I have developed the solution in MacOS, although it doesn't have dependency on operating system but didnt get chance to execute on other OS

## Instructions to run the tests and generate test reports

### To execute the test suites
- execute `mvn clean test` from repository root to execute all test suites 
- execute `mvn clean test -DsuiteXmlFile=web-tests-suite.xml` from repository root to execute test suites in web folder

Possible permitted values for parameter suiteXmlFile are:
- all-tests-suite.xml (default value)
- web-tests-suite.xml
- android-tests-suite.xml
- all-tests-suite-parallel.xml

### To generate allure test report
- execute `allure serve allure-results` from repository root to generate test report
