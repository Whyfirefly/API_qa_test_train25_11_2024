import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.hamcrest.MatcherAssert;

//Напиши тест с вызовом ручки в классе.
// Получи ответ в виде объекта класса. Проверь, что объект не равен null.
public class DeserialiszationUserDataTest {

  @Before
  public void setUp() {
    RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
  }

  @Test
  public void checkUserName() {
        User user = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU")
            .get("/api/users/me")
                .body().as(User.class);
    // напиши код для десериализации ответа в объект типа User
    // выбери подходящий assert
    MatcherAssert.assertThat(user, notNullValue()) ;
  }

}
