package tests;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestsRestAssured {
    @Test (priority = 10)
    public void Walter_White_Birthday(){
        RestAssured.baseURI = "https://breakingbadapi.com/api";
        Response response = given().contentType(ContentType.JSON).get("/characters/1");
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String name = jsonPathEvaluator.get("name");
        JsonPath jsonPath = response.jsonPath();
        String birthday = jsonPath.getString("birthday");
        //response.prettyPrint();
        System.out.println("Walter White's Birthday is: "+birthday);
    }
    @Test (priority = 11)
    public void Print_Headers_Body_ConteType(){
        Response response = given()
                .get("https://breakingbadapi.com/api/characters/1");
        Headers headers = response.getHeaders();
        int statusCode = response.getStatusCode();
        String body = response.getBody().asString();
        String contentType = response.getContentType();

        System.out.println("Headers: "+headers);
        System.out.println("Body: "+ body);
        System.out.println("Content Type: "+contentType);
    }

    @Test (priority = 12)
    public void characters_information_store_into_POJOModel(){

    }

}
