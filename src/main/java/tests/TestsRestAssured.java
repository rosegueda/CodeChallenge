package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pageObjects.CharactersInformation;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class TestsRestAssured {
    @Test(priority = 10)
    public void Walter_White_Birthday() {
        RestAssured.baseURI = "https://breakingbadapi.com/api";
        Response response = given().contentType(ContentType.JSON).get("/characters/1");
//        Response response = given().contentType(ContentType.JSON).get("");
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String name = jsonPathEvaluator.get("name");
        JsonPath jsonPath = response.jsonPath();
        String birthday = jsonPath.getString("birthday");
        //response.prettyPrint();
        System.out.println("Walter White's Birthday is: "+birthday);
    }

    @Test(priority = 11)
    public void Print_Headers_Body_ConteType() {
        Response response = given()
                .get("https://breakingbadapi.com/api/characters/1");
        Headers headers = response.getHeaders();
        int statusCode = response.getStatusCode();
        String body = response.getBody().asString();
        String contentType = response.getContentType();

        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        System.out.println("Content Type: " + contentType);
    }

    @Test(priority = 12)
    public void characters_information_store_into_POJOModel() {
//        RestAssured.baseURI = "https://breakingbadapi.com/api";
//        //Response response = given().contentType(ContentType.JSON).get("/characters/1");
//        //Response response = given().contentType(ContentType.JSON).get("");
//        Response response = given().get("/characters");
//        //Response response = given().get("/characters");
//
//        //Response response = given().get("");
//        ResponseBody body = response.getBody();
//        response.prettyPrint();
//        //List<CharactersInformation> charactersInformationList = Arrays.asList(response.getBody().as(CharactersInformation.class));
//        List<CharactersInformation> charactersInformationList = Arrays.asList(body.as(CharactersInformation[].class));
//      //  CharactersInformation responseBody = body.as(CharactersInformation[].class);
//        CharactersInformation responseBody = body.as(CharactersInformation.class);
//        System.out.println(responseBody.characters);

//        CharactersInformation ci= new CharactersInformation();
//        System.out.println(ci.characters);


        RestAssured.baseURI = "https://breakingbadapi.com/api";
        Response response = given().contentType(ContentType.JSON).get("/characters");
//        Also works!!: V
//        Response response = RestAssured.given().get("https://breakingbadapi.com/api/characters");
        Gson gson = new GsonBuilder().create();
        CharactersInformation[] charactersList = gson.fromJson(response.asString(), CharactersInformation[].class);
        for (CharactersInformation l : charactersList) {
            System.out.println("Character Name: \"" + l.name+"\"");
            System.out.println("Portrayed: \"" + l.portrayed+"\"");
            System.out.println("----------------------------------");

        }
    }
}
