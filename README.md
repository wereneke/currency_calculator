# currency_calculator
---

to use the app you need postman or curl or other tool for making api calls,
JDK 1.8, maven and git

---
to download enter to console
```
git clone https://github.com/wereneke/currency_calculator.git
```
and to run
```
cd currency_calculator
mvn package
java -jar currency_calculator0.0.1-SNAPSHOT.jar
```


- to get list of available currencies send GET : localhost:8080/currencies
- to get currencies calculation send 
  POST : localhost:8080/currencies/calculator?sell=[0currency_code]&buy=[1currency_code]&amount=[number]
- to get actual rates send GET : localhost:8080/currencies/exchange
