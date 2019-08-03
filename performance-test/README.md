# performance-test

## How to execute performance test

In `pom.xml`, enable target simulation by modifying `includes` configuration of `gatling-maven-plugin`.

And execute following:

```
mvn clean test-compile gatling:test
```
