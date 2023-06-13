package com.example.services;

import com.example.entity.Note;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Getter
    private List<Note> notes = new ArrayList<>();
    public Note add(Note note) {
        notes.add(note);
        return note;
    }

    public List<Note> listAll() {
        return notes;
    }

    @SneakyThrows
    public Note getById(long id) {

        for (Note readNote: notes) {
            if (readNote.getId()== id) return readNote;
        }
        throw new Exception("note not found");
    }

    public void deleteById(long id)  {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) notes.remove(i);
        }
    }

    @SneakyThrows
    public void update(Note note) {
        for (Note readNote: notes) {
            if (readNote.getId()==note.getId()) {
                readNote.setTitle(note.getTitle());
                readNote.setContent(note.getContent());
            }
        }

    }

}
