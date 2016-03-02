## Automated web tests using Serenity, Cucumber and Maven

A simple example of some BDD-style automated acceptance criteria, running against http://etsy.com. 

Run the tests like this:

```
mvn clean verify
```

By default, the tests run with PhantomJS, so you will need this installed. Otherwise, if you prefer Firefox, modify the serenity.properties file or run the tests like this:
```
mvn clean verify -Dwebdriver.driver=firefox
```

The reports will be generated in `target/site/serenity`.
