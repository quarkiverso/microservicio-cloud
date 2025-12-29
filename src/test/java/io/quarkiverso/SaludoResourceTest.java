package io.quarkiverso;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class SaludoResourceTest {

    @Test
    void testSaludoEndpoint() {
        given()
          .when().get("/saludo?nombre=Quarkiverso")
          .then()
             .statusCode(200)
             .body(containsString("Quarkiverso"));
    }

    @Test
    void testHealthLive() {
        given()
          .when().get("/q/health/live")
          .then()
             .statusCode(200);
    }

    @Test
    void testHealthReady() {
        given()
          .when().get("/q/health/ready")
          .then()
             .statusCode(200);
    }

    @Test
    void testHealthStarted() {
        given()
          .when().get("/q/health/started")
          .then()
             .statusCode(200);
    }
}

