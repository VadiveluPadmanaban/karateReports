package Feature;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
public class stepDef {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	@Given("^url 'http://services\\.groupkt\\.com/state/get/IND/all'$")
	public void url_http_services_groupkt_com_state_get_IND_all() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^method get$")
	public void method_get() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = request.when().get("http://services.groupkt.com/state/get/IND/all");
		System.out.println("response: " + response.prettyPrint());
	
	}

	@Then("^status (\\d+)$")
	public void status(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		json = response.then().statusCode(200);
	}
}
