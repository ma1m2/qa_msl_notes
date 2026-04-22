package msl.qa.ui;

import msl.qa.db.UserRepository;
import msl.qa.domain.User;
import msl.qa.service.Session;
import msl.qa.service.UserSession;

import javax.swing.*;
import java.util.Optional;

public class LoginUiComponent implements UiComponent {

  private final UserRepository _userRepo;

  public LoginUiComponent(UserRepository _userRepo) {
    this._userRepo = _userRepo;
  }

  @Override
  public Session render(Session session) {
    final String username = JOptionPane.showInputDialog("Enter username");
    final String password = JOptionPane.showInputDialog("Enter password");
    System.out.println("### username: " + username);
    System.out.println("### password: " + password);

    Optional<User> optionalUser = _userRepo.findByUsername(username);
    if (optionalUser.isEmpty()) {
      showError();
      return render(session);
    }

    User fromRepo = optionalUser.get();
    if(!fromRepo.isPasswordValid(password)){
      showError();
      return render(session);
    }
    return new UserSession(fromRepo);
  }

  private void showError() {
    JOptionPane.showMessageDialog(
            null,
            "Bad credentials",
            "error",
            JOptionPane.ERROR_MESSAGE
    );
  }

}
