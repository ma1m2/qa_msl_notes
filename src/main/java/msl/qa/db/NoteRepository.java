package msl.qa.db;

import msl.qa.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface NoteRepository {

  List<Note> findAllByUsername(String username);

  void save(Note note);

  class MockNoteRepository implements NoteRepository {
    private List<Note> store = new ArrayList<Note>(
            List.of(
                    new Note("sveta", "Come on, get it together!"),
                    new Note("sveta", "Do something!")
                    )
    );

    @Override
    public List<Note> findAllByUsername(String username) {
      if("sveta".equals(username)) {
        return store;
      }
      return Collections.emptyList();
    }

    @Override
    public void save(Note note) {
      if("sveta".equals(note.username())) {
        store.add(note);
      }
    }
  }

}
