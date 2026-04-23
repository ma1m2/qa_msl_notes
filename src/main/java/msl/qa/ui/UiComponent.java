package msl.qa.ui;

import msl.qa.service.Session;

import java.io.IOException;

public interface UiComponent {

  Session render(Session session) throws IOException;

  class MockUiComponent implements UiComponent {
    @Override
    public Session render(Session session) {
      System.out.println("### MockUiComponent!");
      return session;
    }
  }
}
