$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/LoginLogOutFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Perform Login and logout on Facebook",
  "description": "",
  "id": "perform-login-and-logout-on-facebook",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Perform Login and logout on Facebook",
  "description": "",
  "id": "perform-login-and-logout-on-facebook;perform-login-and-logout-on-facebook",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the \"\u003cBrowser\u003e\" and navigate to the web site facebook",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Make the \"\u003cLogin\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Validate the \"\u003cName\u003e\" in Main menu",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Make the logout on facebook and validate the text \"\u003cLogout\u003e\".",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "perform-login-and-logout-on-facebook;perform-login-and-logout-on-facebook;",
  "rows": [
    {
      "cells": [
        "Browser",
        "Login",
        "Password",
        "Name",
        "Logout"
      ],
      "line": 10,
      "id": "perform-login-and-logout-on-facebook;perform-login-and-logout-on-facebook;;1"
    },
    {
      "cells": [
        "Firefox",
        "11972418260",
        "test@12345",
        "Mateus Rossetti",
        "entre ou cadastre-se"
      ],
      "line": 11,
      "id": "perform-login-and-logout-on-facebook;perform-login-and-logout-on-facebook;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Perform Login and logout on Facebook",
  "description": "",
  "id": "perform-login-and-logout-on-facebook;perform-login-and-logout-on-facebook;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the \"Firefox\" and navigate to the web site facebook",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Make the \"11972418260\" and \"test@12345\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Validate the \"Mateus Rossetti\" in Main menu",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Make the logout on facebook and validate the text \"entre ou cadastre-se\".",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Firefox",
      "offset": 5
    }
  ],
  "location": "StepsDefinitionNew.navigate_web_site(String)"
});
formatter.result({
  "duration": 18109905500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11972418260",
      "offset": 10
    },
    {
      "val": "test@12345",
      "offset": 28
    }
  ],
  "location": "StepsDefinitionNew.Login(String,String)"
});
formatter.result({
  "duration": 4478851000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mateus Rossetti",
      "offset": 14
    }
  ],
  "location": "StepsDefinitionNew.validate_Main_menu(String)"
});
formatter.result({
  "duration": 156887800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "entre ou cadastre-se",
      "offset": 51
    }
  ],
  "location": "StepsDefinitionNew.logoutAndValidate(String)"
});
formatter.result({
  "duration": 2065789700,
  "status": "passed"
});
});