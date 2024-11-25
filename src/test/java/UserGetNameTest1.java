import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class UserGetNameTest1 {

  @Before
  public void setUp() {
    RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
  }

  @Test
  public void checkUserName() {
    given()
            .auth().oauth2("вводим_сюда_свой_токен_JWT")
            .get("/api/users/me")
            .then().assertThat()
            .statusCode(200) // проверь статус ответа
            .body("data.name", equalTo("Аристарх Сократович"));
  }

}