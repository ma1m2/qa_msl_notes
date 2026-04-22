package msl.qa.service;

import msl.qa.domain.User;

public interface Session {

  User unwrap();

  class EmptySession implements Session {
    @Override
    public User unwrap() {
      return null;
    }
  }
}
