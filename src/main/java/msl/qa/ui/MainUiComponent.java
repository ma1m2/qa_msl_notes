package msl.qa.ui;

import msl.qa.db.NoteRepository;
import msl.qa.domain.Note;
import msl.qa.domain.User;
import msl.qa.service.Session;

import javax.swing.*;
import java.util.List;

public class MainUiComponent implements UiComponent{

  private final NoteRepository noteRepo;

  public MainUiComponent(NoteRepository noteRepo) {
    this.noteRepo = noteRepo;
  }

  @Override
  public Session render(Session session) {
    final User user = session.unwrap();
    List<Note> currentNotes = noteRepo.findAllByUsername(user.username());
    renderNotes(currentNotes);
    final String newNoteText = JOptionPane.showInputDialog("Enter new notes: ");
    noteRepo.save(new Note(user.username(), newNoteText));
    renderNotes(currentNotes);
    int flag = getConfirmation();
    if (flag == 0) {
      return render(session);
    }else {
      System.exit(0);
    }
    return session;
  }

  private int getConfirmation() {
    return JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to continue?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
    );
  }

  private void renderNotes(List<Note> notes) {
    JOptionPane.showMessageDialog(
            null,
            notes,
            "Current notes: ",
            JOptionPane.INFORMATION_MESSAGE
    );

  }
}
