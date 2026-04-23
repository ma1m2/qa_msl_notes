package msl.qa.ui;

import msl.qa.service.Session;

import java.io.IOException;

public class UiContainer implements UiComponent {

  private final UiComponent[] comps;

  public UiContainer(UiComponent... comps) {
    this.comps = comps;
  }

  @Override
  public Session render(Session session) throws IOException {
    Session currentSession = session;

    for (UiComponent comp : comps) {
      currentSession = comp.render(currentSession);
    }
    return currentSession;
  }
}
