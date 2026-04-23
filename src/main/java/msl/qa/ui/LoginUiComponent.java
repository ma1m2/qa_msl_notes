package msl.qa.ui;

import msl.qa.db.UserRepository;
import msl.qa.domain.User;
import msl.qa.service.PasswordEncoder;
import msl.qa.service.Session;
import msl.qa.service.UserSession;

import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class LoginUiComponent implements UiComponent {

  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;

  public LoginUiComponent(UserRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Session render(Session session){
    final String username = JOptionPane.showInputDialog("Enter username");
    final String password = JOptionPane.showInputDialog("Enter password");
    System.out.println("### username: " + username);
    System.out.println("### password: " + password);

    Optional<User> optionalUser = userRepo.findByUsername(username);
    if (optionalUser.isEmpty()) {
      showError();
      return render(session);
    }

    User fromRepo = optionalUser.get();
    if(!fromRepo.isPasswordValid(passwordEncoder.encode(password))){
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
