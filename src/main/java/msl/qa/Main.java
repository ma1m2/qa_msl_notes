package msl.qa;

import msl.qa.db.UserRepository;
import msl.qa.domain.User;
import msl.qa.service.Session;
import msl.qa.ui.LoginUiComponent;
import msl.qa.ui.MainUiComponent;
import msl.qa.ui.UiContainer;

public class Main {
  public static void main(String[] args) {
    try {
      new UiContainer(
              new LoginUiComponent(new UserRepository.MockUserRepository()),
              new MainUiComponent()
      ).render(new Session.EmptySession());

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}