# performance-test

## How to execute performance test

First, modify `src/test/java/karate-config.js` according to your environment.

Next, in `pom.xml`, enable target simulation by modifying `includes` configuration of `gatling-maven-plugin`.

And last, execute following:

```
mvn clean test-compile gatling:test
```
