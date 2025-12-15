package Tests;

import Utils.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Single-file REST-assured TestNG example that contains:
 * - setup (baseURI)
 * - helper methods: doGet, doPost, doDelete
 * - auth token fetch example
 * - simple tests: GET, POST, Auth+useToken
 * - DataProvider example for data-driven POST
 * - JSON Schema validation example (requires schema file in resources)
 * Change baseURI and endpoints according to your API.
 */
public class api extends BasePage {

    // Configure base URI here (change as per your API)
    private static final String BASE_URI = "https://api.salesbot.cloud";
    // private static final String BASE_URI = "https://api.yourdomain.com";

    @BeforeClass
    public void setUp() {
        // Base URI set karo (change to your API)
        RestAssured.baseURI = BASE_URI;

        // Optional: common config, timeouts, relaxed SSL etc.
        RestAssured.useRelaxedHTTPSValidation(); // if self-signed certs exist
    }

    // ---------------------------
    // Helper methods (single class)
    // ---------------------------

    /**
     * Simple GET helper
     */
    private Response doGet(String endpoint, Map<String, Object> cred) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .get(endpoint)
                .andReturn();
    }

    /**
     * Simple POST helper (body as String)
     */
    private Response doPost(String endpoint, String jsonBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .log().ifValidationFails()
                .when()
                .post(endpoint)
                .andReturn();
    }

    /**
     * Simple POST helper (body as Map -> will be serialized as JSON)
     */

    private Response doPost(String endPoint, Map<String, Object>bodyMap){
        return RestAssured.given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).body(bodyMap).
                log().ifValidationFails().
                when().post(endPoint).
                andReturn();
    }

    /**
     * Simple DELETE helper
     */
    private Response doDelete(String endpoint) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .delete(endpoint)
                .andReturn();
    }

    /**
     * Fetch token example (generic) - assumes API returns { "token": "..." } or { "access_token": "..." }
     * Modify to match your API response fields.
     */
    private String fetchAuthToken (String loginEndPoint, Map<String, Object>credential){
        Response resp = doPost(loginEndPoint, credential);
        int status = resp.getStatusCode();
        if (status == 200 || status == 201) {
            String token = resp.jsonPath().getString("access_token");
            if (token == null) token = resp.jsonPath().getString("token");
            if (token == null) {
                throw new RuntimeException("Token field not found in login response: " + resp.getBody().asString());
            }
            return token;
        } else {
            throw new RuntimeException("Failed to login. Status: " + status + " Body: " + resp.getBody().asString());
        }
    }

    @Test
    public void userLogin(){
        Map<String, Object> cred = new HashMap<>();
        cred.put("email", "gopalbariya@yopmail.com");
        cred.put("password", "Gopal@0303");

        Response response = doPost("/user/login/", cred);

        common.logPrint("Get /user/login/"+ response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertNotNull(response.jsonPath().getString("title"), "title should not be null");
    }

    @AfterClass
    public void tearDown() {
        // reset baseURI if you changed during tests
        RestAssured.reset();
    }
}
