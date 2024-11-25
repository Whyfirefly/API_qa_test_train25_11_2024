import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ProfileTest {

  @Before
  public void setUp() {
    RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
  }
  Profile card = new Profile("Василий Васильев", "Самый крутой исследователь");

  @Test
  public void updateProfile() {
    // создаём объект, который соответствует JSON
    Profile profile  = new Profile("Василий Васильев", "Самый крутой исследователь"); // создай объект, который соответствует JSON
    given()
            .header("Content-type", "application/json") // заполняем header
            .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU")
            .and()
            .body(profile) // заполняем body
            .when()
            .patch("/api/users/me")// отправь запрос на ручку
             .then().assertThat()
            .statusCode(200);
  }
}

