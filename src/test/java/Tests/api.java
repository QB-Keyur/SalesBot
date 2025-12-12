//package Tests;
//
//import Utils.BasePage;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class api extends BasePage {
//    private String gnAccessToken;
//
//    public void log(String print) {
//        String message = "Step :: " + print;
//        if (message.startsWith("Step")) {
//            String[] msg = message.split("::");
//            Reporter.log("<br>" + msg[0].trim() + " "+ " : " + msg[1].trim());
//            System.out.println(msg[0].trim() + " "  + " : " + msg[1].trim());
//            //   logger.info(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//            System.out.flush();
//            //  Allure.step(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//        } else {
//            Reporter.log("<br>Message : " + message);
//            System.out.println("Message : " + message);
//            //     logger.info("Message : " + message);
//            System.out.flush();
//        }
//    }
//
//    @Test
//    public void api_Login_Test() {
//
//        common.logPrint("Step ::API Test Started....");
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        // Form data
//        String requestBody = "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"123456\"}";
//
//        // Perform POST request
//        Response response = request
//                .contentType("application/json")
//                .body(requestBody)
//                .post("/api/v1/brand/login");
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @BeforeMethod
//    public void setupAuthentication() {
//        log("Step :: Running Auto Login...");
//        // Set base URI for the API
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Prepare request headers and body
//        Response response = RestAssured.given()
//                .header("x-brand-id", "2023")
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Basic Og==")
//                .header("Cookie", "x-sticky-cookie=11caffaaabecdf19")
//                .body("{\n" +
//                        "    \"login_source\": 4,\n" +
//                        "    \"device_type\": 2,\n" +
//                        "    \"encrypted_device_id\": \"F5xWqNFcPg0oRlj1nQ3zwMDjhPy1WRSZaVJCP4AVZfxkQxS9cbmu8opVUVvQ4hSx\\n\",\n" +
//                        "    \"brand_id\": 1429,\n" +
//                        "    \"token\": \"vishal@begenuin.com\"\n" +
//                        "}")
//                .post("/api/v4/sso/autologin");
//
//        // Validate the response
//        Assert.assertEquals(response.getStatusCode(), 200, "Auto-login failed");
//        gnAccessToken = response.getHeader("Gn-Access-Token");
//        Assert.assertNotNull(gnAccessToken, "Token should not be null");
//        common.logPrint("Step :: Auto Login Successful. Token: " + gnAccessToken);
//    }
//
//
//
//    //    String gnAccessToken = "eyJraWQiOiJkLTE3MzI1MTMwNjMzNDYiLCJ0eXAiOiJKV1QiLCJ2ZXJzaW9uIjoiNSIsImFsZyI6IlJTMjU2In0.eyJpYXQiOjE3MzI1MTQ5MDYsImV4cCI6MTczMjYwMTI5Nywic3ViIjoiZTBmMGE1ZmItM2Q3My00MDhhLTljMDAtMWIxODJlMmMyNTJhIiwidElkIjoicHVibGljIiwicnN1YiI6ImUwZjBhNWZiLTNkNzMtNDA4YS05YzAwLTFiMTgyZTJjMjUyYSIsInNlc3Npb25IYW5kbGUiOiJiZjBiNWRiYi1mYjMyLTRhNjgtOWI3Mi04NGQyYzQyOTc3Y2IiLCJyZWZyZXNoVG9rZW5IYXNoMSI6IjI2NTZhZWFkOTNlYTM1MmI2MDNlNjg1OWUzYmJiNzRlM2I5ZjM0OWM2MzMwMGQzYTcxZDExNzIwNTY0Nzg2MGQiLCJwYXJlbnRSZWZyZXNoVG9rZW5IYXNoMSI6bnVsbCwiYW50aUNzcmZUb2tlbiI6bnVsbCwiaXNzIjoiaHR0cHM6Ly9icmFuZHMtYXBpLnFhLmJlZ2VudWluLmNvbS9hcGkvdjEvYXV0aCIsInN0LWV2Ijp7InYiOmZhbHNlLCJ0IjoxNzMyNTE0ODk3Mjg1fSwic3Qtcm9sZSI6eyJ2IjpbXSwidCI6MTczMjUxNDg5NzI4OH0sInN0LXBlcm0iOnsidiI6W10sInQiOjE3MzI1MTQ4OTcyODh9LCJiY2MiOnsiYnJhbmRfaWQiOjEsInVzZXJfaWQiOiI2NWNiMTU4ZjI2ZjBjMDUzYTVhZDg0ZmEifX0.PO4n5vG5HZgGaa-tawwjGvBxR0ATbUuqfIlhkP2Qf5ZZBG-tjTVp5jmJnTPps9VnlAjlEoyB2bHv4tqlvYwl-drlpqRDZVJfHCUeWX_kAwaaDMrKmCheSCYxrKREZCtRdzp6WGU1mHJEKPFZ9ZN7GH815GkwY2D96TPaIhl76lsCsAAJ35lq0abneTqPIc47nDgWfMoiuHoDAbbFoHrjouvUQqJdT_R13Xpru8mDZA-7JKkgLb_eVh3zeIlI2cNJeFi6uPuM6a4kcyzkfPxpurqWOOI3j-wrnvDtissNifnbRxaVV-J_r-NvIsVTd3XEnSovYeKvngW3FZE-lpad4w";
//    public void pause(int sec) {
//        try {
//            Thread.sleep(1000 * sec);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void api_Demo_Brand_Profile_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/detail?subdomain=ankpal"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Demo_Brand_Ragistration_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed
//
//        //Print response
//        common.logPrint("Response is: "+response.getBody().asString());
//
//        // Print response
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    //https://brands-api.qa.begenuin.com/api/v1/brand/registration/validate_email?email=6723355661477.1720075087722@ai_user.begenuin.com
//    @Test
//    public void api_Demo_Brand_Ragistration_Email_Validation_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/registration/validate_email?email=6723355661477.1720075087722@ai_user.begenuin.com"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    //https://brands-api.qa.begenuin.com/api/v1/brand/request_reset_password_email?email=sanketparekh22@begenuin.com
//    @Test
//    public void api_Demo_Reset_Password_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/request_reset_password_email?email=sanketparekh22@begenuin.com"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//    //https://brands-api.qa.begenuin.com/api/v1/brand/invitations
//
//    @Test
//    public void apiDemoBrandInvitationTest() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        // Create request specification with token as a query parameter
//        RequestSpecification request = RestAssured.given();
//
//        Response response = request
//                .contentType("application/json").header("x-encrypted-token","VWa63FEg9VTG9rnlWsxFzmzpwHBNx4E6OUfFBFASW0Q7P369JqDoytWqXjSL1xAipqeSwu5cOzV/IWN0mzyqJA==")
//                .get("/api/v1/brand/invitations");
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//
//    //https://brands-api.qa.begenuin.com/api/v1/community/guidelines
//    @Test
//    public void api_Community_Guideline_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        String baseURL = "https://nodejs.qa.begenuin.com";
//        // Create request specification
//        RequestSpecification request = RestAssured.given().baseUri(baseURL).auth().oauth2(gnAccessToken);
//
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/guidelines"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode()); common.logPrint("Step ::Response Body: " + response.getBody().asString());
//
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    //https://brands-api.qa.begenuin.com/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type
//
//    @Test
//    public void api_Community_Member_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        request.contentType("application/json");
//        //request.header("x-auth-token", authToken);
//        Response response = request
//                .get("/api/v3/community/members?community_id=7a4ecbc7-cebe-4bf3-b0f8-c4a6bac1b52c"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/loops?is_loop_names_only=true"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_By_User_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/communities_by_user?user_id=e1352ead-8b6d-41fb-b7d2-d90ce3c0d298&user_community_joined=true&limit=10&query_string=test"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Brand_Search_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/search/brands?query_string=sanketuser69@yopmail.com&is_brand_profile_email=true"); // Adjusted endpoint if needed
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community?community_id=9f7e112b-b459-4838-a92c-a2577c100435"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Handle_Suggestion_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/handle_suggestion?name=Vishal Nirmal"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Requests_Test() {
//        common.logPrint("Step ::Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("api/v3/community/requests?community_id=7a4ecbc7-cebe-4bf3-b0f8-c4a6bac1b52c"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Pagination_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Subscribers_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=2c62b9c8-33c5-49ce-babb-41f6a92dabb0"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Collaborators_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_collaborators?chat_id=bd01f9e7-2d79-4e23-a0a0-5e232106690d"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Posts_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Loop_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/loops?community_id=0061a029-f8a2-405d-bf0c-d45a66961550&slug=guns-and-society"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Check_User_Exists_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/check_user_exists?email=dhruv@begenuin.com&brand_id=1"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Mentions_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//
//        // No query parameters needed for this test
//        // Adjust the endpoint path as necessary for the test
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/mentions?community_id=c4bdf848-22ec-468c-b264-2330fce70dcd&query_string=shubh"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Fonts_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/fonts"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Get_Sign_URL_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/signed_url?content_type=text/csv&path=temp_video/659e9bb4-fc10-4dce-a856-20bff0e9f387_1632915580779.csv"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Gets_Brand_User_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand_users?manage_user_type=3&limit=50"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Subdomain_Suggestion_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Brand_Details_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Resend_Email_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand/resend_email"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Get_Dynamic_CBR_And_DataTest() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/brand_details?brand_id=1&completed_onboarding_steps=true"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Nick_Name_Suggestion_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/suggestion/username?nickname=san"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Validate_Handle_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/validate_handle?handle=hidf"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Get_Comment_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/comment?limit=1&page=1&query_string=prod&sort_by=posted_in&sort_dir=asc"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Get_Payments_Method_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/payment-methods?limit=3"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Transiction_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/transactions?page=1&limit=1"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Get_Wallet_Balance_Test() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/wallet-balance"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Member_Tsest() {
//        common.logPrint("Step ::API Test Started....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        request.contentType("application/json");
//        //request.header("x-auth-token", authToken);
//        Response response = request
//                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type"); // Adjusted endpoint if needed
//
//        // Print response
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
//        pause(15);
//    }
//
//    @Test
//    public void api_Login_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started....");
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//
//        // List of negative test cases
//        String[] negativeTestCases = {
//                "{\"email\":\"\", \"password\":\"123456\"}",
//                "{\"email\":\"invalidemail\", \"password\":\"123456\"}",
//                "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"\"}",
//                "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"wrongpassword\"}",
//                "{\"email\":\"nonexistent@begenuin.com\", \"password\":\"123456\"}",
//                "{}"
//        };
//
//        for (String requestBody : negativeTestCases) {
//            common.logPrint("Step ::Testing with request body: " + requestBody);
//
//            // Perform POST request
//            Response response = request
//                    .contentType("application/json")
//                    .body(requestBody)
//                    .post("/api/v1/brand/login");
//
//            // Print response
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            common.logPrint("Step ::Response Body: " + response.getBody().asString());
//
//            // Validate response code and ensure it's not 200 for negative scenarios
//            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code: 200");
//            common.logPrint("Step ::Test Passed for request body: " + requestBody);
//        }
//        common.logPrint("Step ::API Negative Test Completed.");
//    }
//
//    @Test
//    public void api_Demo_Brand_Profile_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Brand Profile...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        String[] invalidSubdomains = {"", "invalid_subdomain", "<script>alert('hack')</script>"};
//
//        for (String subdomain : invalidSubdomains) {
//            Response response = request
//                    .contentType("application/json")
//                    .get("/api/v1/brand/detail?subdomain=" + subdomain);
//
//            common.logPrint("Step ::Testing with subdomain: " + subdomain);
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
//        }
//    }
//
//    @Test
//    public void api_Demo_Brand_Registration_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Brand Registration...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        String[] invalidNames = {"", "a", "name_with_special!@#$%", "<script>alert('hack')</script>"};
//
//        for (String name : invalidNames) {
//            Response response = request
//                    .contentType("application/json")
//                    .get("/api/v1/brand/registration/subdomain_suggestion?name=" + name);
//
//            common.logPrint("Step ::Testing with name: " + name);
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
//        }
//    }
//
//    @Test
//    public void api_Demo_Brand_Registration_Email_Validation_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Email Validation...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        String[] invalidEmails = {"", "plainaddress", "missingdomain@", "missingat.com"};
//
//        for (String email : invalidEmails) {
//            Response response = request
//                    .contentType("application/json")
//                    .get("/api/v1/brand/registration/validate_email?email=" + email);
//
//            common.logPrint("Step ::Testing with email: " + email);
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            Assert.assertEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
//        }
//    }
//
//    @Test
//    public void api_Demo_Reset_Password_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Reset Password...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        String[] invalidEmails = {"", "invalidemail", "<script>alert('hack')</script>", "nonexistent@domain.com"};
//
//        for (String email : invalidEmails) {
//            Response response = request
//                    .contentType("application/json")
//                    .get("/api/v1/brand/request_reset_password_email?email=" + email);
//
//            common.logPrint("Step ::Testing with email: " + email);
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
//        }
//    }
//
//    @Test
//    public void api_Demo_Brand_Invitation_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Brand Invitation...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test with invalid token
//        String[] invalidTokens = {"", "invalidtoken", "<script>alert('hack')</script>"};
//
//        for (String token : invalidTokens) {
//            Response response = request
//                    .contentType("application/json")
//                    .header("x-encrypted-token", token)
//                    .get("/api/v1/brand/invitations");
//
//            common.logPrint("Step ::Testing with token: " + token);
//            common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
//        }
//    }
//
//    @Test
//    public void api_Community_Guideline_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Community Guidelines...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without access token
//        Response responseWithoutToken = request
//                .contentType("application/json")
//                .get("/api/v1/community/guidelines");
//
//        common.logPrint("Step ::Response Status Code Without Token: " + responseWithoutToken.getStatusCode());
//        Assert.assertNotEquals(responseWithoutToken.getStatusCode(), 200, "Unexpected Status Code 200");
//    }
//
//    @Test
//    public void api_Community_Member_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Community Members...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid community_id
//        String[] invalidCommunityIds = {"", "invalid-id", "<script>alert('hack')</script>"};
//        for (String communityId : invalidCommunityIds) {
//            Response responseInvalidId = request
//                    .header("Authorization", "Bearer " + gnAccessToken)
//                    .contentType("application/json")
//                    .get("/api/v1/community/members?community_id=" + communityId + "&limit=2&sort_dir=desc&sort_by=type");
//
//            common.logPrint("Step ::Testing with invalid community_id: " + communityId);
//            common.logPrint("Step ::Response Status Code: " + responseInvalidId.getStatusCode());
//            Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
//        }
//
//        // Test with invalid limit parameter
//        Response responseInvalidLimit = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=-1&sort_dir=desc&sort_by=type");
//
//        common.logPrint("Step ::Response Status Code for invalid limit: " + responseInvalidLimit.getStatusCode());
//        Assert.assertNotEquals(responseInvalidLimit.getStatusCode(), 200, "Unexpected Status Code 200 for invalid limit");
//    }
//
//    @Test
//    public void api_Loop_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Loops...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("/api/v1/loops?is_loop_names_only=true");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid query parameter
//        Response responseInvalidParam = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/loops?is_loop_names_only=invalid");
//
//        common.logPrint("Step ::Response Status Code with Invalid Query Param: " + responseInvalidParam.getStatusCode());
//        Assert.assertNotEquals(responseInvalidParam.getStatusCode(), 200, "Unexpected Status Code 200 for invalid query parameter");
//    }
//
//    @Test
//    public void api_By_User_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Communities by User...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("/api/v1/communities_by_user?user_id=e1352ead-8b6d-41fb-b7d2-d90ce3c0d298&user_community_joined=true&limit=10&query_string=test");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid user_id
//        Response responseInvalidUserId = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/communities_by_user?user_id=invalid-id&user_community_joined=true&limit=10&query_string=test");
//
//        common.logPrint("Step ::Response Status Code with Invalid User ID: " + responseInvalidUserId.getStatusCode());
//        Assert.assertNotEquals(responseInvalidUserId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid user_id");
//    }
//
//    @Test
//    public void api_Brand_Search_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Brand Search...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("/api/v1/search/brands?query_string=sanketuser69@yopmail.com&is_brand_profile_email=true");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid query_string
//        Response responseInvalidQuery = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/search/brands?query_string=invalid-query&is_brand_profile_email=true");
//
//        common.logPrint("Step ::Response Status Code with Invalid Query String: " + responseInvalidQuery.getStatusCode());
//        Assert.assertNotEquals(responseInvalidQuery.getStatusCode(), 200, "Unexpected Status Code 200 for invalid query string");
//    }
//
//    @Test
//    public void api_Community_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Community...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("/api/v1/community?community_id=9f7e112b-b459-4838-a92c-a2577c100435");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid community_id
//        Response responseInvalidId = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/community?community_id=invalid-id");
//
//        common.logPrint("Step ::Response Status Code with Invalid Community ID: " + responseInvalidId.getStatusCode());
//        Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
//    }
//
//    @Test
//    public void api_Community_Handle_Suggestion_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Community Handle Suggestion...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test with missing name parameter
//        Response responseMissingName = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/community/handle_suggestion");
//
//        common.logPrint("Step ::Response Status Code for Missing Name Param: " + responseMissingName.getStatusCode());
//        Assert.assertNotEquals(responseMissingName.getStatusCode(), 200, "Unexpected Status Code 200 for missing name parameter");
//
//    }
//
//    @Test
//    public void api_Community_Requests_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started for Community Requests...");
//
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//        RequestSpecification request = RestAssured.given();
//
//        // Test without Authorization header
//        Response responseWithoutAuth = request
//                .contentType("application/json")
//                .get("api/v1/community/requests?community_id=7d5e52e3-1b79-4fae-8e3f-764c34a1cc97");
//
//        common.logPrint("Step ::Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
//        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");
//
//        // Test with invalid community_id
//        Response responseInvalidId = request
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("api/v1/community/requests?community_id=invalid-id");
//
//        common.logPrint("Step ::Response Status Code with Invalid Community ID: " + responseInvalidId.getStatusCode());
//        Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
//    }
//
//    @Test
//    public void api_Loop_Pagination_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiLoopPaginationTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Invalid Pagination Parameters
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Scenario 1: Invalid pagination parameters
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=-1&limit=0&sort_by=invalid_field");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc");
//        common.logPrint("Step ::Response Status Code (No Auth): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (No Auth): " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Subscribers_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiLoopSubscribersTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Invalid Chat ID
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Scenario 1: Invalid chat_id
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=invalid-id");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=2c62b9c8-33c5-49ce-babb-41f6a92dabb0");
//        common.logPrint("Step ::Response Status Code (No Auth): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (No Auth): " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Collaborators_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiLoopCollaboratorsTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Invalid Chat ID
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Scenario 1: Invalid chat_id
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_collaborators?chat_id=invalid-id");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_collaborators?chat_id=bd01f9e7-2d79-4e23-a0a0-5e232106690d");
//        common.logPrint("Step ::Response Status Code (No Auth): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (No Auth): " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//
//        pause(15);
//    }
//
//    @Test
//    public void api_Loop_Posts_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiLoopPostsTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Scenario 1: Invalid pagination parameters
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=-1&limit=0&sort_by=loop&sort_dir=asc");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc");
//        common.logPrint("Step ::Response Status Code (No Auth): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (No Auth): " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//
//        pause(15);
//    }
//
//    @Test
//    public void api_Community_Loop_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiCommunityLoopNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing community_id
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/community/loops");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step ::Response Body: " + response.getBody().asString());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Invalid Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/community/loops?community_id=invalid-id");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Check_User_Exists_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiCheckUserExistsNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid email parameter
//        common.logPrint("Step ::Authorization Token: " + gnAccessToken);
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/check_user_exists?email=invalid-email&brand_id=1");
//
//        common.logPrint("Step ::Response Status Code (Invalid email): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (Invalid email): " + response.getBody().asString());
//
//        // Check for 200 status code
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected success status code for invalid email.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/check_user_exists?email=dhruv@begenuin.com&brand_id=1");
//
//        common.logPrint("Step ::Response Status Code (Missing Authorization): " + response.getStatusCode());
//        common.logPrint("Step ::Response Body (Missing Authorization): " + response.getBody().asString());
//
//        // Check for 401 status code
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Mentions_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiMentionsNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing query_string parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/mentions");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Invalid Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/mentions?query_string=test");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Fonts_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiFontsNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid Authorization header
//        Response response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/fonts");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Get_Sign_URL_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetSignURLNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid content_type parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/signed_url?content_type=invalid&type&path=temp_video/invalid.csv");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/signed_url?content_type=text/csv&path=temp_video/invalid.csv");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Gets_Brand_User_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetSBrandUserNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid manage_user_type
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/brand_users?manage_user_type=invalid&limit=50");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//
//        // Scenario 2: Missing Authorization header
//        response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/brand_users?manage_user_type=3&limit=50");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Subdomain_Suggestion_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiSubdomainSuggestionNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing query parameter `name`
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/brand/registration/subdomain_suggestion");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Brand_Details_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiBrandDetailsNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid Authorization token
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer INVALID_TOKEN")
//                .contentType("application/json")
//                .get("/api/v1/brand_details?brand_id=1&completed_onboarding_steps=true");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Resend_Email_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiResendEmailNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing Authorization header
//        Response response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/brand/resend_email");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Get_Dynamic_CBRand_Data_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetDynamicCBRandDataNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing `brand_id` parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/brand_details?completed_onboarding_steps=true");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Nick_Name_Suggestion_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiNickNameSuggestionNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Empty `nickname`
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/suggestion/username?nickname=");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Validate_Handle_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiValidateHandleNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing `handle` parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/community/validate_handle");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Get_Comment_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetCommentNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid `limit` parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/comment?limit=-1&page=1&query_string=prod&sort_by=posted_in&sort_dir=asc");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Get_Payments_Method_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetPaymentsMethodNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Missing Authorization header
//        Response response = RestAssured.given()
//                .contentType("application/json")
//                .get("/api/v1/payment-methods?limit=3");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Transaction_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiTransactionNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid `page` parameter
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)
//                .contentType("application/json")
//                .get("/api/v1/transactions?page=-1&limit=1");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
//    }
//
//    @Test
//    public void api_Get_Wallet_Balance_Negative_Test() {
//        common.logPrint("Step ::API Negative Test Started - apiGetWalletBalanceNegativeTest....");
//
//        // Base URI
//        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
//
//        // Scenario 1: Invalid Authorization token
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer INVALID_TOKEN")
//                .contentType("application/json")
//                .get("/api/v1/wallet-balance");
//        common.logPrint("Step ::Response Status Code: " + response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
//    }
//
//    @Test
//    public void api_Contact_Us_Test() {
//        common.logPrint("Step :: API Test Started....");
//
//        String baseURL = "https://nodejs.qa.begenuin.com"; // Base URL for the API
//
//        // Define the query parameters for the contact-us API
////        String message = "This is test complaint for video";
////        String type = "contact_us";
////        String email = "rahul+1@perfectqaservices.com";
//
//        // Create request specification with OAuth2 authentication
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/contact-us?message=This is test complaint for video&type=contact_us&email=rahul+1@perfectqaservices.com"); // Adjust the endpoint if necessary
//
//        // Log the response status code and body
//        common.logPrint("Step :: Response Status Code: " + response.getStatusCode());
//        common.logPrint("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//        // Optional: Pause for debugging or observation (15 seconds)
//        pause(15);
//    }
//
//    @Test
//    public void api_Update_Notification_Settings_Test() {
//        common.logPrint("Step :: API Test Started....");
//
//        // Base URL for the API
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
////        // Define the JSON payload for the request
////        String requestBody = """
////        {
////            "conversation_alarm_notification": false,
////            "message_notification": false,
////            "roundtable_notification": false
////        }""";
//
//        // Create request specification
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
////        // Send the PATCH request
////        Response response = request
////                .contentType("application/json")
////                .body(requestBody)
////                .patch("/api/v3/users/update_notification_settings"); // Endpoint for the API
//
////        // Log the response status code and body
////        common.logPrint("Step :: Response Status Code: " + response.getStatusCode());
////        common.logPrint("Step :: Response Body: " + response.getBody().asString());
////
////        // Assert the response status code is 200 (OK)
////        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
////
////        // Optional: Pause for debugging or observation (15 seconds)
////        pause(15);
////    }
//
//    @Test
//    public void api_Get_User_Settings_Test() {
//        System.out.println("Step :: API Test Started for GET User Settings....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Send the GET request
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/users/settings");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//        // Optional: Additional validation (e.g., checking response JSON fields)
//        String responseBody = response.getBody().asString();
//        Assert.assertTrue(responseBody.contains("settings"), "Response does not contain expected 'settings' field.");
//    }
//
//    @Test
//    public void api_Get_Latest_Force_Updated_Version_Test() {
//        System.out.println("Step :: API Test Started for GET Latest Force Updated Version....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Send the GET request
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/latest_force_updated_version");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_ThirdParty_Auth_Test() {
//        System.out.println("Step :: API Test Started for Third-Party Authentication....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.contentType("application/json");
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"api_key\": \"814be4c5aaae50e018b924ae959784e6fd4100893f0384a7\",\n" +
//                "  \"api_secret\": \"09c6acb39484c937cc8f2ec3b8491d70\"\n" +
//                "}";
//
//        // Send the POST request
//        Response response = request
//                .body(requestBody)
//                .post("/api/thirdparty/auth");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK) or other expected code
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Send_Download_Link_Test() {
//        System.out.println("Step :: API Test Started for Sending Download Link....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.contentType("application/json");
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"mobile\": \"+919182738291\",\n" +
//                "  \"email\": \"dhruv123@gmail.com\"\n" +
//                "}";
//
//        // Send the POST request
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/send_download_link");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Get_Email_Verification_Status_Test() {
//        System.out.println("Step :: API Test Started for GET Email Verification Status....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);  // Add Bearer token for authentication
//
//        // Example email to check verification status
//
//        // Send the GET request with the email as a query parameter
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/email_verification_status");  // Pass email as query parameter
//
//        // Log the response status code and body for debugging
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Notification_Count_Test() {
//        System.out.println("Step :: API Test Started for GET Notification Count....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";  // Replace with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);  // Add Bearer token for authentication
//
//        // Send the GET request to fetch notification count
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/notification_count");  // The endpoint path
//
//        // Log the response status code and body for debugging
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Delete_User_Logout_Test() { //delete
//        System.out.println("Step :: API Test Started for DELETE User Logout....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";  // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);  // Add Bearer token for authentication
//
//        // Send the DELETE request to logout the user
//        Response response = request
//                .contentType("application/json")
//                .delete("/api/v3/users/logout");  // The endpoint path
//
//        // Log the response status code and body for debugging
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//        // Optional: Additional validation (e.g., checking response JSON fields)
//        String responseBody = response.getBody().asString();
//        Assert.assertTrue(responseBody.contains("message"), "Response does not contain expected 'message' field.");
//    }
//
//    @Test
//    public void api_Get_User_Devices_Test() {
//        System.out.println("Step :: API Test Started for GET User Devices....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";  // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);  // Add Bearer token for authentication
//
//        // Send the GET request to fetch user devices
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/users/devices");  // The endpoint path
//
//        // Log the response status code and body for debugging
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Explore_New_Test() {
//        System.out.println("Step :: API Test Started for GET Explore New....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";  // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);  // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/explore/new");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Get_Community_Categories_Test() {
//        System.out.println("Step :: API Test Started for GET Community Categories....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community_categories");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Get_Community_Details_Test() {
//        System.out.println("Step :: API Test Started for GET Community Details....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameters
//        request.queryParam("community_id", "866659e1-86bb-4dea-9df8-0b62dbdd6bff");
//        request.queryParam("slug", "product-creators");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Community_Details_With_Params_Test() {
//        System.out.println("Step :: API Test Started for GET Community Details with Query Parameters....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameters
//        request.queryParam("chat_id", "4cc7e020-50df-4763-8efa-6de41299eb1e");
//        request.queryParam("guidelines", "true");
//        request.queryParam("welcome_loop_id", "true");
//        request.queryParam("mini_object", "true");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/details");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Communities_By_UserId_Test() {
//        System.out.println("Step :: API Test Started for GET Communities by User ID....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameter
//        request.queryParam("user_id", "1df5cf1e-14f7-4c2d-a0a3-904c6b5763e6");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Get_Home_Communities_By_UserId_Test() { //delete
//        System.out.println("Step :: API Test Started for GET Home Communities by User ID....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameter
//        request.queryParam("user_id", "7a16cd10-5991-4860-a9d3-7af791cf1dea");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/home/communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_V4_Home_Communities_By_UserId_Test() {
//        System.out.println("Step :: API Test Started for GET V4 Home Communities by User ID....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameter
//        request.queryParam("user_id", "7a16cd10-5991-4860-a9d3-7af791cf1dea");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v4/home/communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Category_List_Test() {
//        System.out.println("Step :: API Test Started for GET Category List....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/category/list");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Delete_Community_Test() {
//        System.out.println("Step :: API Test Started for DELETE Community....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Define the community_id parameter
//        String communityId = "539db55a-7d66-4fc5-8b00-c3d13fa4ef43";
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .delete("/api/v3/community?community_id=" + communityId);
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Community_Videos_Test() { //delete
//        System.out.println("Step :: API Test Started for GET Community Videos....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define the query parameters
//        String communityId = "0061a029-f8a2-405d-bf0c-d45a66961550";
//        String lastVideoId = "e5be2cc1-934d-4edf-99d0-9b8565762914";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .queryParam("community_id", communityId)
//                .queryParam("last_video_id", lastVideoId)
//                .get("/api/v3/home/community_videos");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_v4_Community_Videos_Test() {
//        System.out.println("Step :: API Test Started for GET Community Videos....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define the query parameters
//        String communityId = "0061a029-f8a2-405d-bf0c-d45a66961550";
//        String lastVideoId = "e5be2cc1-934d-4edf-99d0-9b8565762914";
//
//        // Create the request (no authorization required)
//        RequestSpecification request = RestAssured.given();
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .queryParam("community_id", communityId)
//                .queryParam("last_video_id", lastVideoId)
//                .get("/api/v4/home/community_videos");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Communities_By_Category_Test() {
//        System.out.println("Step :: API Test Started for GET Communities by Category....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";  // Replace {{baseUrl}} with the actual base URL
//
//        // Define the category_id parameter
//        String categoryId = "1";  // The category ID you want to use
//
//        // Create the request with Authorization header
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .queryParam("category_id", categoryId)
//                .get("/api/v3/communities_by_category");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Trending_Community_Categories_Test() {
//        System.out.println("Step :: API Test Started for GET Trending Community Categories....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/trending/community_categories");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Leave_Community_Test() {
//        System.out.println("Step :: API Test Started for Leaving Community....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Define the community_id parameter
//        String communityId = "4ec512f2-9d5d-4db1-958c-ca7e7d93b761";
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .delete("/api/v3/community/leave?community_id=" + communityId);
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Featured_Communities_Test() {
//        System.out.println("Step :: API Test Started for GET Featured Communities....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/featured_communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Trending_Categories_Communities_Test() {
//        System.out.println("Step :: API Test Started for GET Trending Categories and Communities....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/trending/categories_communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_Global_Search_Recent_Test() {
//        System.out.println("Step :: API Test Started for POST Global Search Recent....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Define the request payload
//        String requestBody = "{ \"type\": 3, \"search_content_id\": \"2f6f0a37-9d0e-4b53-8037-ef41b1c1a921\" }";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .body(requestBody)
//                .post("/api/v3/global_search/recent");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Global_Search_Recent_Test() {
//        System.out.println("Step :: API Test Started for GET Global Search Recent....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/global_search/recent");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Delete_All_Global_Search_Recent_Test() {
//        System.out.println("Step :: API Test Started for DELETE All Global Search Recent....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the DELETE request to the endpoint with the query parameter
//        Response response = request
//                .contentType("application/json")
//                .delete("/api/v3/global_search/recent?delete_all=true");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_Search_Suggestions_Test() {
//        System.out.println("Step :: API Test Started for POST Search Suggestions....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json");
//
//        // Define the request body
//        String requestBody = """
//        {
//          "query_string": "sanket parekh",
//          "size": 5,
//          "filter_types": [
//            {
//              "type": 4,
//              "exclude_by": {
//                "chat_ids": [
//                  "6b93b00e-8182-409d-8aef-e304e684ecd1"
//                ]
//              }
//            }
//          ]
//        }
//    """;
//
//        // Send the POST request
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/search/suggestions");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Feed_Menu_Test() {
//        System.out.println("Step :: API Test Started for GET Feed Menu....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request
//        Response response = request.get("/api/v4/feed_menu");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_v3_Feed_Menu_Test() { //delete
//        System.out.println("Step :: API Test Started for GET Feed Menu....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request
//        Response response = request.get("/api/v3/feed_menu");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_Get_Profile_Test() {
//        System.out.println("Step :: API Test Started for POST Get Profile....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com   "; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set Content-Type header
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"user_id\": \"b92c8231-9dbe-437a-9b97-bacbf9a33945\"\n" +
//                "}";
//
//        // Send the POST request
//        Response response = request.body(requestBody).post("/api/v3/users/get_profile");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_Update_Email_Test() {  //delete
//        System.out.println("Step :: API Test Started for POST Update Email....");
//
//        // Generate a unique email address
//        String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set Content-Type header
//
//        // Define the request body with the unique email
//        String requestBody = "{\n" +
//                "  \"user\": {\n" +
//                "    \"email\": \"" + uniqueEmail + "\",\n" +
//                "    \"marketing_subscription\": false\n" +
//                "  }\n" +
//                "}";
//
//        // Send the POST request
//        Response response = request.body(requestBody).post("/api/v3/users/update_email");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//        // Log the unique email used for the test
//        System.out.println("Step :: Email used for update: " + uniqueEmail);
//    }
//
//
//    @Test
//    public void api_Post_Contact_Sync_Test() {
//        System.out.println("Step :: API Test Started for POST Contact Sync....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set Content-Type header
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"contacts\": [\n" +
//                "    {\n" +
//                "      \"firstName\": \"Steve\",\n" +
//                "      \"middleName\": \"Paul\",\n" +
//                "      \"lastName\": \"Jobs\",\n" +
//                "      \"phoneNumber\": \"919726240815\",\n" +
//                "      \"meta\": {\n" +
//                "        \"anyOtherLabel\": \"anyOtherInfo\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//
//        // Send the POST request
//        Response response = request.body(requestBody).post("/api/v3/users/contact-sync");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Mini_Profile_Test() {
//        System.out.println("Step :: API Test Started for GET Mini Profile....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with the actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/users/mini_profile");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Check_New_Updates_Test() {
//        System.out.println("Step :: API Test Started for GET Check New Updates....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com   "; // Replace {{baseUrl}} with the actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/users/check_new_updates");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Check_New_Message_Test() {
//        System.out.println("Step :: API Test Started for GET Check New Message....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with the actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/users/check_new_message");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Validate_Nickname_Test() {
//        System.out.println("Step :: API Test Started for POST Validate Nickname....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with the actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set Content-Type to application/json
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"nickname\": \"early_able\"\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/users/validate_nickname");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Notification_Read_All_Test() {
//        System.out.println("Step :: API Test Started for PUT Mark All Notifications as Read....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set Content-Type to application/json
//        request.header("Accept", "application/json"); // Add Accept header for response format
//
//        String requestBody = "{ \"notification_id\": \"Cf19xJ4rGmoi5Ix2WQhXl\" }";
//
//        Response response = request.body(requestBody).put("/api/v3/notification_read");
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Notifications_Test() {
//        System.out.println("Step :: API Test Started for GET Notifications....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Accept", "application/json"); // Add Accept header for response format
//
//        // Define query parameters
//        String firstNotificationId = "Cf19xJ4rGmoi5Ix2WQhXl";
//        int limit = 10;
//
//        // Send the GET request to the endpoint with query parameters
//        Response response = request
//                .param("limit", limit)
//                .param("first_notification_id", firstNotificationId)
//                .get("/api/v3/notifications");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Get_Profile_Communities_Test() { //delete
//        System.out.println("Step :: API Test Started for GET Profile Communities....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Accept", "application/json"); // Add Accept header for response format
//
//        // Define user_id parameter
//        String userId = "cf9000cb-d0f4-4501-ade9-2ba649473636";
//
//        // Send the GET request to the endpoint with query parameter
//        Response response = request
//                .param("user_id", userId)
//                .get("/api/v3/profile/communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Send_Email_Test() {
//        System.out.println("Step :: API Test Started for POST Send Email....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "    \"email_type\": 27,\n" +
//                "    \"to_mail\": [\"himanshu@begenuin.com\"]\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/send_email");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Create_Dynamic_Link_Test() {
//        System.out.println("Step :: API Test Started for POST Create Dynamic Link....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "    \"query_params\": {\n" +
//                "        \"utm_campaign\": \"share\",\n" +
//                "        \"utm_source\": \"localhost\",\n" +
//                "        \"utm_medium\": \"web\",\n" +
//                "        \"action\": \"spark\",\n" +
//                "        \"content_type\": \"video\",\n" +
//                "        \"community\": \"1db1eff982800e7c\",\n" +
//                "        \"loop\": \"1db1f025b4801404\"\n" +
//                "    },\n" +
//                "    \"title\": \"spark 1e3cf08860801411 video\",\n" +
//                "    \"preview_url\": null,\n" +
//                "    \"path_params\": \"/video/1e3cf08860801411\"\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/dynamic_link");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Featured_loops() {
//        System.out.println("Step :: API Test Started for GET Featured Loops....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/featured_loops");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//
//    @Test
//    public void api_Get_Tutorial() {
//        System.out.println("Step :: API Test Started for GET Tutorial....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/tutorial?tutorial_id=5");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//
//    @Test
//    public void api_Get_Conversations_List() {
//        System.out.println("Step :: API Test Started for GET Conversations List....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/conversations_list");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//
//    @Test
//    public void api_Group_Is_GroupEmpty() {
//
//        System.out.println("Step :: API Test Started for GET Group Is Empty....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define user_id parameter
//        String Groupid = "6292245c-bd0b-4eb4-9876-3789ee90615f";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        //Send the response
//        Response response = request.param("user_id", Groupid).get("/api/v3/profile/communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//
//    @Test
//    public void api_Repost_Destinations() {
//
//        System.out.println("Step :: API Test Started for GET Repost Destinations....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String sourceID = "b7b9e718-5068-4549-8ea0-4ec0b3962baf";
//        int contentType = 2;
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("source_video_id", sourceID)
//                .queryParam("content_type", contentType);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/repost/destinations");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//
//    @Test
//    public void api_Community_Requests() {
//        System.out.println("Step :: API Test Started for Community Request....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/community/guidelines");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Feature_Communities() {
//        System.out.println("Step :: API Test Started for Feature Communities....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("api/v3/featured_communities");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Categories_Communities() {
//        System.out.println("Step :: API Test Started for Get categories Communities....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/conversation/messages");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Conversation_Details() {
//        System.out.println("Step :: API Test Started for Get Conversations on Detail ....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Send the DELETE request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/conversation/details");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiConversationMembers() {
//        System.out.println("Step :: API Test Started for GET Conversations Detail....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String slugID = "furniture-finds";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("slug", slugID);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/conversation/members");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiConversationSubscribers() {
//        System.out.println("Step :: API Test Started for GET Conversations subscribers....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String slugID = "furniture-finds";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("slug", slugID);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/conversation/subscribers");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiConversationRequesters() {
//        System.out.println("Step :: API Test Started for GET Conversations Requesters....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String chat_id = "abe2f712-a788-41e1-9784-ead203cbec00";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("chat_id", chat_id);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/conversation/requestors");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiMentions() {
//        System.out.println("Step :: API Test Started for GET Mentions....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String chat_id = "abe2f712-a788-41e1-9784-ead203cbec00";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("chat_id", chat_id);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/mentions");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiQueuesNickname() {
//        System.out.println("Step :: API Test Started for GET QueuesNickname....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String nickname = "test";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("nickname", nickname);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/queues/test");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Socket_connections() {
//        System.out.println("Step :: API Test Started for GET socket_connections ....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String nickname = "test";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("nickname", nickname);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/socket_connections/test");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_web_meta_data() {
//        System.out.println("Step :: API Test Started for GET Web Meta data ....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String nickname = "test";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("type", 1)
//                .queryParam("brand_id", 12)
//                .queryParam("domain", "sp.com")
//                .queryParam("subdomain", "sanket")
//                .queryParam("username", "sanketUser")
//                .queryParam("slug", "sanketUser");
//
//        // Send the GET request
//        Response response = request.get("/api/v3/web/meta_data");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiBrandDetail() {
//        System.out.println("Step :: API Test Started for GET Brand Detail....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        int brand_id = 1429;
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("brand_id", brand_id);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/brand/detail");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiBrandGuidelines() {
//        System.out.println("Step :: API Test Started for GET Brand Guidelines....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Define parameters
//        String is_default = "true";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json")  // Correct header for JSON requests
//                .queryParam("is_default", is_default);
//
//        // Send the GET request
//        Response response = request.get("/api/v3/brand/guidelines");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Store_UTM_Data_Test() {
//        System.out.println("Step :: API Test Started for POST Store UTM Data....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"token\": \"ztf7eMtnD7xyV7KRtae1URfI2AxmLcU1bXx2RrsU04E=\",\n" +
//                "  \"utm_data\": {\n" +
//                "    \"utm_medium\": \"web\",\n" +
//                "    \"utm_campaign\": \"share\",\n" +
//                "    \"utm_source\": \"web\",\n" +
//                "    \"action\": \"subscribe\",\n" +
//                "    \"from_username\": \"hiren\",\n" +
//                "    \"content_id\": \"13f3348fd5801493\",\n" +
//                "    \"content_type\": \"loop\"\n" +
//                "  }\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/store_utm_data");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//
//    }
//
//    @Test
//    public void api_Embed_Test() {
//        System.out.println("Step :: API Test Started for POST Embed....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"embed_type\": 1,\n" +
//                "  \"emails\": [\n" +
//                "    \"shubh@begenuin.com\",\n" +
//                "    \"himanshu@begenuin.com\"\n" +
//                "  ],\n" +
//                "  \"id\": \"36e78877-004c-4052-9373-71e97ea76166\"\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/embed");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_User_Topics_Test() {
//        System.out.println("Step :: API Test Started for POST Users Topics....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the request body
//        String requestBody = "{\n" +
//                "  \"topicIds\": [\n" +
//                "    1,\n" +
//                "    2,\n" +
//                "    3\n" +
//                "  ]\n" +
//                "}";
//
//        // Send the POST request to the endpoint
//        Response response = request
//                .body(requestBody)
//                .post("/api/v3/users/topics");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Post_User_Flag_Test() {
//        System.out.println("Step :: API Test Started for POST Users Flag....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        request.header("Content-Type", "application/json"); // Set content type for JSON
//
//        // Define the user ID to be flagged
//        String userId = "b92c8231-9dbe-437a-9b97-bacbf9a33946";
//
//        // Send the POST request to the endpoint
//        Response response = request.post("/api/v3/users/flag/" + userId);
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiSearchRecent() {
//        System.out.println("Step :: API Test Started for search recent....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request
//        RequestSpecification request = RestAssured.given()
//                .header("Authorization", "Bearer " + gnAccessToken)  // Ensure token is valid
//                .header("Content-Type", "application/json");
//
//        // Send the GET request
//        Response response = request.get("/api/v3/global_search/recent");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void apiSearchRecentDelete() {
//        System.out.println("Step :: API Test Started for search recent delete....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//        // Add query parameter
//        request.queryParam("delete_all", "true");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .delete("/api/v3/global_search/recent");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_video_validateUrl_Test()
//    {
//
//        System.out.println("Step :: API Test Started");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        String requestBody = "{ \"url\": \"any\" }";
//
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .body(requestBody)
//                .post("/api/v3/users/video/validate_url");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_Users_deeplink_metadata_Test()
//    {
//        System.out.println("Step :: API Test Started...");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("api/v3/deep_link/meta_data?slug=example-of-slig&type=1&username=trigon&uuid=2409d299-9518-48e9-b7d7-8951c4a8f2df&brand_id=1&invitation_id=661fb13eaebb4e04039adb91");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_User_delete_Test()
//    {
//        System.out.println("Step :: API Test Started for search recent delete....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//        //request.queryParam("delete_all", "true");
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .delete("/api/v3/users/delete");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_sitemp_links_Test()
//    {
//        System.out.println("Step :: API Test Started....");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/sitemap/links?domain=sppp&subdomain=sppp&type=1&page=1");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_sitmap_total_count_Test()
//    {
//
//        System.out.println("Step :: API Test Started...");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("api/v3/sitemap/total_count?domain=sppp&subdomain=sppp");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_get_Brand_feed_Test()
//    {
//        System.out.println("Step :: API Test Started...");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        //request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .get("/api/v3/brand/feed?brand_id=1429");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_video_crateUploadUrl_Test()
//    {
//        System.out.println("Step :: API Test Started");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        String requestBody = "{ \"contentType\": \"audio/wav\", \"path\": \"audio/659e9bb4-fc10-4dce-a856-20bff0e9f387_1632915580779.mp3\" }";
//
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .body(requestBody)
//                .post("/api/v3/users/video/upload/create_upload_url");
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_default_mediumfeed_Test()
//    {
//        common.logPrint("Step :: API Test Started....");
//        //set base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        //create the request
//        RequestSpecification request = RestAssured.given();
////        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response=request
//                .contentType("application/json")
//                .get("/medium-feed");
//
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_default_healthcheck_Test()
//    {
//        common.logPrint("Step :: API Test Started....");
//        //set base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        //create the request
//        RequestSpecification request = RestAssured.given();
////        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response=request
//                .contentType("application/json")
//                .get("/healthcheck");
//
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_developer_socketConnection_username_Test()
//    {
//        common.logPrint("Step :: API Test Started....");
//        //set base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        //create the request
//        RequestSpecification request = RestAssured.given();
////        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        Response response=request
//                .contentType("application/json")
//                .get("/api/v3/socket_connections/hg");
//
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_community_genrateloopdata_Test()
//    {
//        System.out.println("Step :: API Test Started");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com"; // Replace {{baseUrl}} with your actual base URL
//
//        // Create the request
//        RequestSpecification request = RestAssured.given();
//        request.header("Authorization", "Bearer " + gnAccessToken); // Add Bearer token for authentication
//
//
//        String requestBody = "{\n" +
//                "    \"loop\": {\n" +
//                "        \"name\": \"Style Sphere\",\n" +
//                "        \"description\": \"A trendy spot for youth to discuss and share the latest fashion and beauty trends.\"\n" +
//                "    }\n" +
//                "}";
//        // Send the GET request to the endpoint
//        Response response = request
//                .contentType("application/json")
//                .body(requestBody)
//                .post("/api/v3/generate_loop_data");
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//
//    @Test
//    public void api_V3_Search_Top() {
//        System.out.println("Step :: API Test Started for GET Search Top...");
//
//        // Set the base URI
//        RestAssured.baseURI = "https://nodejs.qa.begenuin.com";
//
//        // Create the request specification
//        RequestSpecification request = RestAssured.given();
//
//        // Add headers (Authorization)
//        request.header("Authorization", "Bearer " + gnAccessToken);
//
//        // Define query parameters
//        String chatId = "12345"; // Replace with actual value
//        String communityId = "67890"; // Replace with actual value
//        String slug = "test-slug"; // Replace with actual value
//        String queryString = "search-term"; // Replace with actual value
//
//        // Send the GET request with query parameters
//        Response response = request
//                .contentType("application/json")
//                .queryParam("chat_id", chatId)
//                .queryParam("community_id", communityId)
//                .queryParam("slug", slug)
//                .queryParam("query_string", queryString)
//                .get("/api/v3/search/top");
//
//        // Log the response status code and body
//        System.out.println("Step :: Response Status Code: " + response.getStatusCode());
//        System.out.println("Step :: Response Body: " + response.getBody().asString());
//
//        // Assert the response status code is 200 (OK)
//        Assert.assertEquals(response.getStatusCode(), 200, "Invalid Status Code");
//    }
//}
//
