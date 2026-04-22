package msl.qa.db;

import msl.qa.domain.User;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findByUsername(String username);

  class MockUserRepository implements UserRepository {
    @Override
    public Optional<User> findByUsername(String username) {
      if ("sveta".equals(username)) {
        return Optional.of(new User("sveta", "1234"));
      } else {
        System.out.println("### Bad credentials");
      }
      return Optional.empty();
    }
  }

}
