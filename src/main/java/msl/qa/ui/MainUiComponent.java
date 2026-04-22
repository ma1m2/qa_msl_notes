package msl.qa.ui;

import msl.qa.service.Session;

public class MainUiComponent implements UiComponent{

  @Override
  public Session render(Session session) {
    System.out.println("### Session: " + session.unwrap().username());
    return session;
  }
}
