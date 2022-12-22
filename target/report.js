$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/FEATURE/productpurchase.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user launch url",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductPurchaseSteps.user_launch_url()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user search product",
  "keyword": "When "
});
formatter.match({
  "location": "ProductPurchaseSteps.user_search_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user select product",
  "keyword": "And "
});
formatter.match({
  "location": "ProductPurchaseSteps.user_select_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user add in the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductPurchaseSteps.user_add_in_the_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});