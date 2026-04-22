package msl.qa;

import msl.qa.db.NoteRepository;
import msl.qa.db.UserRepository;
import msl.qa.service.Session;
import msl.qa.ui.LoginUiComponent;
import msl.qa.ui.MainUiComponent;
import msl.qa.ui.UiContainer;

public class Main {
  public static void main(String[] args) {
    try {
      new UiContainer(
              new LoginUiComponent(new UserRepository.MockUserRepository()),
              new MainUiComponent(new NoteRepository.MockNoteRepository())
      ).render(new Session.EmptySession());

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}