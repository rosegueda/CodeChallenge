package apiTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BreakingBadTests extends ApiUtilities {

    @Test(priority = 0)
    public void Walter_White_Birthday() {
        //ApiUtilities au = new ApiUtilities();
        //CharacterName("Walter");

        List <String> Birthdays = GetBirthdaysFromIDs(CharacterName("Walter"));
        for(String birthday : Birthdays){
            System.out.println(birthday);
        }
    }

    @Test(priority = 1)
    public void characters_information_store_into_POJOModel() {
        NamesAndPortrayed();
    }
}
