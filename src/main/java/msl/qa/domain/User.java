package msl.qa.domain;

public class User {
  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String username() {
    return username;
  }

  public boolean isPasswordValid(String password) {
    return this.password.equals(password);
  }
}
