# currency_calculator

1 to get list of available currencies send GET : localhost:8080/currencies
2 to get currencies calculation send 
  POST : localhost:8080/currencies/calculator?sell=[0currency_code]&buy=[1currency_code]&amount=[number]
3 to get actual rates send localhost:8080/currencies/exchange
