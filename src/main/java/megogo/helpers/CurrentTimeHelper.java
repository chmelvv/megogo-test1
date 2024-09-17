package megogo.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CurrentTimeHelper extends APIHelper {
    static final String endpoint = "/time";

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_EGP_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ValidatableResponse getCurrentTime() {
        return given()
                    .spec(getRequestSpecification())
                    .log().all()
                .when()
                    .get(endpoint)
                .then()
                    .log().all()
                    .statusCode(200);
    }
}