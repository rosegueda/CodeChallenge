package apiTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://breakingbadapi.com";
        RestAssured.basePath = "/api";
    }

    public List<Integer> GetIDfromCharacterName(String inputName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .get("/characters?name=" + inputName)
                .then().statusCode(200)
                .extract().response();
        //response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        List<Integer> char_id = jsonPath.getList("char_id");
//        List<String> birthday = jsonPath.getList("birthday");
//        List<String> name = jsonPath.getList("name");

//        for (int a = 0; a < birthday.size(); a++) {
//            System.out.println(name.get(a)+"'s Birthday is: " + birthday.get(a));
//        }
        return char_id;

    }

    public List<String> GetBirthdaysFromIDs(List<Integer> ids) {
//        for(int a = 0; a < ids.size(); a++){
//        }
        List<String> birthdays = new ArrayList<>();
        for (Integer id : ids) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .get("/characters/" + id)
                    .then().statusCode(200)
                    .extract().response();
            JsonPath jsonPath = response.jsonPath();
            String birthday = jsonPath.getString("birthday");
            birthdays.add(birthday);
        }
        return birthdays;
    }

    public void NamesAndPortrayed() {
        Response response = given().contentType(ContentType.JSON).get("/characters")
                .then().statusCode(200)
                .extract().response();
        ;
//        Also works!!: V
//        Response response = RestAssured.given().get("https://breakingbadapi.com/api/characters");
        Gson gson = new GsonBuilder().create();
        CharactersInformation[] charactersList = gson.fromJson(response.asString(), CharactersInformation[].class);
        for (CharactersInformation l : charactersList) {
            System.out.println("Character Name: \"" + l.getName() + "\"");
            System.out.println("Portrayed: \"" + l.getPortrayed() + "\"");
            System.out.println("----------------------------------");
        }
    }

    public CharactersInformation[] POJOListCharacters() {
        Response response = given().contentType(ContentType.JSON).get("/characters")
                .then().statusCode(200)
                .extract().response();
        ;
//        Also works!!: V
//        Response response = RestAssured.given().get("https://breakingbadapi.com/api/characters");
        Gson gson = new GsonBuilder().create();
        CharactersInformation[] charactersList = gson.fromJson(response.asString(), CharactersInformation[].class);
        return charactersList;
    }

}