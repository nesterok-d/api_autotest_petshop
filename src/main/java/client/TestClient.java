package client;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import pages.Pet;
import props.TestConfig;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@AllArgsConstructor
public class TestClient {

    private String baseUri;


    public TestClient() {
        this(TestConfig.Uri.value);
    }

    private RequestSpecification getRequestSpec() {
        return given().
                baseUri(baseUri).
                contentType(JSON).
                log().all();
    }

    private RequestSpecification getRequestSpec(Object body) {
        return getRequestSpec().
                body(body);
    }

    public ValidatableResponse create(Pet pet) {

        ValidatableResponse response = getRequestSpec(pet).when().
                post("/pet").
                then().log().all();

        return response;
    }
}