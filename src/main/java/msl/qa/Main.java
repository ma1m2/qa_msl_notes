package msl.qa;

import msl.qa.db.FileUserRepository;
import msl.qa.db.NoteRepository;
import msl.qa.db.UserRepository;
import msl.qa.service.Base64PasswordEncoder;
import msl.qa.service.Session;
import msl.qa.ui.LoginUiComponent;
import msl.qa.ui.MainUiComponent;
import msl.qa.ui.UiContainer;

import java.nio.file.Path;

public class Main {
  public static void main(String[] args) {
    try {
      new UiContainer(
              new LoginUiComponent(
                      new FileUserRepository(Path.of("src/main/resources/users.csv")),
                      new Base64PasswordEncoder()),
              new MainUiComponent(new NoteRepository.MockNoteRepository())
      ).render(new Session.EmptySession());

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}