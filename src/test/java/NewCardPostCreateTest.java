import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NewCardPostCreateTest {

  @Before
  public void setUp() {
    RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
  }

  //POST-запрос обычно добавляет данные
  //PATCH запрос — обновляет данные
  //PATCH-запрос может обновить объект целиком или только некоторые поля.
  @Test
  public void createNewPlaceAndCheckResponseJsonInFile(){
    File json = new File("src/test/resources/newCard.json");
    Response response =
            given()
                    .header("Content-type", "application/json")
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU")
                    .and()
                    .body(json)
                    .when()
                    .post("/api/cards");
    response.then().assertThat().body("data._id", notNullValue())
            .and()
            .statusCode(201);
    System.out.println(response.body().asString());
  }

  //Если JSON небольшой,
  // его можно передать в тело запроса через строковую переменную, а не в файле.
  //Если в строке есть кавычки, их нужно экранировать — добавить перед ними символ \.
  @Test
  public void createNewPlaceAndCheckResponseJsonNotInFile(){
    String json = "{\"name\": \"Очень интересное место2\", \"link\": \"https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg\"}";
    Response response =
            given()
                    .header("Content-type", "application/json")
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU")
                    .and()
                    .body(json)
                    .when()
                    .post("/api/cards");
    response.then().assertThat().body("data._id", notNullValue())
            .and()
            .statusCode(201);
    System.out.println(response.body().asString());
  }

  //PATCH запрос — обновляет данные
  //PATCH-запрос может обновить объект целиком или только некоторые поля.
  @Test
  public void createNewPlaceAndCheckResponsePatchRefresh(){
    File json = new File("src/test/resources/newCard.json");
    Response response =
            given()
                    .header("Content-type", "application/json")
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU")
                    .and()
                    .body(json)
                    .when()
                    .patch("/api/users/me");
    response.then().assertThat().body("data._id", notNullValue())
            .and()
            .statusCode(201);
    System.out.println(response.body().asString());

  }

}
