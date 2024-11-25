import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class UserGetNameTest2 {

  @Before
  public void setUp() {
    RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
  }

  //С помощью автотеста проверь, правильно ли указано занятие пользователя.
  // Выводим тело ответа на экран.
  @Test
  public void checkUserActivityAndPrintResponseBody() {

    // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
    Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzA2MzIyZDdiZDFlZDAwM2RlMjQ3ZTgiLCJpYXQiOjE3MzI1NTQyODksImV4cCI6MTczMzE1OTA4OX0.wHQZXqfb6yg_PWURnEcLdQAm1fdo8nWSSRmAGtKYlrU").get("/api/users/me");
    // проверяет, что в теле ответа ключу about соответствует нужное занятие
    response.then().assertThat().body("data.about",equalTo("Автор автотестов"));
    // выводит тело ответа на экран
    System.out.println(response.body().asString());
  }

}