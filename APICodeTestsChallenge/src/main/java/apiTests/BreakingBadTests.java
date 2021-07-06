package apiTests;

import POJOS.CharactersInformation;
import utilities.ApiUtilities;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BreakingBadTests extends ApiUtilities {

    @Test(priority = 0)
    public void Walter_White_Birthday() {
        List <String> Birthdays = GetBirthdaysFromIDs(GetIDfromCharacterName("Walter White"));
        for(String birthday : Birthdays){
            System.out.println("Walter White's birthday is: "+birthday);
        }
    }

    @Test(priority = 1)
    public void characters_information_store_into_POJOModel() {
        for (CharactersInformation l : POJOListCharacters()) {
            System.out.println("Character Name: \"" + l.getName() + "\"");
            System.out.println("Portrayed by: \"" + l.getPortrayed() + "\"");
            System.out.println("----------------------------------");
        }
    }
}
