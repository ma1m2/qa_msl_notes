package msl.qa.service;

import msl.qa.domain.User;

public interface Session {

  User unwrap();

  class EmptySession implements Session {
    @Override
    public User unwrap() {
      System.out.println("### Empty session");
      throw new UnsupportedOperationException(
              "EmptySession cannot unwrap - no user exists. " +
                      "Check if user is logged in before calling unwrap()."
      );
    }
  }
}
