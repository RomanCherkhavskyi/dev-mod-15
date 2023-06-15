package com.example.services;

import com.example.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    public Note add(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public Note getById(long id) {
        if(!notes.containsKey(id)){
            throw new NoSuchElementException("Note with id " + id + " does not exist.");
        }else{
            return notes.get(id);
        }
    }

    public void deleteById(long id)  {
        if(!notes.containsKey(id)){
            throw new NoSuchElementException("Note with id " + id + " does not exist.");
        }else{
            notes.remove(id);
        }
    }

    public void update(Note note) {
        if(!notes.containsKey(note.getId())){
            throw new NoSuchElementException("Note with id " + note.getId() + " does not exist.");
        }else{
            notes.put(note.getId(), note);
        }
    }
    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    private long generateUniqueId(){
        return new Random().nextLong();
    }


}
