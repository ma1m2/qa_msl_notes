package msl.qa.ui;

import msl.qa.service.Session;

public interface UiComponent {

  Session render(Session session);

  class MockUiComponent implements UiComponent {
    @Override
    public Session render(Session session) {
      System.out.println("### MockUiComponent!");
      return session;
    }
  }
}
