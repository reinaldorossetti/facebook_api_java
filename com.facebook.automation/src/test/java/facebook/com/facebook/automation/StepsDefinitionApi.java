package facebook.com.facebook.automation;

import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import useful.Configuration;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class StepsDefinitionApi {

    Configuration conf = new Configuration();
    String site = conf.getConfig("host");
    String user = conf.getConfig("user");
    String token = conf.getConfig("token");


    @Then("^Validar se o post foi realizado \"([^\"]*)\" no facebook$")
    public void validar_existencia_do_post(String msn_post) throws Throwable {

        String postMSN = site+ "/" + user+ "/posts" + "?access_token="+ token;
        System.out.println(postMSN);
        Response res = given().
                when().
                contentType(ContentType.JSON).
                get(postMSN);

        System.out.println(res.getStatusCode());
        System.out.println(res.asString());
        assertThat(res.asString(), containsString(msn_post));
    }

    @Then("^Validar se o post foi deletado \"([^\"]*)\" no facebook$")
    public void validar_se_o_post_foi_deletado(String msn_post) throws Throwable {

        String postMSN = site+ "/" + user+ "/posts" + "?access_token="+ token;
        System.out.println(postMSN);
        Response res = given().
                when().
                contentType(ContentType.JSON).
                get(postMSN);

        System.out.println(res.getStatusCode());
        System.out.println(res.asString());
        assertThat(res.asString(), not(containsString("Error validating access token")));
        assertThat(res.asString(), not(containsString(msn_post)));
    }

}
