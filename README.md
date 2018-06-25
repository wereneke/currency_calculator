# currency_calculator

- to get list of available currencies send GET : localhost:8080/currencies
- to get currencies calculation send 
  POST : localhost:8080/currencies/calculator?sell=[0currency_code]&buy=[1currency_code]&amount=[number]
- to get actual rates send localhost:8080/currencies/exchange
