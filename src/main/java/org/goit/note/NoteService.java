package org.goit.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        if (notes.isEmpty()) {
            note.setId(1L);
        } else {
            note.setId(Collections.max(notes.keySet()) + 1);
        }
        return notes.put(note.getId(), note);
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new RuntimeException("The note is missing.");
        }
    }

    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else {
            throw new RuntimeException("The note is missing.");
        }
    }

    public Note getById(long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else {
            throw new RuntimeException("The note is missing.");
        }
    }
}
