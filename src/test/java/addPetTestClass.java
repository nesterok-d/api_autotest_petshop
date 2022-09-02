import client.TestClient;
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
        TestClient client = new TestClient();

        client.create(pet).assertThat().
                statusCode(200).
                body("id", Matchers.notNullValue()).
                body("name", Matchers.equalTo("Bony")).
                log().all();
    }

}
