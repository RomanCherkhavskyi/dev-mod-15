package com.example.services;

import com.example.entity.Note;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService  {

    private final NoteRepository repository;
    private final Map<Long, Note> notes = new HashMap<>();




    public Note add(Note note) {
        repository.save(note);
        System.out.println(note);
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
//        repository.findById(note.getId())
//                .stream()
//                .findAny()
//                .orElseThrow(() -> {
//                    throw new NoSuchElementException("The note is missing.");
//                });
//        repository.save(note);
    }
    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    private long generateUniqueId(){
        return new Random().nextLong();
    }


}
