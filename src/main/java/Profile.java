public class Profile {

  // ключ name стал полем типа String
  private String name;
  // ключ about стал полем типа String
  private String about;

  // конструктор со всеми параметрами
  public Profile(String name, String about) {
    this.name = name;
    this.about = about;
  }
  // конструктор без параметров
  public Profile() {

  }

  // геттер для поля name
  public String getName() {
    return name;
  }

  // сеттер для поля name
  public void setName(String name) {
    this.name = name;
  }

  // геттер для поля about
  public String getAbout() {
    return about;
  }

  // сеттер для поля about
  public void setAbout(String about) {
    this.about = about;
  }

}