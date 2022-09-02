import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pages.Pet;
import props.TestConfig;

import static io.restassured.RestAssured.given;
@Test
public class addPetTestClass {
    @Test
    public void testAddPet() {
        String name = "Bony";
        Pet pet = new Pet(name);
        given().baseUri(TestConfig.Uri.value).
                contentType(ContentType.JSON).
                body(pet).
                log().all().
        when().post("pet").
                then().assertThat().
                statusCode(200).
                body("id", Matchers.notNullValue()).
                body("name", Matchers.equalTo("Bony")).
                log().all();
    }

}
