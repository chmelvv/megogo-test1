1. Command to build project, run tests and see the test report:

```
git clone https://github.com/chmelvv/megogo-test1.git
cd megogo-test1
mvn clean test allure:serve
```

It runs tests and opens default browser with test report results.

2. Other variant:
```
   docker pull chmelvv/megogo-test:latest
   docker run chmelvv/megogo-test:latest
```
It will download docker image and run tests in the container.
Then you can see logs in the console and the test report in containers app/target/site/allure-maven-plugin/index.html
